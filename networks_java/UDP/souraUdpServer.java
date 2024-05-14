package UDP;

import java.net.DatagramPacket;
import java.io.IOException;
import java.net.*;

class souraUdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ser_socket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true){
            DatagramPacket received_packet = new DatagramPacket(receiveData, receiveData.length);
            ser_socket.receive(received_packet);
            String sentence = new String(received_packet.getData());
            System.out.println("Received Packet: " + sentence);
            InetAddress IPA = received_packet.getAddress();
            int port = received_packet.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket send_packet = new DatagramPacket(sendData, sendData.length, IPA, port);
            ser_socket.send(send_packet);
        }
    }
}