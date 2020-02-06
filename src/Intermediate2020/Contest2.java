package Intermediate2020;

import java.util.LinkedList;
import java.util.Scanner;

public class Contest2 {

    static void check(LinkedList qa, LinkedList qb) {
        if ((qa.size() == 0) || (qb.size() == 0)) return;
        LinkedList a = (LinkedList) qa.clone();
        LinkedList b = (LinkedList) qb.clone();
        checksame(qa, qb);
        checkahead(qa, qb);
        if (!((a.equals(qa)) && (b.equals(qb)))) check(qa, qb);
    }

    static void checkahead (LinkedList qa, LinkedList qb) {
        if ((qa.size() == 0) || (qb.size() == 0)) return;
        LinkedList a = (LinkedList) qa.clone();
        LinkedList b = (LinkedList) qb.clone();
        for (int i = 0; i < Math.min(qa.size(), qb.size()) - 1; i++) {
            if ((qa.size() == 0) || (qb.size() == 0)) return;
            if (qb.get(i + 1) == qa.get(i)) {
                qb.remove(i);
                qb.remove(i);
                qa.remove(i);
                checksame(qa, qb);
                i--;
            } else if (qa.get(i + 1) == qb.get(i)) {
                qa.remove(i);
                qa.remove(i);
                qb.remove(i);
                checksame(qa, qb);
                i--;
            }
        }
        if ((qa.size() == 0) || (qb.size() == 0)) return;
        if (qa.size() > qb.size()) {
            if (qa.get(qb.size()) == qb.get(qb.size() - 1)) {
                qa.remove(qb.size() - 1);
                qa.remove(qb.size() - 1);
                qb.remove(qb.size() - 1);
            }
        } else if (qa.size() != qb.size()) {
            if (qb.get(qa.size()) == qa.get(qa.size() - 1)) {
                qb.remove(qa.size() - 1);
                qb.remove(qa.size() - 1);
                qa.remove(qa.size() - 1);
            }
        }
        if (!((a.equals(qa)) && (b.equals(qb)))) checkahead(qa, qb);
    }

    static void checksame (LinkedList qa, LinkedList qb) {
        if ((qa.size() == 0) || (qb.size() == 0)) return;
        LinkedList a = (LinkedList) qa.clone();
        LinkedList b = (LinkedList) qb.clone();
        for (int j = 0; j < Math.min(qa.size(), qb.size()); j++) {
            if (qa.get(j) == qb.get(j)) {
                qa.remove(j);
                qb.remove(j);
                if ((qa.size() == 0) || (qb.size() == 0)) return;
                j--;
            }
        }
        if (!((a.equals(qa)) && (b.equals(qb)))) checksame(qa, qb);
    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String a = sc.next();
            String b = sc.next();
            
            LinkedList<Character> qa = new LinkedList<>();
            for (int j = 0; j < a.length(); j++) {
                qa.add(a.charAt(j));
            }
            LinkedList<Character> qb = new LinkedList<>();
            for (int j = 0; j < b.length(); j++) {
                qb.add(b.charAt(j));
            }

            check(qa, qb);

            int sum = 0;
            for (int j = 0; j < Math.min(qa.size(), qb.size()); j++) {
                sum += qa.get(j) - qb.get(j);
            }
            sum += Math.abs(qa.size() - qb.size());
            System.out.println(i + 1 + ".  " + sum);
        }

        
    }

}
