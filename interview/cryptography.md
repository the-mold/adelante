# Symmetric encryption
Two users agree on a key. Key is used to encrypt message by the sender and to decrypt message by the receiver. There are many legit algorypthms like AES128, AES192...
### Problem1
The problem with this approach that each user needs a separate key for each other user. Hence, if i want to talk to 2 users, i will need to agree on two separate keys with them. This does not scale.
### Problem2
Users are reequired to find a place and method to exchange the key.

# Asymmetric Encryption
I create private and public keys. I send out public keys to whoever wants to talk to me. You can encrypt a message with one key and decrypt with another. For example:
Sender encrypts a message with public key, and receiver can decrypt it with private key.
(Note!) It is possible but not common for receiver to encrypt a message with private key, and for receiver to decrypt a message with public key.

## Example RSA
1. Generate private key:
```
openssl genrsa -out private-key.pem 2048
```
2. Generate public key:
```
openssl rsa -in private-key.pem -pubout -out public-key.pem
```
3. Optionally see variables of some key, like private key:
```
openssl rsa -in private-key.pem -text -noout
```
4. Now encrypt a message with private key:
```
openssl pkeyutl -encrypt -in plaintext.txt -out ciphertext -inkey public-key.pem -pubin
```
5. Decrypt a message with public key:
```
openssl pkeyutl -decrypt -in ciphertext -inkey private-key.pem -out decrypted.txt
```

## Example: Diffie-Hellman key exchange
Diffie-Hellman is an asymmetric encryption algorithm. It allows the exchange of a secret 
over a public channel.(if somebody is watching the exchange). It is possible with modular math operations(mod).

Problem: algorythm is susceptible to the man in the middle attack.


# PKI and SSL/TLS
PKI is framework that states that you need to generate certifiate request and send it to authority that signes your 
certificate. Then any user can be sure that this certificate is yours.

SSL is successor of TLS. These are cryptographic protocols that are designed to provide secure communication
over a computer network.

Certificate is recognized by the browser if domain where certificate is used is stated
in Subject Alternative Name(SAN) or Common Name(CN). Click on details to check.

## Get production certificate with real signature
1. Generate Certificate Signing Request (CSR): You create a certificate and send your public key to be signed by a third party.
Oneliner to generate private key(key.pem) and Certificate Signing Request (CSR). CSR contains my public key.
```
openssl req -new -nodes -newkey rsa:4096 -keyout key.pem -out cert.csr
```
Review your certificate:
```
openssl req -noout -text -in cert.csr
```
2. Send your CSR to a Certificate Authority (CA)(e.g., DigiCert, Comodo, Let’s Encrypt, GlobalSign): The purpose is for the CA to sign your certificate.
3. After verification, the CA will issue your signed certificate, usually provided as a .crt or .cer file. You may also receive additional CA Bundle.
Upload everything that you receive and your private key to server. Example how to connect nginx:
```
server {
    listen 443 ssl;
    server_name service.bla.live;

    ssl_certificate /etc/ssl/certs/certificate.crt;
    ssl_certificate_key /etc/ssl/private/private.key;
    ssl_trusted_certificate /etc/ssl/certs/ca_bundle.crt;
}
```

## To generate self signed certificate:
1.
```
openssl req -x509 -newkey -nodes rsa:4096 -keyout key.pem -out cert.pem -sha256 -days 365
```
2. Check info in certificate:
```
openssl x509 -in cert.pem -text
```

## Verify certificate of any website
openssl s_client -connect service.bla.live:443 -showcerts
