import java.util.*;

/*
 * https://paiza.jp/challenges/share/v9Aro4VV8TZ6_osPPUcRUtbqxJErolms4a9pQfk97Fc?source=social
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        String[][] arr = new String[h][w];

        ArrayList<Integer> bombsH = new ArrayList<>();
        ArrayList<Integer> bombsW = new ArrayList<>();
        
        for (int i = 0; i < h; i++) {
            String[] inArr = sc.next().split("");
            arr[i] = inArr;
            
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j].equals("#")) {
                    bombsH.add(i);
                    bombsW.add(j);
                }
            }
        }
        
        ArrayList<Integer> bombsHWithoutDupulicate = new ArrayList<>(new HashSet<>(bombsH));
        ArrayList<Integer> bombsWWithoutDupulicate = new ArrayList<>(new HashSet<>(bombsW));

        
        for (int bh : bombsHWithoutDupulicate) {
            for (int j = 0; j < w; j++) {
                arr[bh][j] = "#"; 
            }
        }
        

        for (int bw : bombsWWithoutDupulicate) {
            for (int i = 0; i < h; i++) {
                arr[i][bw] = "#";
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j].equals("#")) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}