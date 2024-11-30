My network IP address:
ifconfig

My public address
curl ifconfig.me

# Network topologies
- bus topology(problem with bus bottleneck)
- Ring topology(the worst)
- star(the most common)

In star topology there are often sitches and routers used.
## Switches
Switches are dedicated devices within a network that are designed to aggregate multiple other devices such as computers, printers, or any other networking-capable device using ethernet. These various devices plug into a switch's port. Switches are usually found in larger networks such as businesses, schools, or similar-sized networks, where there are many devices to connect to the network. 
## Routers
Switches direct data tou routers. It's a router's job to connect networks and pass data between them. It does this by using routing


# Subnets
In total IPv4 has 32 bits.

# Examples subnet masks
Subnet Mask	    CIDR Notation	   Network Bits	   Host Bits	   Example Network	Usable Hosts
255.0.0.0      	/8	             8 bits	        24 bits	        10.0.0.0	      16,777,214
255.255.0.0	    /16	             16 bits	      16 bits	        172.16.0.0	    65,534
255.255.255.0 	/24	             24 bits	      8 bits	        192.168.1.0	    254
255.255.255.128	/25	             25 bits	      7 bits	        192.168.1.0	    126

Example: address 192.10.82.5/24 means that 24bits are network address(192.10.82) and 5 is host address.
There are 254 possible hosts in the network.

### Calculating the Number of Hosts
The number of bits available for hosts in a /16 network is 16 bits (since 32 - 16 = 16).
Each bit can be either 0 or 1, so the total number of combinations is:
2^(32-24) = 256
However, two of these addresses are reserved:
Network Address (first address in the range). Example: 192.10.82.1
Broadcast Address (last address in the range). Example: 192.10.82.255
So the final result: 256 - 1 - 1 = 254 available hosts.

## Default Gateway
Is a device on the network that is responsible to send data to another network. If my device needs to send data to another network, it will send it to the default gateway device.


## Address Resolution Protocol (ARP)
Each device on network sends a request to all connected devices on network ips to identify themselves with MAC address. This address is saved in device registry.


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
