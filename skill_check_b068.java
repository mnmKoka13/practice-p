import java.util.*;

/*
 * https://paiza.jp/challenges/share/ukbpxWFJ20YqxmiijvHdvqf75dIPltWYEBbKrKN6yRA?source=social
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        int[][] chocolates = new int[h][w];
        int[] rowSums = new int[h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                chocolates[i][j] = sc.nextInt();
            }
            rowSums[i] = Arrays.stream(chocolates[i]).sum();
        }

        boolean result = true;
        String[] resultStr = new String[h];
        for (int i = 0; i < h; i++) {
            int allSum = rowSums[i];
            int aliceSum = 0;
            String str = "";
            boolean flg = false;
            for (int j = 0; j < w; j++) {
                if (!flg) {
                    aliceSum += chocolates[i][j];
                    str = str + "A";
                    if (aliceSum == allSum - aliceSum) {
                        flg = true;
                    }
                } else {
                    str = str + "B";
                }
            }
            resultStr[i] = str;
            if (!flg) {
                result = false;
                break;
            }
        }
        
        if (result) {
            System.out.println("Yes");
            for (String s : resultStr) {
                System.out.println(s);
            }
        } else {
            System.out.println("No");
        }
    }
}