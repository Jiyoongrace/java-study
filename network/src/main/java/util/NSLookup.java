package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
    public static void main(String[] args) {
        InetAddress[] inetAddresses = null;
        Scanner scanner = new Scanner(System.in);

        try {
            while(true) {
                System.out.print("> ");
                String inetAddress = scanner.nextLine();
                if(inetAddress.equals("exit")) {
                    break;
                }
                inetAddresses = InetAddress.getAllByName(inetAddress);
                for(int i=0; i<inetAddresses.length; i++) {
                    System.out.println(inetAddress + ": " + inetAddresses[i].getHostAddress());
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("알려진 호스트가 없습니다.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
