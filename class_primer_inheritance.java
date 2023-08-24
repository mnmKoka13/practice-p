import java.util.*;

/**
 * ランクB
 * クラスの継承
 */

class Customer {
    int old;
    int orderTotalPrice;

    Customer(int old) {
        this.old = old;
        this.orderTotalPrice = 0;
    }

    public void order(String type, int price) {
        this.orderTotalPrice = this.orderTotalPrice + price;
    }
}

class AdultCustomer extends Customer {

    boolean orderedAlcohol;

    AdultCustomer(int old) {
        super(old);
        this.orderedAlcohol = false;
    }

    public void order(String type, int price) {
        if (type.equals("alcohol")) {
            if (this.old < 20) {
                price = 0;
            } else {
                this.orderedAlcohol = true;
            }
        } else {
            if (orderedAlcohol) {
                price = price - 200;
            }
        }
        this.orderTotalPrice = this.orderTotalPrice + price;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Customer> customers = new ArrayList<Customer>();

        for (int i = 0; i < N; i++) {
            int old = sc.nextInt();
            if (old >= 20) {
                AdultCustomer customer = new AdultCustomer(old);
                customers.add(customer);
            } else {
                Customer customer = new AdultCustomer(old);
                customers.add(customer);
            }
        }

        for (int i = 0; i < K; i++) {
            int index = sc.nextInt() - 1;
            String order = sc.next();
            int price = sc.nextInt();
            
            customers.get(index).order(order, price);
        }

        for (Customer c : customers) {
            System.out.println(c.orderTotalPrice);
        }
    }
}