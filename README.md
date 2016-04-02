# CheckSpammer
A Java program that checks if the hosts connecting to your network are known spammers or not.

#Introduction
Many services track spammers, and inform clients whether a host trying to connect their network is a known spammer or not. These real-time blacklists need to respond to queries quickly, and process a very high load. The response should be fast and cacheable. Also the load should be distributed across many servers. Although this could be done using a web server, SOAP, UDP, or some other mechanism, this service only uses DNS and DNS alone.

#Mechanism
To find if the connecting host's IP address is spam:
- Reverse the bytes of the address
- Concatenate the reversed address with the blackhole service's domain, and post a DNS query over it.
- If the address is found, it’s a spammer else it’s not.

#Implementation
- Here I have implemented using simple Java program. It uses InetAddress class of java.net package for DNS lookups.
- The hosts' IP Addresses are taken through command line input. This can be changed according to your own program.
- The blackhole service I am using is sbl.spamhaus.org.
- For instance, if you want to ask sbl.spamhaus.org if 74.125.23.103 is a spammer, you would look up the hostname 103.23.125.74.sbl.spamhaus.org. (Note that despite the numeric component, this is a hostname ASCII string, not a dotted quad IP address.) If the DNS query succeeds (and, more specifically, if it returns the address 127.0.0.2), then the host is known to be a spammer. If the lookup fails—that is, it throws an UnknownHostException—it isn’t.

#Conclusion
Though it is a very simple program, but it doesn't uses any web server or custom protocol. It is implemented using pure DNS lookup. You can use this program in your backend services for identifying false or spam connecting hosts.
Please contribute to the repository to make it more advance.
