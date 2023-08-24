import java.util.*;

public class Main {
    /**
     * paiza Cランク練習問題
     * クラスの作成
     * クラスのメンバの更新
     */
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
            } else if (command.equals("getname")) {
                int index = sc.nextInt() - 1;
                System.out.println(employeeList.get(index).getName());
            } else if (command.equals("change_num")) {
                int index = sc.nextInt() - 1;
                int newNum = sc.nextInt();
                employeeList.get(index).changeNumber(newNum);
            } else {
                int index = sc.nextInt();
                String newName = sc.next();
                employeeList.get(index).changeName(newName);
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

    public void changeNumber(int newNum) {
        this.number = newNum;
    }

    public void changeName(String newName) {
        this.name = newName;
    }
}