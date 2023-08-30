import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 予約されている座席の数
        int h = sc.nextInt(); // 座席の縦の数
        int w = sc.nextInt(); // 座席の横の数
        int p = sc.nextInt(); // 最も見やすい席の座標ｐ
        int q = sc.nextInt(); // 最も見やすい席の座標ｑ

        Seat[][] seats = new Seat[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                seats[i][j] = new Seat(i, j, p, q);
            }
        }

        for (int i = 0; i < n; i++) {
            int bookedY = sc.nextInt();
            int bookedX = sc.nextInt();
            seats[bookedY][bookedX].book();
        }

        ArrayList<Seat> availableList = new ArrayList<>();
        ArrayList<Integer> manhattanList = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!seats[i][j].booked) {
                    availableList.add(seats[i][j]);
                    manhattanList.add(seats[i][j].manhattan);
                }
            }
        }

        Collections.sort(manhattanList);
        int min = manhattanList.get(0);

        List<Seat> filterList = availableList.stream()
            .filter(seat -> seat.manhattan == min).collect(Collectors.toList());
        
        for (Seat s : filterList) {
            System.out.println(s.y + " " + s.x);
        }
        
    }
}

class Seat {
    int x;
    int y;
    int manhattan;
    boolean booked;

    Seat (int y, int x, int p, int q) {
        this.y = y;
        this.x = x;
        this.manhattan = Math.abs(p - y) + Math.abs(q - x);
        this.booked = false;
    }

    void book() {
        this.booked = true;
    }
}