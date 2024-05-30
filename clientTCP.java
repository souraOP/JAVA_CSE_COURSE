import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientTCP {
    public static void main(String[] args) throws Exception {
        // Socket s = new Socket("localhost",5571);
        // while(true) {
          
        //     //writing at the client side
        //     Scanner sc = new Scanner(System.in);
        //     String to_write = sc.nextLine();
        //     if(to_write.equals("EXIT")) break;
        //     OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
        //     PrintWriter  pw = new PrintWriter(osw);
        //     pw.println(to_write);
        //     osw.flush();

        //     //reading at the server side
        //     InputStreamReader ir = new InputStreamReader(s.getInputStream());
        //     BufferedReader br = new BufferedReader(ir);
        //     String to_print = br.readLine();
        //     System.out.println(to_print);
        // }
        // s.close();

        Socket s = new Socket("localhost",7764);
      
       while(true) {
      
           //writing code client side
           Scanner sc = new Scanner(System.in);
           DataOutputStream dos = new DataOutputStream(s.getOutputStream());
           System.out.print("Client : ");
           String str1 = sc.nextLine();
           if(str1.equals("EXIT")) break;
           dos.writeUTF(str1);

           //reading code client side
           DataInputStream dis = new DataInputStream(s.getInputStream());
           String str = (String)dis.readUTF();
           System.out.println("Server : "+str);

       }

       s.close();
    }
}
