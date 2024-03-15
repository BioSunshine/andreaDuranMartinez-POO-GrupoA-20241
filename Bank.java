import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> BankAccounts = new ArrayList<>();//declarar el arreglo
    private ArrayList<Employee> EmployeeList = new ArrayList<>();

    public void addAccount(BankAccount newBankAccount) {
        BankAccounts.add(newBankAccount);
    }

    public void addEmployee(Employee employee) {
        EmployeeList.add(employee);
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public ArrayList<Employee> getEmployeeList() {
        return EmployeeList;
    }

    //Crear empleado
    public void createEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Lastname: ");
        String lastname = sc.nextLine();
        if (name.isEmpty() && lastname.isEmpty()) {
            System.out.println("Nombre de cliente invalido");
            return;
        }
        System.out.println("Numero de cuenta");
        long nC = sc.nextLong();
        System.out.println("Type");
        char type = sc.next().charAt(0);

        type = Character.toUpperCase(type); // cambiamos a mayúsculas
        //validacion tipo de cuenta va en creacion de empleado
        if (type != 'A' && type != 'B' && type != 'C') {
            System.out.println("Tipo de cuenta no válido");
        } else {
            Employee newEmployee = new Employee(name, lastname);
            EmployeeList.add(newEmployee);
            System.out.println("Empleado creado ");
            newEmployee.addAccount(new BankAccount(nC, type));
            BankAccounts.add(new BankAccount(nC, type));
            System.out.println("Cuenta creada ");
        }

    }

    //Ver empleados
    public void seeEmployees() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) ver todos\n2) ver solo uno");
        int opt2 = sc.nextInt();

        switch (opt2) {
            case 1 -> {
                System.out.println("Recuerde que para ver todas las cuentas de un usuario en particular\n" +
                        "debe seleccionar un usuario en especifico");
                int ID = 0;
                for (Employee emple : EmployeeList) {
                    System.out.println("§ ID: " + (ID + 1) + " | Nombre: " + emple.getName() + " | Apellido: " + emple.getLastname() + " | No. cuenta banco: " + emple.getListAccounts().get(0).getAccountNumber() + " §");
                    ID++;
                }
            }
            case 2 -> {
                System.out.println("¿cuál desea ver?");

                int ID = 0;
                for (Employee emple : EmployeeList) {
                    System.out.println("ID " + (ID + 1) + ": " + emple.getName() + " " + emple.getLastname() + "\n");
                    ID++;
                }
                int opt3 = sc.nextInt();
                opt3--;

                Employee employeeSel = EmployeeList.get(opt3);
                int ind = 0, ID2 = 0;
                System.out.println(" Cuentas: ");
                for (BankAccount bankAccount : employeeSel.getListAccounts()) {

                    System.out.println("§ ID :" + (ID2 + 1) + " | Cuenta: " + employeeSel.getListAccounts().get(ind).getAccountNumber() + " |  Tipo: " + employeeSel.getListAccounts().get(ind).getType() + " | Cantidad: " + employeeSel.getListAccounts().get(ind).getAmount() + " §");
                    ind++;
                    ID2++;
                }
            }
        }
    }
    //Crear cuenta
    public  void createAccount(long nC, char type) {
        Scanner sc = new Scanner(System.in);
        BankAccount Cuenta = new BankAccount(nC, type);

        System.out.println("Elige el empleado para darle la cuenta:");

        int ID = 0;
        for (Employee emple : EmployeeList) {

            System.out.println("ID " + (ID+1) + ": " + emple.getName() + " " + emple.getLastname() + "\n");
            ID++;
        }
        int emID = sc.nextInt();
        emID--;

        Employee emp = EmployeeList.get(emID);
        emp.addAccount(Cuenta);
        BankAccounts.add(Cuenta);

        System.out.println(">>> Se asignado la cuenta "+nC+" a "+emp.getName()+" "+emp.getLastname());
    }
    //Ver cuentas
    public  void checkAllAccounts() {

        for (BankAccount accounts : BankAccounts) {//for(Tipo_Objeto nombre_Objeto : Nombre_ArrayList){}
            System.out.println(accounts.getAccountNumber() + ", " + accounts.getType() + ", " + accounts.getAmount());
        }

    }

}
