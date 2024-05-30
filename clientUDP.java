

import java.io.*;
import java.net.*;

public class clientUDP {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPA = InetAddress.getLocalHost();
        byte[] receivedData = new byte[3024];
        byte[] sendData = new byte[3024];
        String mySentence = inFromUser.readLine();
        sendData = mySentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPA, 9876);
        clientSocket.send(sendPacket);
        // for receiving
        DatagramPacket receivingPacket = new DatagramPacket(receivedData, receivedData.length);
        clientSocket.receive(receivingPacket);
        String theSentence = new String(receivingPacket.getData());
        System.out.println("Message from Server: " + theSentence);
        clientSocket.close();

    }
}
