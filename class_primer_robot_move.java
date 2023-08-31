import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 工具箱の位置
        int lx[] = new int[10];
        int ly[] = new int[10];
        for (int i = 0; i < 10; i++) {
            lx[i] = sc.nextInt();
            ly[i] = sc.nextInt();
        }

        Robot robots[] = new Robot[n];
        // ロボットのインスタンス作成
        for (int i = 0; i < n; i++) {
            int x_n = sc.nextInt();
            int y_n = sc.nextInt();
            int l = sc.nextInt();
            
            robots[i] = new Robot(x_n, y_n, l);
        }

        // ロボットを動かす
        for (int i = 0; i < k; i++) {
            int index = sc.nextInt() - 1;
            String direction = sc.next();

            robots[index].move(direction);

            // レベルアップ判定
            for (int j = 0; j < 10; j++) {
                if (robots[index].x == lx[j] && robots[index].y == ly[j]) {
                    robots[index].levelUp();
                }
            }
        }

        // 結果出力
        for (Robot r : robots) {
            System.out.println(r.x + " " + r.y + " " + r.level);
        }

    }
}

class Robot {
    int x;
    int y;
    int level;

    static int step[] = {0, 1, 2, 5, 10};

    Robot(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.level = l;
    }

    void move(String direction) {
        if (direction.equals("N")) {
            y -= step[level];
        } else if (direction.equals("S")) {
            y += step[level];
        } else if (direction.equals("E")) {
            x += step[level];
        } else if (direction.equals("W")) {
            x -= step[level];
        }
    }

    void levelUp () {
        if (level < 4) {
            level++;
        }
    }
}
