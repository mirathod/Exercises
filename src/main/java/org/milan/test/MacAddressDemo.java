package org.milan.test;
import java.net.InetAddress;
import java.net.NetworkInterface;


public class MacAddressDemo {
public static void main(String[] args) {
	InetAddress ip;
	StringBuilder sb = new StringBuilder();
	try{
		ip=InetAddress.getLocalHost();
		System.out.println("Current IP Address : "+ip.getHostAddress());
		
		NetworkInterface network=NetworkInterface.getByInetAddress(ip);
		
		byte[] mac=network.getHardwareAddress();
		
		
		for (int i = 0; i < mac.length; i++) {

			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));

		}
		System.out.println(sb.toString());
	}
	catch(Exception e){
		
	}
}
}
