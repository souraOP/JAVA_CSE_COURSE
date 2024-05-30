import java.util.Scanner;

public class receiverCRC {

    // Method to perform XOR operation
    private static String xor(String a, String b) {
        String result = "";
        int n = b.length();
        
        for (int i = 1; i < n; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result += "0";
            } else {
                result += "1";
            }
        }
        return result;
    }

    // Method to perform modulo-2 division
    private static String mod2div(String divident, String divisor) {
        int pick = divisor.length();
        String tmp = divident.substring(0, pick);
        
        int n = divident.length();
        
        while (pick < n) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(divisor, tmp) + divident.charAt(pick);
            } else {
                tmp = xor(new String(new char[pick]).replace('\0', '0'), tmp) + divident.charAt(pick);
            }
            pick += 1;
        }
        
        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp);
        } else {
            tmp = xor(new String(new char[pick]).replace('\0', '0'), tmp);
        }
        
        return tmp;
    }

    // Method to check received data
    public static boolean checkData(String data, String key) {
        String remainder = mod2div(data, key);
        
        int l = remainder.length();
        for (int i = 0; i < l; i++) {
            if (remainder.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter received data: ");
        String receivedData = input.nextLine();
        
        System.out.println("Enter key: ");
        String key = input.nextLine();
        
        boolean isValid = checkData(receivedData, key);
        
        if (isValid) {
            System.out.println("No error detected in received data.");
        } else {
            System.out.println("Error detected in received data.");
        }
        
        input.close();
    }
}
