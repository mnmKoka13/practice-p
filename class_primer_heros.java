import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int numHero = sc.nextInt();
        int eventNum = sc.nextInt();

        ArrayList<Hero> heros = new ArrayList<>();
        for (int i = 0; i < numHero; i++) {
            heros.add(new Hero(
                sc.nextInt(), // level
                sc.nextInt(), // hp
                sc.nextInt(), // attack
                sc.nextInt(), // defense
                sc.nextInt(), // speed
                sc.nextInt(), // clever
                sc.nextInt() // fortune
            ));
        }

        for (int i = 0; i < eventNum; i++) {
            int indexHero = sc.nextInt() - 1;
            String event = sc.next();

            switch(event) {
                case "levelup": 
                    heros.get(indexHero).levelUp(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case "muscle_training":
                    heros.get(indexHero).muscleTraining(sc.nextInt(), sc.nextInt());
                    break;
                case "running":
                    heros.get(indexHero).running(sc.nextInt(), sc.nextInt());
                    break;
                case "study":
                    heros.get(indexHero).study(sc.nextInt());
                    break;
                case "pray":
                    heros.get(indexHero).pray(sc.nextInt());
                    break;
            }
        }

        for (Hero h : heros) {
            System.out.print(h.level + " " + h.hp + " " + h.attack + " " + h.defence + " " + h.speed + " " + h.clever + " " + h.fortune);
            System.out.println();
        }
    }
}

class Hero {

    int level;
    int hp;
    int attack;
    int defence;
    int speed;
    int clever;
    int fortune;

    Hero(int l, int h, int a, int d, int s, int c, int f) {
        this.level = l;
        this.hp = h;
        this.attack = a;
        this.defence = d;
        this.speed = s;
        this.clever = c;
        this.fortune = f;
    }

    void levelUp(int h, int a, int d, int s, int c, int f) {
        this.level++;
        this.hp += h;
        this.attack += a;
        this.defence += d;
        this.speed += s;
        this.clever += c;
        this.fortune += f;
    }

    void muscleTraining(int h, int a) {
        this.hp += h;
        this.attack += a;
    }

    void running(int d, int s) {
        this.defence += d;
        this.speed += s;
    }

    void study(int c) {
        this.clever += c;
    }

    void pray(int f) {
        this.fortune += f;
    }
}