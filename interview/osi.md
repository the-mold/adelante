# OSI model

The OSI (Open Systems Interconnection) model is a conceptual framework that helps
to understand how network components communicate with each other.
1. Physical Level deals with physical aspects of network: cables and connectors that are used.
2. Data link level is responsible for data transfer between adjacent networks. It provides services as
error detection, access control and divides data into frames. This layers sets MAC address of the device,
that sends a packet.
Example protocols: Ethernet, Wi-Fi and PPP.
3. Network level deals with routing of data between different networks. It is responsible for 
determining the best routing path, traffic control, fragmentation and reassembly of data packets.
Example protocols: IP(used to find path), ICMP, and ARP.
4. Transport level ensures that packets are delivered reliable and efficiently. When data is sent between devices, it follows one of two different protocols that are decided based upon several factors: TCP or UDP.
TCP makes connection between sender and receiver and makes sure that data is delivered fully.
UDP just sends data and hopes for the best. It is useful for video streaming or voice calls.

5. Session level creates and maintains the connection to other computer for which the data is destined. When a connection is established, a session is created. Whilst this connection is active, so is the session.
Example protocols: NFS (Network File System) and SQL (Structured Query Language).

6. Presentation level is responsible for providing consistent data representation between systems. 
It ensures that data that is transferred can be understood by sender and receiver regardless of
system architecture, operating system and programing language. It deals with data encryption/decryption, 
data formatting, compression and translation of data between different character sets.
Example protocols: MIME (Multipurpose Internet Mail Extensions) for email formatting, SSL/TLS for secure web communication, and ASCII and Unicode for character encoding.
7. Application level provides a way for applications to access network services, data and resources.
Example protocols: HTTP(used for web browsing), FTP(used for file transfer), SMTP(used for emailing), 
and DNS(used for domain resolution).

# Ethernet VS Wi-Fi
Ethernet is a technology for computer networking. Ethernet is used to connect devices into
LAN(local area network) and WAN(wide area network). Ethernet defines protocol how devices should
communicate with each other.
Advantage: speed, reliability, security.
Disadvantage: every computer must be cable connected.

WiFi is a wireless networking technology that uses radio waves to provide internet access.
Advantage: you can move devices in space.
Disadvantage: security, interruptions, speed.

In summary, Ethernet transmits data over cables, whereas Wi-Fi transmits data over wireless signals.

# WLAN vs WiFi
Wifi is trademark name for the technology that uses radio waves to transfer data.

WLAN(wireless local network) devices in network can communicate with each other wirelessly.
Devices connect to router, router is connected with Ethernet cable to DSL cable.

# DSL(Digital Subscriber Line)
DSL is provided by phone company and MUST to be translated to Ethernet/WiFi signal with help of 
modem/router(that support this functionality) so that you could connect your device. 
