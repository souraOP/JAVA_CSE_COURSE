import java.net.*;
import java.util.Scanner;

public class senderMulticast {
    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(InetAddress.getByName("224.0.0.1"));
            while(true){
                System.out.println();
                System.out.println("Enter a message:");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                if(str.equals("end")){
                    byte[] b2 = str.getBytes();
                    DatagramPacket dp2 = new
                    DatagramPacket(b2,b2.length,InetAddress.getLocalHost(),4999);
                    ms.send(dp2);
                    break;
                } else {
                    byte[] b = str.getBytes();
                    DatagramPacket dp = new
                    DatagramPacket(b,b.length,InetAddress.getByName("224.0.0.1"),4999);
                    ms.send(dp);
                    byte[] b1 = new byte[1024];
                    DatagramPacket dp1 = new
                    DatagramPacket(b1,b1.length);
                    ms.receive(dp1);
                    String s = new
                    String(dp1.getData(),0,dp1.getLength());
                    System.out.println();
                    System.out.println("RECEIVED MESSAGE: "+s);
                    if(s.equals("end")){
                        break;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
