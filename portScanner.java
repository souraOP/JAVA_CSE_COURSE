import java.net.Socket;
import java.util.Scanner;

public class portScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting port number: ");
        int startPortNumber = sc.nextInt();
        System.out.println("Enter the ending port number: ");
        int endingPortNumber = sc.nextInt();
        int countPorts = 0;
        for(int i = startPortNumber; i <= endingPortNumber; i++){
            try {
                Socket socketInitializer = new Socket("localhost", i);
                System.out.println("Port " + i + " is avaliable.");
                countPorts++;
            } catch (Exception e) {
                System.out.println("Port " + i + " is busy.");
            }
        }
        System.out.println("-".repeat(20));
        System.out.println("Number of avaliable ports: " + countPorts);
        sc.close();
    }
}
