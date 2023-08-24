import java.util.*;

/**
 * ランクB
 * クラスの継承
 */

class Customer {
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
            if (!order.equals("0")) {
                int price = sc.nextInt();
                if (order.equals("food")) {
                    customers.get(index).takeFood(price);
                } else if (order.equals("softdrink")) {
                    customers.get(index).takeSoftDrink(price);
                } else {
                    customers.get(index).takeAlcohol(price);
                }
            } else {
                customers.get(index).takeAlcohol();
            }
            
        }

        for (Customer c : customers) {
            System.out.println(c.amount);
        }
    }
}