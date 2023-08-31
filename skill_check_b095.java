import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int memberNum = sc.nextInt();
        int songLen = sc.nextInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < songLen; i++) {
            answer.add(sc.nextInt());
        }

        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 0; i < memberNum; i++) {
            int total = 100;
            for (int j = 0; j < songLen; j++) {
                int diff = Math.abs(answer.get(j) - sc.nextInt());
                if (total > 0) {
                    if (diff > 30) {
                        total -= 5;
                    } else if (diff > 20) {
                        total -= 3;
                    } else if (diff > 10) {
                        total -= 2;
                    } else if (diff > 5) {
                        total --;
                    }
                }
            }
            points.add(total);
        }
        System.out.println(Collections.max(points));
    }
}
