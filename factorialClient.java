import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class factorialClient {
    public static void main(String[] args) {
        try {
            System.out.println("Factorial Client Started");
            Socket soc = new Socket("localhost", 9876);
            BufferedReader takeUserInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(takeUserInput.readLine());  // convert that string into an integer value 
            // so Integer.parseInt converts into Integer and .readLine() takes the string input

            // send this number to the server
            PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);
            pw.println(number);

            // for reading the data
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
