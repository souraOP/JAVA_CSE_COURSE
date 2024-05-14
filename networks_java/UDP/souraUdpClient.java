package UDP;


import java.io.*;
import java.net.*;

class souraUdpClient {
    public static void main(String[] args) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket cliSock = new DatagramSocket();
        InetAddress  IPA = InetAddress.getLocalHost();
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPack = new DatagramPacket(sendData, sendData.length, IPA, 9876);
        cliSock.send(sendPack);
        DatagramPacket receivePack = new DatagramPacket(receiveData, receiveData.length);
        cliSock.receive(receivePack);
        String modifiedSentence = new String(receivePack.getData());
        System.out.println("From Server: " + modifiedSentence);
        cliSock.close();
    }
    
}
