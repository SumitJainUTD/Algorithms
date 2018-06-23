package ThirdLot.MISC;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintIPAddress {

    public static void getIPAddress(){
        try {
            //get the local host
            InetAddress localHost = InetAddress.getLocalHost();

            //get the ipaddress

            String ipaddress = localHost.getHostAddress();
            System.out.println("IP ADDRESS is : " + ipaddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getIPAddress();
    }
}
