//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Gui extends Frame implements ActionListener {
    Panel pnDisplay = new Panel(new BorderLayout());
    Panel pnTasten1 = new Panel(new GridLayout(1, 4));
    Panel pnTasten2 = new Panel(new GridLayout(1, 4));
    Panel pnTasten3 = new Panel(new GridLayout(1, 4));
    Panel pnTasten4 = new Panel(new GridLayout(1, 4));
    Panel pnGleich = new Panel(new BorderLayout());
    Button btn1 = new Button("1");
    Button btn2 = new Button("2");
    Button btn3 = new Button("3");
    Button btn4 = new Button("4");
    Button btn5 = new Button("5");
    Button btn6 = new Button("6");
    Button btn7 = new Button("7");
    Button btn8 = new Button("8");
    Button btn9 = new Button("9");
    Button btn0 = new Button("0");
    Button btnPlus = new Button("+");
    Button btnMinus = new Button("-");
    Button btnMal = new Button("*");
    Button btnDurch = new Button("/");
    Button btnGleich = new Button("=");
    Button btnLeer1 = new Button("");
    Button btnC = new Button("C");
    Label display = new Label();
    Rechenwerk rw = new Rechenwerk();
    private int z1 = 0;
    private int z2 = 0;
    private char operation = ' ';
    private boolean zFlag = false;
    private boolean berechnet = false;
    private boolean zPressed = false;
    private String input;
    Font fDisplay = new Font("fDisplay", 1, 27);
    Font fBtn = new Font("fBtn", 1, 16);

    public Gui() {
        this.enableEvents(64L);
        this.init();
    }

    public void init() {
        this.setLayout(new GridLayout(6, 1));
        this.setSize(new Dimension(198, 295));
        this.setBackground(Color.lightGray);
        this.setTitle("Taschenrechner");
        this.setResizable(false);
        this.btn1.setFont(this.fBtn);
        this.btn1.addActionListener(this);
        this.btn2.setFont(this.fBtn);
        this.btn2.addActionListener(this);
        this.btn3.setFont(this.fBtn);
        this.btn3.addActionListener(this);
        this.btn4.setFont(this.fBtn);
        this.btn4.addActionListener(this);
        this.btn5.setFont(this.fBtn);
        this.btn5.addActionListener(this);
        this.btn6.setFont(this.fBtn);
        this.btn6.addActionListener(this);
        this.btn7.setFont(this.fBtn);
        this.btn7.addActionListener(this);
        this.btn8.setFont(this.fBtn);
        this.btn8.addActionListener(this);
        this.btn9.setFont(this.fBtn);
        this.btn9.addActionListener(this);
        this.btn0.setFont(this.fBtn);
        this.btn0.addActionListener(this);
        this.btnPlus.setFont(this.fBtn);
        this.btnPlus.addActionListener(this);
        this.btnPlus.setForeground(Color.blue);
        this.btnMinus.setFont(this.fBtn);
        this.btnMinus.addActionListener(this);
        this.btnMinus.setForeground(Color.blue);
        this.btnMal.setFont(this.fBtn);
        this.btnMal.addActionListener(this);
        this.btnMal.setForeground(Color.blue);
        this.btnDurch.setFont(this.fBtn);
        this.btnDurch.addActionListener(this);
        this.btnDurch.setForeground(Color.blue);
        this.btnGleich.setFont(this.fBtn);
        this.btnGleich.addActionListener(this);
        this.btnGleich.setForeground(Color.red);
        this.btnC.setFont(this.fBtn);
        this.btnC.addActionListener(this);
        this.btnC.setForeground(new Color(19, 140, 44));
        this.display.setAlignment(2);
        this.display.setFont(this.fDisplay);
        this.display.setForeground(Color.green);
        this.display.setBackground(Color.black);
        this.pnDisplay.add(this.display);
        this.pnTasten1.add(this.btn7);
        this.pnTasten1.add(this.btn8);
        this.pnTasten1.add(this.btn9);
        this.pnTasten1.add(this.btnDurch);
        this.pnTasten2.add(this.btn4);
        this.pnTasten2.add(this.btn5);
        this.pnTasten2.add(this.btn6);
        this.pnTasten2.add(this.btnMal);
        this.pnTasten3.add(this.btn1);
        this.pnTasten3.add(this.btn2);
        this.pnTasten3.add(this.btn3);
        this.pnTasten3.add(this.btnMinus);
        this.pnTasten4.add(this.btnLeer1);
        this.pnTasten4.add(this.btn0);
        this.pnTasten4.add(this.btnC);
        this.pnTasten4.add(this.btnPlus);
        this.pnGleich.add(this.btnGleich);
        this.add(this.pnDisplay);
        this.add(this.pnTasten1);
        this.add(this.pnTasten2);
        this.add(this.pnTasten3);
        this.add(this.pnTasten4);
        this.add(this.pnGleich);
        this.display.setText("0");
        this.input = this.display.getText();
        this.show();
    }

    public void actionPerformed(ActionEvent var1) {
        int var2;
        try {
            var2 = Integer.parseInt(this.display.getText());
        } catch (NumberFormatException var4) {
            var2 = -1;
        }

        if (!this.berechnet) {
            if (this.input.length() < 8) {
                if (var1.getSource() == this.btn0) {
                    if (var2 == 0) {
                        this.input = "0";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "0";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn1) {
                    if (var2 == 0) {
                        this.input = "1";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "1";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn2) {
                    if (var2 == 0) {
                        this.input = "2";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "2";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn3) {
                    if (var2 == 0) {
                        this.input = "3";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "3";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn4) {
                    if (var2 == 0) {
                        this.input = "4";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "4";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn5) {
                    if (var2 == 0) {
                        this.input = "5";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "5";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn6) {
                    if (var2 == 0) {
                        this.input = "6";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "6";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn7) {
                    if (var2 == 0) {
                        this.input = "7";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "7";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn8) {
                    if (var2 == 0) {
                        this.input = "8";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "8";
                        this.zPressed = true;
                    }
                }

                if (var1.getSource() == this.btn9) {
                    if (var2 == 0) {
                        this.input = "9";
                        this.zPressed = true;
                    } else {
                        this.input = this.input + "9";
                        this.zPressed = true;
                    }
                }

                this.display.setText(this.input);
            }

            if (!this.zFlag) {
                if (var1.getSource() == this.btnPlus) {
                    this.operation = '+';
                    this.pOperation();
                }

                if (var1.getSource() == this.btnMinus) {
                    this.operation = '-';
                    this.pOperation();
                }

                if (var1.getSource() == this.btnMal) {
                    this.operation = '*';
                    this.pOperation();
                }

                if (var1.getSource() == this.btnDurch) {
                    this.operation = '/';
                    this.pOperation();
                }
            } else if (var1.getSource() == this.btnGleich) {
                boolean var3 = false;
                this.z2 = Integer.parseInt(this.display.getText());
                this.display.setText("");
                int var5 = this.rw.rechnen(this.z1, this.z2, this.operation);
                this.input = "" + var5;
                this.display.setText(this.input);
                this.berechnet = true;
            }
        }

        if (var1.getSource() == this.btnC) {
            this.input = "0";
            this.display.setText(this.input);
            this.operation = ' ';
            this.berechnet = false;
            this.zFlag = false;
            this.zPressed = false;
        }

    }

    protected void pOperation() {
        if (this.zPressed) {
            this.z1 = Integer.parseInt(this.display.getText());
            this.input = "";
            this.display.setText(this.input);
            this.zFlag = true;
        }

    }

    protected void processWindowEvent(WindowEvent var1) {
        super.processWindowEvent(var1);
        if (var1.getID() == 201) {
            System.exit(0);
        }

    }
}
