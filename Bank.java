import java.util.ArrayList;

public class Bank {

    private  ArrayList<BankAccount> BankAccounts = new ArrayList<>();//declarar el arreglo
    private   ArrayList<Employee> EmployeeList = new ArrayList<>();

    public  void addAccount (BankAccount newBankAccount){
        BankAccounts.add(newBankAccount);
    }

    public  void addEmployee(Employee employee){
        EmployeeList.add(employee);
    }

    public  ArrayList<BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public  ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }
}
