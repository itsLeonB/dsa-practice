import java.util.*;

public class DigitSort {
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
        
        Scanner sc = new Scanner(System.in);
        int nTest = sc.nextInt();

        int[] testArr = new int[nTest];

        for(int i=0; i<nTest; i++) {
            testArr[i] = sc.nextInt();
        }

        for(int j=0; j<nTest; j++) {
            String s = Integer.toString(testArr[j]);

            if(s.length() == 2) {
                char[] c = s.toCharArray();
                char temp = c[1];
                c[0] = temp;
                c[1] = '\u0000';
                String sNew = new String(c);
                System.out.println(sNew);
            }

            else {
                char[] c = s.toCharArray();

                int[] inTest = new int[c.length];

                for (int k=0; k<c.length; k++) {
                    int a = Character.getNumericValue(c[k]);
                    inTest[k] = a;
                }

                for (int l = 0; l < inTest.length; l++) {  
                    for (int m = l + 1; m < inTest.length; m++) {  
                        if (inTest[l] > inTest[m]) {  
                            int t;
                            t = inTest[l];  
                            inTest[l] = inTest[m]; 
                            inTest[m] = t;  
                        }  
                    }  
                }
                
                System.out.println(inTest[0]);  
            }  
        }
    }
}
