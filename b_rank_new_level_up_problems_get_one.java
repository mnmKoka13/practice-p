import java.util.*;
/*
 * paiza
 * Bランクレベルアップ練習問題
 * 【マップの扱い 1】マップの書き換え・1 マス
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        // String[][] board = new String[H][W];
        // for (int i = 0; i < H; i++) {
        //     String a = sc.next();
        //     String[] arr = a.split("");
        //     for (int j = 0; j < W; j++) {
        //         board[i][j] = arr[j];
        //     }
        // }

        // 模範回答
        var S = new String[H][W];

        for (var i = 0; i < H; i++) {
            S[i] = sc.next().split("");
        }

        
        // int y = sc.nextInt();
        // int x = sc.nextInt();
        // String exchange;
        
        // if (board[y][x].equals(".")) {
        //     exchange = "#";
        // } else {
        //     exchange = ".";
        // }
        
        // board[y][x] = exchange;
        
        // for (String[] a : board) {
        //     for (String b : a) {
        //         System.out.print(b);
        //     }
        //     System.out.println();
        // }

        // 模範回答
        var y = sc.nextInt();
        var x = sc.nextInt();

        if (S[y][x].equals(".")) {
            S[y][x] = "#";
        } else {
            S[y][x] = ".";
        }

        for (var i = 0; i < H; i++) {
            for (var j = 0; j < W; j++) {
                System.out.print(S[i][j]);
            }
            System.out.println();
        }
    }
}