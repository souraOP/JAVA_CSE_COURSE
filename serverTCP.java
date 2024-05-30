import java.net.*;
import java.io.*;
import java.util.*;

public class serverTCP {
    public static void main(String[] args) throws IOException{
        // ServerSocket ss = new ServerSocket(5571);
        // Socket s = ss.accept();
        //     while(true) {
        //        //code for reading  at the server side
        //         InputStreamReader ir = new InputStreamReader(s.getInputStream());
        //         BufferedReader br = new BufferedReader(ir);
        //         String str = br.readLine();
        //         System.out.println(str);

        //         //code for wrting at the server side
        //         Scanner sc = new Scanner(System.in);
        //         String to_write = sc.nextLine();
        //         if(to_write.equals("EXIT")) break;
        //         OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
        //         PrintWriter pw = new PrintWriter(osw);
        //         pw.println(to_write);
        //         osw.flush();
        //     }
        // s.close();

        ServerSocket ss = new ServerSocket(7764);
        Socket s = ss.accept();
        while(true) {
            //reading code server side
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String)dis.readUTF();
            System.out.println("Client : "+str);

            //writing code server side
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.print("Server : ");
            String str1 = sc.nextLine();
            if(str1.equals("EXIT")) break;
            dos.writeUTF(str1);
        }
        s.close();
        ss.close();
    }
}
