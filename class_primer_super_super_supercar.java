import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<SuperCar> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int l = sc.nextInt();
            int f = sc.nextInt();

            if (type.equals("supercar")) {
                SuperCar car = new SuperCar(l, f);
                cars.add(car);
            } else if (type.equals("supersupercar")) {
                SuperSuperCar car = new SuperSuperCar(l, f);
                cars.add(car);
            } else {
                SuperSuperSuperCar car = new SuperSuperSuperCar(l, f);
                cars.add(car);
            }
        }

        for (int i = 0; i < k; i++) {
            int index = sc.nextInt() - 1;
            String command = sc.next();

            if (command.equals("run")) {
                cars.get(index).run();
            } else if (command.equals("fly")) {
                cars.get(index).fly();
            } else {
                cars.get(index).teleport();
            }
        }

        for (SuperCar c : cars) {
            System.out.println(c.mileage);
        }
    }
}

class SuperCar {
    int l; // 燃料
    int f; // 燃費
    int mileage; // 走行距離

    SuperCar (int l, int f) {
        this.l = l;
        this.f = f;
        this.mileage = 0;
    }

    void run () {
        if (l > 0) {
            this.l -= 1;
            this.mileage += f;
        }
    }

    void fly () {}

    void teleport () {}
}

class SuperSuperCar extends SuperCar {
    SuperSuperCar (int l, int f) {
        super(l, f);
    }

    void fly () {
        if (l > 4) {
            this.l -= 5;
            this.mileage += Math.pow(f, 2);
        } else {
            run();
        }
    }
}

class SuperSuperSuperCar extends SuperSuperCar {
    SuperSuperSuperCar (int l, int f) {
        super(l, f);
    }

    void fly () {
        if (l > 4) {
            this.l -= 5;
            this.mileage += (Math.pow(f, 2)) * 2;
        } else {
            run();
        }
    }

    void teleport () {
        if (l > (Math.pow(f, 2)) - 1) {
            this.l -= Math.pow(f, 2);
            this.mileage += Math.pow(f, 4);
        } else {
            fly();
        }
    }
}