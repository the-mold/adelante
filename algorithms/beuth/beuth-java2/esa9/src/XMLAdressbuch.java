import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Class to read contact data from a xml file.
 *
 * @author pm
 * @version 1.1, 11/2020
 */
public class XMLAdressbuch {
    // Locally:
    // private static final String XMLDateiName = "esa9/src/adressen2.xml";
    private static final String XMLDateiName = "adressen2.xml";
    private static final ArrayList<String> nameLastnameList = new ArrayList<>();
    private static final ArrayList<Kontakt> contactList = new ArrayList<>();
    private static Element documentElement;

    // const types and fields
    private static final String fieldName = "Name";
    private static final String fieldVorname = "Vorname";
    private static final String fieldNachname = "Nachname";
    private static final String fieldKontakt = "Kontakt";
    private static final String attrTyp = "typ";
    private static final String fieldAdresse = "Adresse";
    private static final String fieldStrasse = "Strasse";
    private static final String fieldPLZ = "PLZ";
    private static final String fieldOrt = "Ort";
    private static final String fieldLand = "Land";

    /**
     * Method to test the XMLAdressbuch
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // 1. read file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document dokument = builder.parse(new File(XMLDateiName));

        XMLAdressbuch d = new XMLAdressbuch(dokument.getDocumentElement());

        // 2. get all names and last names
        d.getAlleNamen();
        System.out.println("Result: " + nameLastnameList);

        //3. get contact list by names
        d.getAdressenDaten("Max","Mustermann");
        System.out.println("Result: " + contactList);

        d.getAdressenDaten("Moritz","Makler");
        System.out.println("Result: " + contactList);
    }

    /**
     * Constructor method for XMLAdressbuch.
     *
     * @param documentElement is a dom element.
     */
    public XMLAdressbuch (Element documentElement) {
        this.documentElement = documentElement;
    }

    /**
     * Method to retrieve all first and last names from the xml file.
     *
     * @return ArrayList<String>, list of all first and last name pairs.
     */
    public ArrayList<String> getAlleNamen() {
        // clean old result
        nameLastnameList.clear();

        // read all given and last names
        getAlleNamenInner(this.documentElement);

        return nameLastnameList;
    }

    /**
     * Recursive helper method for the getAlleNamen.
     */
    private static void getAlleNamenInner(Element e) {
        NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (node.getNodeName().equals(fieldName)) {
                processNames(node);
            } else {
                getAlleNamenInner((Element) node);
            }
        }
    }

    /**
     * Method to process first and last name of a contact.
     */
    private static void processNames(Node node) {
        String givenName = "";
        String lastName = "";
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node n = children.item(i);
            if (n.getNodeName().equals(fieldVorname)) {
                givenName = n.getTextContent();
            }
            else if (n.getNodeName().equals(fieldNachname)) {
                lastName = n.getTextContent();
            }
        }

        // save to array list
        if (!givenName.isEmpty() && !lastName.isEmpty()) {
            nameLastnameList.add(givenName + " " + lastName);
        }
    }

    /**
     * Method to turn contact from a xml file, into a list of Kontakt objects.
     *
     * @return ArrayList<Kontakt>, list of Kontakt objects.
     */
    public ArrayList<Kontakt> getAdressenDaten(String vorname, String nachname) {
        contactList.clear();

        // early return for invalid params
        if (vorname.isEmpty() || nachname.isEmpty()) {
            return contactList;
        }

        this.getAdressenDatenInner(vorname, nachname);

        return contactList;
    }

    /**
     * Recursive helper method for the getAdressenDaten.
     */
    private void getAdressenDatenInner(String vorname, String nachname) {
        NodeList contacts = this.documentElement.getChildNodes();
        for (int i = 0; i < contacts.getLength(); i++) {
            Node node = contacts.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (node.getNodeName().equals(fieldKontakt)) {
                this.processContact(node, vorname, nachname);
            }
        }
    }

    /**
     * Method to check if contact confirms with search params. Method parse Address data and
     * personal data into a Kontakt object.
     */
    private void processContact(Node node, String vorname, String nachname) {
        NodeList children = node.getChildNodes();

        // get type
        Element elem = (Element) node;
        String type = elem.getAttribute(attrTyp);
        Kontakt.KontaktTyp typeK = Kontakt.KontaktTyp.privat;
        if (type.equalsIgnoreCase(Kontakt.KontaktTyp.geschaeftlich.toString())) {
            typeK = Kontakt.KontaktTyp.geschaeftlich;
        }

        // get string fields
        String street = "";
        String plz = "";
        String city = "";
        String country = "";
        for (int i = 0; i < children.getLength(); i++) {
            Node n = children.item(i);

            if (n.getNodeName().equals(fieldName)) {
                if (!checkNames(n, vorname, nachname)) {
                    // return if contact has different first and last names
                    return;
                }
            }

            // parse address information
            if (n.getNodeName().equals(fieldAdresse)) {
                NodeList addressItems = n.getChildNodes();
                for (int j = 0; j < addressItems.getLength(); j++) {
                    Node addressItem = addressItems.item(j);
                    switch (addressItem.getNodeName()) {
                        case fieldStrasse:
                            street = addressItem.getTextContent();
                            break;
                        case fieldPLZ:
                            plz = addressItem.getTextContent();
                            break;
                        case fieldOrt:
                            city = addressItem.getTextContent();
                            break;
                        case fieldLand:
                            country = addressItem.getTextContent();
                    }
                }
            }
        }

        // save to array list
        Kontakt c = new Kontakt(
                typeK,
                vorname,
                nachname,
                street,
                plz,
                city,
                country
        );
        contactList.add(c);
    }

    /**
     * Method to check if contact first and last names confirm with search params.
     */
    private static boolean checkNames(Node node, String vorname, String nachname) {
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node n = children.item(i);
            if (n.getNodeName().equals(fieldVorname)) {
                if (!vorname.equalsIgnoreCase(n.getTextContent())) {
                    return false;
                };
            }
            else if (n.getNodeName().equals(fieldNachname)) {
                if (!nachname.equalsIgnoreCase(n.getTextContent())) {
                    return false;
                };
            }
        }
        return true;
    }
}
