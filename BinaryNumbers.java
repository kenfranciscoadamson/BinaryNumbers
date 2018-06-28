/**
 * Input is a decimal number and the output is the maximum number of 
 * consecutive 1's of its binary number equivalence.
 * @author CoffeeCyborg
 */

import java.util.*;

public class Day10_BinaryNumbers {
    
    public static void DecToBin(int decimal) {
        
        int ogDecimal = decimal;
        
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
        
        // ARRAY BINARY CATCHER
        // need an array to catch each digit of the binary number to evaluate 
        // them from each other
        // also need the actual # of digits the binary equivalence of the deci-
        // mal has.
        int remainder = 0;
        if (ogDecimal % 2 == 0) {
            remainder += 1;
        }
        int binaryDigits = 1 + (ogDecimal / 2) - remainder;
        int[] arr = new int[binaryDigits];
        int j = 0;
        while (true) {
            int quotient2 = ogDecimal / 2;
            int modulo2 = ogDecimal % 2;
            arr[j] = modulo2;
            if (ogDecimal==1) {
                break;
            }
            ogDecimal = quotient2;
            j++;
        }
        int[] ay = new int[binaryDigits];
        for (int k = 0; k < binaryDigits; k++) {
            if (arr[k] == 0) {
                continue;
            } else {
                ay[k] += 1;
                for (int l = k + 1; l < binaryDigits; l++) {
                    if (arr[l] == 1) {
                        ay[k] += 1;
                    } else {
                     break;
                    }   
                }
            }
            
        }
        bubbleSort(ay);
        System.out.println(ay[binaryDigits - 1]);
    }
    
    public static int[] bubbleSort(int[] waterArray) {
        boolean swapped = true;
        for(int i = 0; i < waterArray.length -1 ; i++) {
            swapped = false;
            for (int j = 0; j < waterArray.length - i - 1; j++) {
                if(waterArray[j] > waterArray[j+1]) {
                    int temp = waterArray[j];
                    waterArray[j] = waterArray[j+1];
                    waterArray[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) {
                break;
            }
        }
        return waterArray;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        DecToBin(input);
        
        scan.close();
    }
}
