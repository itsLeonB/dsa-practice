import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MoneyTransfer {
    public static void main(String args[]) throws Exception {
        // receive usernames and balances
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of accounts and transactions:");
        String num = s.nextLine();
        String[] arrNum = num.split(" ", 2);
        int numAcc = Integer.parseInt(arrNum[0]);
        int numTrans = Integer.parseInt(arrNum[1]);

        ArrayList<String> accName = new ArrayList<String>();
        ArrayList<Integer> nameBal = new ArrayList<Integer>();
        ArrayList<String> accNamefrom = new ArrayList<String>();
        ArrayList<String> accNameto = new ArrayList<String>();
        ArrayList<Integer> transBal = new ArrayList<Integer>();

        System.out.println("Enter the account names and initial balances:");
        for (int i = 0; i < numAcc; i++) {
            String accBal = s.nextLine();
            String[] arrAccbal = accBal.split(" ", 2);
            accName.add(arrAccbal[0]);
            nameBal.add(Integer.parseInt(arrAccbal[1]));
        }

        // receive transactions
        System.out.println("Enter the transactions (sender, receiver, amount):");
        for (int i = 0; i < numTrans; i++) {
            String accTrans = s.nextLine();
            String[] arrAcctrans = accTrans.split(" ", 3);
            int balVal = Integer.parseInt(arrAcctrans[2]);
            if ((arrAcctrans[0] != arrAcctrans[1]) && balVal > 0) {
                accNamefrom.add(arrAcctrans[0]);
                accNameto.add(arrAcctrans[1]);
                transBal.add(balVal);
            }
        }

        // perform transactions
        for (int i = 0; i < accNamefrom.size(); i++) {
            String from = accNamefrom.get(i);
            String to = accNameto.get(i);
            int transVal = transBal.get(i);
            for (int j = 0; j < accName.size(); j++) {
                String nameAcc = accName.get(j);
                if (nameAcc.equals(from) && nameBal.get(j) >= transVal) {
                    int newBal = nameBal.get(j) - transVal;
                    nameBal.set(j, newBal);
                    for (int k = 0; k < accName.size(); k++) {
                        nameAcc = accName.get(k);
                        if (nameAcc.equals(to)) {
                            newBal = nameBal.get(k) + transVal;
                            nameBal.set(k, newBal);
                        }
                    }
                }
            }
        }

        // compile new balances
        ArrayList<String> curBal = new ArrayList<String>();
        for (int i = 0; i < accName.size(); i++) {
            curBal.add(accName.get(i) + " " + nameBal.get(i));
        }

        // sort and print new balances
        Collections.sort(curBal);
        System.out.println("\nFinal account balances:");
        for (int i = 0; i < curBal.size(); i++) {
            System.out.println(curBal.get(i));
        }
    }
}
