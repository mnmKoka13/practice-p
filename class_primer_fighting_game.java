import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Player player = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            players.add(player);
        }

        for (int i = 0; i < k; i++) {
            int pIndex1 = sc.nextInt() - 1;
            int t1 = sc.nextInt() - 1;
            int pIndex2 = sc.nextInt() - 1;
            int t2 = sc.nextInt() - 1;

            Player p1 = players.get(pIndex1);
            Player p2 = players.get(pIndex2);
            if (!p1.isAlive() || !p2.isAlive()) {
                continue;
            }

            if (p1.techs[t1].isEnhance && p2.techs[t2].isEnhance) {
                p1.enchance();
                p2.enchance();
            } else if (p1.techs[t1].isEnhance) {
                p1.enchance();
                p1.takeDamage(p2.techs[t2].attack);
            } else if (p2.techs[t2].isEnhance) {
                p2.enchance();
                p2.takeDamage(p1.techs[t1].attack);
            } else if (p1.techs[t1].frame > p2.techs[t2].frame) {
                p1.takeDamage(p2.techs[t2].attack);
            } else if (p1.techs[t1].frame < p2.techs[t2].frame) {
                p2.takeDamage(p1.techs[t1].attack);
            }

        }
        int count = 0;
        for (Player p : players)  {
            if(p.isAlive()) {
                count++;
            }
        }
        System.out.println(count);
    }
}

class Player {
    int hp;
    Technique[] techs = new Technique[3];

    Player(int h, int f1, int a1, int f2, int a2, int f3, int a3) {
        this.hp = h;
        techs[0] = new Technique(f1, a1);
        techs[1] = new Technique(f2, a2);
        techs[2] = new Technique(f3, a3);
    }

    void enchance () {
        for (int i = 0; i < 3; i++) {
            Technique tech = this.techs[i];
            if (!tech.isEnhance) {
                tech.frame = tech.frame - 3 > 1 ? tech.frame - 3 : 1;
                tech.attack += 5;
            }
        }
    }

    boolean isAlive() {
        if (this.hp > 0) {
            return true;
        } else {
            return false;
        }
    }

    void takeDamage (int d) {
        this.hp -= d;
    }
}

class Technique {
    int frame;
    int attack;
    boolean isEnhance = false;

    Technique(int f, int a) {
        this.frame = f;
        this.attack = a;
        if (f == 0 && a == 0) {
            this.isEnhance = true;
        }
    }
}