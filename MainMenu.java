import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBievenido al banco");
        boolean flag = true;
        Bank bank = new Bank();

        do {
            System.out.println("Opciones :\n1) Crear empleado\n2) Ver empleado\n3) Crear cuenta\n4) Ver cuentas\n5) Transacciones\n0) Salir");
            int opt = sc.nextInt();

            switch (opt){
                case 1 ->{
                    bank.createEmployee();
                }
                case 2 ->{
                    bank.seeEmployees();
                }
                case 3 ->{

                    if (bank.getEmployeeList().isEmpty()) {
                        System.out.println("No hay empleados registrados...");
                    } else {
                        System.out.println(">>>Creando cuenta...");
                        System.out.println("Numero de cuenta");
                        long nC = sc.nextLong();
                        System.out.println("Type");
                        char type = sc.next().charAt(0);

                        //validacion tipo de cuenta va en creacion de empleado
                        type = Character.toUpperCase(type); // cambiamos a mayúsculas
                        if (type != 'A' && type != 'B' && type != 'C') {
                            System.out.println("Tipo de cuenta no válido");
                        } else {
                            bank.createAccount(nC, type);
                        }
                    }
                }
                case 4 ->{
                    bank.checkAllAccounts();
                }
                case 5 ->{
                    Transactions transactions = new Transactions();
                    transactions.operationMenu(bank.getEmployeeList());
                }
                case 0 ->{
                    flag=false;
                }
                default -> {
                    System.out.println("nmms no");
                }
            }
        } while (flag);
    }
}
