package Intermediate2020;

import java.util.*;

public class Contest3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][][] diagram = new int[4][4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j < 2) diagram[i][j][0]++;
                if ((j == 1) || (j == 2)) diagram[i][j][2]++;
                if (i < 2) diagram[i][j][1]++;
                if ((i == 1) || (i == 2)) diagram[i][j][3]++;
            }
        }
        for (int i = 0; i < 5; i++) {
            int[][][] curr = new int[4][4][5];
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 5; l++) {
                        curr[j][k][l] = diagram[j][k][l];
                    }
                }
            }
            String line = sc.nextLine() + "+";
            int[] condition = new int[]{2, 2, 2, 2};
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '~') {
                    condition[line.charAt(++j) - 65] = 0;
                } else if (line.charAt(j) == '+') {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            for (int m = 0; m < 4; m++) {
                                if (curr[k][l][4] == 1) break;
                                if ((condition[m] != 2) && (condition[m] != curr[k][l][m])) break;
                                if (m == 3) curr[k][l][4] = 1;
                            }
                        }
                    }
                    condition = new int[]{2, 2, 2, 2};
                } else condition[line.charAt(j) - 65] = 1;
            }
            String output = "";
            for (int j = 0; j < 4; j++) {
                int temp = 0;
                for (int k = 0; k < 4; k++) {
                    temp += curr[j][k][4]*Math.pow(2.00, 3-k);
                }
                if (temp > 9) {
                    output += (char)(temp + 55);
                } else output += Integer.toString(temp);
            }
            System.out.println(i + 1 + ". " + output);
        }

    }

}
