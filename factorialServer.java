import java.net.*;
import java.io.*;
import java.math.BigInteger;
public class factorialServer{
  public static void main(String ar[]){
    try{
      System.out.println("Waiting for Client");
      ServerSocket ss = new ServerSocket(9876);
      Socket soc = ss.accept();
      System.out.println("Server Started..");
      System.out.println("Connection Established");
      // get that number from the client side
      BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
      // read the number
      int number = Integer.parseInt(br.readLine());
      // send that number to the client after calculating the factorial
      PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
      out.println("Factorial of " + number + " is: " + calculateFactorial(number));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    

  }

  // static int calculateFactorial(int number) {
  //   int fact = 1;
  //   for(int i = 1; i <= number; i++){
  //     fact = fact * i;
  //   }
  //   return fact;
  // }

  // for number greater than 20
  static BigInteger calculateFactorial(int number) {
    BigInteger fact = BigInteger.ONE;
    for(int i = 2; i <= number; i++) {
      fact = fact.multiply(BigInteger.valueOf(i));
    }
    return fact;
  }
}