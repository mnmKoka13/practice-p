import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        
        for(int i = 0; i < N; i++) {
            String command = sc.next();
            if (command.equals("make")) {
                int number = sc.nextInt();
                String name = sc.next();
                employeeList.add(new Employee(number, name));
            } else if (command.equals("getnum")) {
                int index = sc.nextInt() - 1;
                System.out.println(employeeList.get(index).getNumber());
            } else {
                int index = sc.nextInt() - 1;
                System.out.println(employeeList.get(index).getName());
            }
        }
    }
}

class Employee {
    int number;
    String name;
    
    Employee(int number, String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }
    
    public String getName() {
        return this.name;
    }
}