import java.util.*;

/**
 * ランクB
 * クラスの継承
 */

class Customer {
    static int countLeftNum = 0;
    int amount;

    Customer() {
        this.amount = 0;
    }

    public void takeFood(int m) {
        this.amount += m;
    }

    public void takeSoftDrink(int m) {
        this.amount += m;
    }

    public void takeAlcohol(int m) {}

    public void takeAlcohol() {
        this.takeAlcohol(500);
    }

    public static void leaveStore() {
        countLeftNum++;
    }
}

class AdultCustomer extends Customer {

    boolean drunk;

    AdultCustomer() {
        super();
        this.drunk = false;
    }

    public void takeFood(int m) {
        if (drunk) {
            m -= 200;
        }
        super.takeFood(m);
    }

    public void takeAlcohol(int m) {
        drunk = true;
        amount += m;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int old = sc.nextInt();
            if (old >= 20) {
                AdultCustomer customer = new AdultCustomer();
                customers.add(customer);
            } else {
                Customer customer = new Customer();
                customers.add(customer);
            }
        }

        for (int i = 0; i < K; i++) {
            int index = sc.nextInt() - 1;
            String order = sc.next();
            
            if (order.equals("0")) {
                customers.get(index).takeAlcohol();
            } else if (order.equals("A")) {
                System.out.println(customers.get(index).amount);
                customers.get(index).leaveStore();
            } else {
                int price = sc.nextInt();
                if (order.equals("food")) {
                    customers.get(index).takeFood(price);
                } else if (order.equals("softdrink")) {
                    customers.get(index).takeSoftDrink(price);
                } else {
                    customers.get(index).takeAlcohol(price);
                }
            }
            
        }
        System.out.println(Customer.countLeftNum);
    }
}