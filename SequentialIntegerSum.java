import java.util.*;

public class SequentialIntegerSum {
    public static void main(String args[]) {
        /*
         * 1. Read the number of test cases
         * 2. Read the test cases
         * 3. Split the test cases
         * 4. Convert the split strings to integers
         * 5. Perform the operations
         * 6. Print the results
         * 7. Repeat 3-6 for all test cases
         * 8. End
         */
        
        int x, y, z;

        Scanner scn = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        String ls = System.getProperty("line.separator");

        sc.useDelimiter(ls);

        int n = scn.nextInt();

        String[] testArr = new String[n];

        for(int i=0; i<n; i++) {
            testArr[i] = sc.nextLine();
        }

        System.out.println("\n\n");

        for(String s : testArr) {
            String[] splited = s.split(" ");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);
            int c = Integer.parseInt(splited[2]);
            z=c;
            y=z+b;
            x=y+a;
            System.out.println(x + " " + y + " " + z);
        }
    }
}
