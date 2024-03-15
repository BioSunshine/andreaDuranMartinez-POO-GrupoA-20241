import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastname;
    private ArrayList<BankAccount> listAccounts = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ArrayList<BankAccount> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(ArrayList<BankAccount> listAccounts) {
        this.listAccounts = listAccounts;
    }
    //un statico puede estar entre otros paquetes sin afectar su seguridad
    public void addAccount(BankAccount newAccount){
        listAccounts.add(newAccount);
    }
}

