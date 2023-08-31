import java.util.*;

/*
 * todo: 未解決！！
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> calender = new ArrayList<>();

        String str = "";
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            for (int j = s; j < e + 1; j++) {
                calender.add(j);
            }
        }

        List<Integer> calenderWithoutDuplicate = new ArrayList<Integer>(new HashSet<>(calender));
        Collections.sort(calenderWithoutDuplicate);
        
        // 連勤日数リスト
        // ArrayList<Integer> workDayCountList = new ArrayList<>();
        int count = 0;
        int max = 0;
        // int prevDate = 0;
        for (int i = 0; i < calenderWithoutDuplicate.size(); i++) {
            if (i == 0 || calenderWithoutDuplicate.get(i) - calenderWithoutDuplicate.get(i - 1) == 1) {
                count++;
            } else {
                count = 1;
            }
            if (max < count) {
                max = count;
            }
        }
        // 最終勤務日時点の連勤日数をリストへ追加
        // workDayCountList.add(count);
        
        System.out.println(max);
    }
}
