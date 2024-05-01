package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class LocalHost {
    public static void main(String[] args) {
        try {
            // localhost <-> remote host
            InetAddress inetAddress = InetAddress.getLocalHost(); // DESKTOP-CQPKAEH/192.168.0.126
            String hostName = inetAddress.getHostName(); // DESKTOP-CQPKAEH
            String hostIpAddress = inetAddress.getHostAddress(); // 192.168.0.126

            System.out.println(inetAddress);
            System.out.println(hostName);
            System.out.println(hostIpAddress);

            byte[] IpAddresses = inetAddress.getAddress(); // original 4 byte
            for(byte IpAddress : IpAddresses) {
                // System.out.println(IpAddress);
                System.out.println(IpAddress & 0x000000ff);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
