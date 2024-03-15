import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Transactions {

    public void operationMenu(ArrayList<Employee> employeeList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nameToCheck = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Ingrese su apellido");
        String lastnameToCheck = sc.nextLine().toLowerCase();

        int ID = 0;
        int identifier = -1;
        for (Employee emple : employeeList) {

            if (emple.getName().toLowerCase().equals(nameToCheck) && emple.getLastname().toLowerCase().equals(lastnameToCheck)) {
                identifier = ID;
                break;
            }
            ID++;

        }

        if (identifier > -1) {
            Employee employeeSel = employeeList.get(identifier);
            int ind = 0;

            System.out.print(">>>Bienvenido usuario " + employeeSel.getName() + " " + employeeSel.getLastname() + " :D \nCuentas : " + "\n");
            int ID2 = 0;
            for (BankAccount bankAccount : employeeSel.getListAccounts()) {

                System.out.println("§ ID :" + (ID2 + 1) + " | Cuenta: " + employeeSel.getListAccounts().get(ind).getAccountNumber() + " |  Tipo: " + employeeSel.getListAccounts().get(ind).getType() + " | Cantidad: " + employeeSel.getListAccounts().get(ind).getAmount() + " §");
                ind++;
                ID2++;
            }
            System.out.println("Seleccione una cuenta (ID)");
            int accountIndex = sc.nextInt();
            System.out.println("Seleccionaste: \n" +
                    employeeSel.getListAccounts().get(accountIndex - 1).getAccountNumber() +
                    "\t. Tipo: " + employeeSel.getListAccounts().get(accountIndex - 1).getType());

            //quiero seleccionar una cuenta y despues poner un menu para ver si desea agregar o retirar dinero
            boolean band = true;
            do {
                System.out.println("\t<<<Operaciones>>>\n1) Depositar dinero " + "\n2) Retirar dinero\n3 Consultar saldo\n0)Regresar\n");
                int option = sc.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("¿Cuánto desea depositar?");
                        double amount = sc.nextDouble();
                        employeeSel.getListAccounts().get(accountIndex - 1).depositMoney(amount);
                    }
                    case 2 -> {
                        System.out.println("¿Cuánto desea retirar?");
                        double amount = sc.nextDouble();
                        employeeSel.getListAccounts().get(accountIndex - 1).withdrawMoney(amount);
                    }
                    case 3 -> {
                        System.out.println("Su saldo es de: $ " + employeeSel.getListAccounts().get(accountIndex - 1).getAmount());
                    }
                    case 0 -> {
                        band = false;
                    }
                }
                sc.nextLine();
            } while (band);
        } else {
            System.out.println("Usuario invalido :o");
        }
    }


}



