

import java.io.*;
import java.net.*;

class serverUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket sersSocket = null;
        try {
            sersSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[3024];
            byte[] sendData = new byte[3024];
            while(true){
                DatagramPacket recpack = new DatagramPacket(receiveData, receiveData.length);
                sersSocket.receive(recpack);
                String sentence = new String(recpack.getData());
                System.out.println("Received " + sentence);
                InetAddress IPA = recpack.getAddress();
                int port = recpack.getPort();
                String transformedSentence = sentence.toUpperCase();
                sendData = transformedSentence.getBytes();
                DatagramPacket sendpack = new DatagramPacket(sendData, sendData.length, IPA, port);
                sersSocket.send(sendpack);
            }
        } finally {
            if (sersSocket != null) {
                sersSocket.close();
            }
        }
    }
}
