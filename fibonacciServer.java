import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class fibonacciServer {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            
            System.out.println("Fibonacci Server is running...");
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int n = Integer.parseInt(message.trim());
                int fibonacciNumber = fibonacci(n);
                
                String response = Integer.toString(fibonacciNumber);
                sendData = response.getBytes();
                
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
    
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }
}
