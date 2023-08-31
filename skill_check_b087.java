import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        String table[][] = new String[h][w];
        for (int i = 0; i < h; i++) {
            String row[] = sc.next().split("");
            for (int j = 0; j < w; j++) {
                table[i][j] = row[j];
            }
        }
        
        // 縦横入れ替えたテーブルもつくる
        String table2[][] = new String[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                table2[j][i] = table[i][j];
            }
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        // yoko
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w - k + 1; j++) {
                String str = "";
                for (int l = 0; l < k; l++) {
                    str = str + table[i][j + l];
                }
                numbers.add(Integer.parseInt(str));
            }
        }

        // tate
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h - k + 1; j++) {
                String str = "";
                for (int l = 0; l < k; l++) {
                    str = str + table2[i][j + l];
                }
                numbers.add(Integer.parseInt(str));
            }
        }

        int max = Collections.max(numbers);
        System.out.println(max);

    }
}
