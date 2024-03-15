import java.util.Scanner;

public class EmployeeController {

   static Scanner sc =new Scanner(System.in);

    public void createEmployee() {

        System.out.println("Name: ");
        String name = ConsoleReader.sc.nextLine();
        System.out.println("Lastname: ");
        String lastname = ConsoleReader.sc.nextLine();
        if (name.isEmpty() && lastname.isEmpty()) {
            System.out.println("Nombre de cliente invalido");
            return;
        }
        System.out.println("Numero de cuenta");
        long nC = ConsoleReader.sc.nextLong();
        System.out.println("Type");
        char type = ConsoleReader.sc.next().charAt(0);

        type = Character.toUpperCase(type); // cambiamos a mayúsculas
        //validacion tipo de cuenta va en creacion de empleado
        if (type!='A'&& type!='B'&&type!='C'){
            System.out.println("Tipo de cuenta no válido");
        }
        else {
            Employee newEmployee = new Employee(name, lastname);
            Bank.addEmployee(newEmployee);
            System.out.println("Empleado creado ");
            newEmployee.addAccount(new BankAccount(nC,type));
            Bank.addAccount(new BankAccount(nC, type));
            System.out.println("Cuenta creada ");
        }

    }

    public void seeEmployees(){
        System.out.println("1) ver todos\n2) ver solo uno");
        int opt2 = sc.nextInt();

        switch (opt2) {
            case 1 -> {
                System.out.println("Recuerde que para ver todas las cuentas de un usuario en particular\n" +
                        "debe seleccionar un usuario en especifico");
                int ID = 0;
                for (Employee emple : Bank.getEmployeeList()) {
                    System.out.println("§ ID: " + (ID+1) + " | Nombre: " + emple.getName() + " | Apellido: " + emple.getLastname() + " | No. cuenta banco: " + emple.getListAccounts().get(0).getAccountNumber()+" §");
                    ID++;
                }
            }
            case 2 -> {
                System.out.println("¿cuál desea ver?");

                int ID = 0;
                for (Employee emple : Bank.getEmployeeList()) {
                    System.out.println("ID " + (ID+1) + ": " + emple.getName() + " " + emple.getLastname() + "\n");
                    ID++;
                }
                int opt3 = sc.nextInt();
                opt3--;

                Employee employeeSel = Bank.getEmployeeList().get(opt3);
                int ind = 0, ID2=0;
                System.out.println(" Cuentas: ");
                for (BankAccount bankAccount : employeeSel.getListAccounts()) {

                    System.out.println("§ ID :" + (ID2 + 1) + " | Cuenta: " + employeeSel.getListAccounts().get(ind).getAccountNumber() + " |  Tipo: " + employeeSel.getListAccounts().get(ind).getType() + " | Cantidad: " + employeeSel.getListAccounts().get(ind).getAmount() + " §");
                    ind++;
                    ID2++;
                }
            }
        }


    }
        }
