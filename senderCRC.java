import java.util.Scanner;

public class senderCRC {

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

    // Method to encode data
    public static String encodeData(String data, String key) {
        int l_key = key.length();
        String appended_data = (data + new String(new char[l_key - 1]).replace('\0', '0'));
        
        String remainder = mod2div(appended_data, key);
        
        return data + remainder;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter data to be sent: ");
        String data = input.nextLine();
        
        System.out.println("Enter key: ");
        String key = input.nextLine();
        
        String encodedData = encodeData(data, key);
        System.out.println("Encoded Data (Data + CRC): " + encodedData);
        
        input.close();
    }
}
