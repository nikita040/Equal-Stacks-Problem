import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */

    
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        Stack<Integer> st3 = new Stack<Integer>();

        int st1height=0;
        int st2height=0;
        int st3height=0;

        for(int i =h1.length -1; i>=0 ;i--){
            st1height = st1height+h1[i];
            st1.push(st1height);
        }

        for(int i =h2.length -1; i>=0 ;i--){
            st2height = st2height+h2[i];
            st2.push(st2height);
        }

        for(int i =h3.length -1; i>=0 ;i--){
            st3height = st3height+h3[i];
            st3.push(st3height);
        }

        while(true){
            if(st1.isEmpty() || st2.isEmpty() || st3.isEmpty()){
                return 0;
            }

            st1height = st1.peek();
            st2height = st2.peek();
            st3height = st3.peek();

            if(st1height == st2height && st2height == st3height){
                return st1height;
            }

            if(st1height>= st2height && st1height>=st3height){
                st1.pop();
            }

            else if(st2height>= st1height && st2height>=st3height){
                st2.pop();
            }

            else if(st3height>= st1height && st3height>=st3height){
                st3.pop();
            }
        }

         
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
