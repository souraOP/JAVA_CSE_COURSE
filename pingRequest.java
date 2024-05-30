import java.io.*;
import java.net.*;

public class pingRequest{
    public static void main(String[] args) {
        System.out.println("Pinging status: ");

        try {
            // InetAddress IPA = InetAddress.getByName("localhost");
            InetAddress IPA = InetAddress.getByName("https://www.soura-bot.netlify.app");
            System.out.println("Sending ping request to: " + IPA);
            boolean flag = IPA.isReachable(50000);
            if(flag) {
                System.out.println("Current Status: Host is reachable");
            } else {
                System.out.println("Current Status: Host is not reachable");
            }
        } catch (IOException e) {
            System.out.println("Host doesn't exists " + e);
        }
    }
}