import java.net.*;
import java.util.Scanner;

public class receiver1 {
    public static void main(String[] args) {
        try{
            MulticastSocket ms = new MulticastSocket(4999);
            ms.joinGroup(InetAddress.getByName("224.0.0.1"));
            while(true){
                byte[] b1 = new byte[1024];
                DatagramPacket dp = new DatagramPacket(b1, b1.length);
                ms.receive(dp);
                InetAddress clientAddress = dp.getAddress();
                int clientPort = dp.getPort();
                String s = new String(dp.getData());
                System.out.println();
                System.out.println("RECEIVED MESSAGE: " + s);
                if(s.equals("end")){
                    break;
                } else{
                    System.out.println();
                    System.out.println("Enter a message:");
                    Scanner sc = new Scanner(System.in);
                    String str = sc.nextLine();
                    if(str.equals("end")){
                        byte[] b2 = str.getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2, b2.length, clientAddress,clientPort);
                        ms.send(dp2);
                        break;
                    } else{
                        byte[] b = str.getBytes();
                        DatagramPacket dp1 = new DatagramPacket(b, b.length, clientAddress,clientPort);
                        ms.send(dp1);
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
