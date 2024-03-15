import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class UsersAdministration {

    static Scanner sc = new Scanner(System.in);

    public void AdminUsers() {
        boolean band = true;
        do {
        System.out.println("\n\t<<<Administración>>>\n1) Crear empleado\n2) Crear cuenta\n3) Ver empleados\n4) Modificar cuentas\n0)Regresar\n");
        int opt = ConsoleReader.sc.nextInt();
        ConsoleReader.sc.nextLine();



            switch (opt) {
                case 1 -> {//Crear empleado
                    EmployeeController.createEmployee();
                }
                case 2 -> {// crear cuenta de banco

                    if (Bank.getEmployeeList().isEmpty()) {
                        System.out.println("No hay empleados registrados...");
                    } else {
                        System.out.println(">>>Creando cuenta...");
                        System.out.println("Numero de cuenta");
                        long nC = ConsoleReader.sc.nextLong();
                        System.out.println("Type");
                        char type = ConsoleReader.sc.next().charAt(0);

                        //validacion tipo de cuenta va en creacion de empleado
                        type = Character.toUpperCase(type); // cambiamos a mayúsculas
                        if (type != 'A' && type != 'B' && type != 'C') {
                            System.out.println("Tipo de cuenta no válido");
                        } else {
                            BankAccountController.crearCuenta(nC, type);
                        }
                    }
                }
                case 3 -> {//Ver empleados
                    if (Bank.getEmployeeList().isEmpty()){
                        System.out.println("No hay empleados registrados...");
                    }
                    else {
                        EmployeeController.seeEmployees();
                    }
                }
                case 4 -> {
                    if (Bank.getEmployeeList().isEmpty()){
                        System.out.println("No hay empleados");
                    } else {
                        BankAccountController.modifyAccount();
                    }

                /*for (BankAccount accounts : Bank.getBankAccounts()) {//for(Tipo_Objeto nombre_Objeto : Nombre_ArrayList){}
                    System.out.println(accounts.getAccountNumber() + ", " + accounts.getType() + ", " + accounts.getAmount());
                }*/
                }
                default -> {
                    System.out.println("Opción inválida...");
                }
                case 0 -> {
                    band=false;
                }
            }
        }while (band); // while (Nombre_bandera);  Seguir el ciclo si la bandera es verdadera.
                        // while (!Nombre_bandera); Seguir el ciclo si la bandera es falsa.
    }
}

