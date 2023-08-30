import java.util.Scanner;

/*
 * https://paiza.jp/challenges/share/KbJ5ecFTgtm5RL3wsGBUaSVfbIcNeGcsWGlKwsuBx2M?source=social
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        var arr = new Station[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int f = sc.nextInt();
                arr[i][j] = new Station(i, j, f);
            }
        }

        int x = sc.nextInt(); // ゴールするまでに経由すべき駅数
        Station start = arr[0][0];
        int total = 0;
        for (int i = 0; i < x; i++) {
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            Station next = arr[p][q];

            if (start.route == next.route) {
                total += Math.abs(start.fee - next.fee);
            } else {
                Station temp = arr[next.route][start.stationNum];
                total += Math.abs(temp.fee - next.fee);
            }
            start = next;
        }

        System.out.println(total);
    }
}

class Station {
    int route; // 路線
    int stationNum; // 駅番号
    int fee; // １番目の駅からの運賃

    Station (int r, int s, int f) {
        this.route = r;
        this.stationNum = s;
        this.fee = f;
    }
}