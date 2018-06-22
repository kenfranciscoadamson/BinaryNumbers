import java.util.*;

public class BinaryNumbers {
    
    public static int DecToBin(int decimal) {
        int binary = 0;
        int i = 0;
        while (true) {
            int quotient = decimal / 2;
            int modulo = decimal % 2;
            if (modulo == 1) {
                binary += Math.pow(10, i);
            }
            if (decimal==1) {
                break;
            }
            decimal = quotient;
            i++;
        }
        return binary;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        
        System.out.println(DecToBin(input));
        
        scan.close();
    }
}
