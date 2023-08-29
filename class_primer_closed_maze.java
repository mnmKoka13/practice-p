import java.util.*;

class Point {
    String alphabet;
    int firstAisle;
    int secondAisle;

    Point (String s, int i, int j) {
        this.alphabet = s;
        this.firstAisle = i;
        this.secondAisle = j;
    }
    // 模範回答
    // char a;
    // int[] road;

    // Point(char a, int r1, int r2) {
    //     this.a = a;
    //     this.road = new int[] { r1, r2 };
    // }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int numPoint = sc.nextInt();
        int numMove = sc.nextInt();
        int startPoint = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < numPoint; i++) {
            arr.add(new Point(sc.next(), sc.nextInt(), sc.nextInt()));
        }
        // 模範回答
        // Point[] points = new Point[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     String a = sc.next();
        //     int r1 = sc.nextInt();
        //     int r2 = sc.nextInt();
        //     points[i] = new Point(a.charAt(0), r1, r2);
        // }

        Point obj = arr.get(startPoint - 1);
        System.out.print(obj.alphabet);
        int nextIndex;
        for (int i = 0; i < numMove; i++) {
            int nextNum = sc.nextInt();
            if (nextNum == 1) {
                nextIndex = obj.firstAisle - 1;
            } else {
                nextIndex = obj.secondAisle - 1;
            }
            obj = arr.get(nextIndex);
            System.out.print(obj.alphabet);
        }
                
        // 模範回答
        // int now = s;
        // StringBuilder sb = new StringBuilder();
        // sb.append(points[now].a);

        // for (int i = 0; i < k; i++) {
        //     int m = sc.nextInt() - 1;
        //     now = points[now].road[m];
        //     sb.append(points[now].a);
        // }

        // System.out.println(sb.toString());
    }
}