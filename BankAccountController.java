public class BankAccountController {


    public  void crearCuenta(long nC,char type) {


        BankAccount Cuenta = new BankAccount(nC, type);

        System.out.println("Elige el empleado para darle la cuenta:");

        int ID = 0;
        for (Employee emple : Bank.getEmployeeList()) {

            System.out.println("ID " + (ID+1) + ": " + emple.getName() + " " + emple.getLastname() + "\n");
            ID++;
        }
        int emID = ConsoleReader.sc.nextInt();
        emID--;

        Employee emp = Bank.getEmployeeList().get(emID);
        emp.addAccount(Cuenta);
        Bank.getBankAccounts().add(Cuenta);

        System.out.println(">>> Se asignado la cuenta "+nC+" a "+emp.getName()+" "+emp.getLastname());
    }

    public  void checkAllAccounts() {

        for (BankAccount accounts : Bank.getBankAccounts()) {//for(Tipo_Objeto nombre_Objeto : Nombre_ArrayList){}
            System.out.println(accounts.getAccountNumber() + ", " + accounts.getType() + ", " + accounts.getAmount());
        }

    }

    public  void modifyAccount(){

        System.out.println("Que cuenta quiere modificar?");
        int ID=0;
        for(BankAccount cuentas : Bank.getBankAccounts()){
            System.out.printf("§ ID %s | No. cuenta: %s §\n",(ID+1),cuentas.getAccountNumber());
            ID++;
        }
        int account = ConsoleReader.sc.nextInt();
            account--;
        BankAccount modifyBankAccount = Bank.getBankAccounts().get(account);

        System.out.print("Nuevo numero de cuenta: ");
        modifyBankAccount.setAccountNumber(ConsoleReader.sc.nextLong());

        System.out.print("Nuevo tipo de cuenta: ");
        modifyBankAccount.setType(ConsoleReader.sc.next().charAt(0));

        System.out.println(">>> Cuenta exitosamente cambiada");
    }
}
