import java.util.*;
public class Main {
    /*
     * paiza
     * スキルチェック問題 C114
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            list.add(sc.next());
        }
        
        Boolean success = true;
        for (int i = 0; i < list.size() - 1; i++) {
            String a = list.get(i);
            String b = list.get(i + 1);
            String aEnd = a.substring(a.length() - 1, a.length());
            String bStart = b.substring(0, 1);
            if (aEnd.equals(bStart)) {
                continue;
            } else {
                success = false;
                System.out.println(aEnd + " " + bStart);
                break;
            }
        }
        
        if (success) {
            System.out.println("Yes");
        }
    }
}