public class MainMenu {
    public static void main(String[] args) {
     /*Employee emple = new Employee("Juan","Perez");
        BankAccount cun = new BankAccount(123456789,'a');
        emple.addAccount(cun);
        Bank.addEmployee(emple);
        Bank.addAccount(cun);*/

        System.out.println("\nBievenido al banco");
        boolean flag = true;

        do {
            System.out.println("\t >>>BANCO<<< \n1) Administrar usuarios\n2) Soy empleado y quiero operar mi(s) cuenta(s)\n0) Salir");
            int opt = EmployeeController.sc.nextInt();

            switch (opt) {
                case 1 -> {
                    UsersAdministration.AdminUsers();
                }
                case 2 -> {
                    if(Bank.getEmployeeList().isEmpty()){
                        System.out.println("Actualmente no hay nadie en el registro :[");
                    }
                    else {
                        Operations.operateAccounts();
                    }
                }

                case 0 -> {
                    flag = false;
                }
                default -> {
                    System.out.println("invalid input :(");
                }
            }


        } while (flag);
    }
}
