import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        ArrayList<employee> employeeList = new ArrayList<employee>();
        
        for(int i = 0; i < N; i++) {
            String command = sc.next();
            if (command.equals("make")) {
                employee e = new employee();
                e.number = sc.nextInt();
                e.name = sc.next();
                employeeList.add(e);
            } else if (command.equals("getnum")) {
                int line = sc.nextInt() - 1;
                System.out.println(employeeList.get(line).getNumber());
            } else {
                int line = sc.nextInt() - 1;
                System.out.println(employeeList.get(line).getName());
            }
        }
    }
}

class employee {
    int number;
    String name;
    
    public int getNumber() {
        return this.number;
    }
    
    public String getName() {
        return this.name;
    }
}