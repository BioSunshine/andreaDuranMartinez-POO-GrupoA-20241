import java.util.ArrayList;

public class Bank {

    private static ArrayList<BankAccount> BankAccounts = new ArrayList<>();//declarar el arreglo
    private  static ArrayList<Employee> EmployeeList = new ArrayList<>();

    public static void addAccount (BankAccount newBankAccount){
        BankAccounts.add(newBankAccount);
    }

    public static void addEmployee(Employee employee){
        EmployeeList.add(employee);
    }

    public static ArrayList<BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public static ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }
}
