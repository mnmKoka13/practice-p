import java.util.*;
public class Main {
    /**
     * paiza Cランク練習問題
     * 構造体の更新 Java編
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        List<accountInfo> list = new ArrayList<accountInfo>();
        
        for(int i = 0; i < N; i++) {
            accountInfo info = new accountInfo();
            info.nickname = sc.next();
            info.old = sc.nextInt();
            info.birth = sc.next();
            info.state = sc.next();
            
            list.add(info);
        }

        for (int i = 0; i < K; i++) {
            int line = sc.nextInt() - 1;
            String newName = sc.next();
            list.get(line).changeName(newName);
        }
        
        for (accountInfo a : list) {
            System.out.println(a.nickname + " " + a.old + " " + a.birth + " " + a.state);
        }

    }

}

class accountInfo {
    String nickname;
    int old;
    String birth;
    String state;
    
    void changeName(String name) {
        this.nickname = name;
    }
}