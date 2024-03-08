public class BankAccount {
    private long accountNumber;

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setType(char type) {
        this.type = type;
    }

    private double amount;
    private char type;
    public BankAccount(long accountNumber, char type){
        this.accountNumber=accountNumber;
        this.type=type;
    }
    public long getAccountNumber(){
        return accountNumber;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount =amount;
    }

    public char getType(){
        return type;
    }
    public void depositMoney(double amount){
        if (type == 'A'){
            depositMoneyA(amount);
        } else if (type == 'B'){
            depositMoneyB(amount);
        } else {
            depositMoneyC(amount);
        }
    }

    private void depositMoneyA (double amount){
        if(this.amount+amount <= 50000){
            this.amount+= amount;
            System.out.println("Se depositó "+amount);
        }else{
            System.out.println("No se puede tener más de 50,000");
        }
    }
    private void depositMoneyB (double amount){
        if (this.amount+amount<= 100000){
            this.amount+= amount ;
            System.out.println("Se depositó "+amount);
        }else {
            System.out.println("No se puede tener más de 100,000 ");
        }
    }
    private void depositMoneyC (double amount){
        this.amount+= amount;
        System.out.println("Se depositó "+amount);
    }

    public void withdrawMoney (double amount){
        if (type == 'A') withdrawMoneyA(amount);
        else if (type=='B') { withdrawMoneyB(amount);
        } else { withdrawMoneyC(amount);
        }
    }
    private void withdrawMoneyA(double amount){
        if (this.amount-amount>1000){
            this.amount-=amount;
            System.out.println("Se retiró "+amount);
        } else {
            System.out.println("No se puede tener un saldo menor a 1000 en la cuenta");
        }
    }
    private void withdrawMoneyB(double amount){
        if (this.amount-amount>5000){
            this.amount-=amount;
            System.out.println("Se retiró "+amount);
        } else {
            System.out.println("No se puede tener un saldo menor a 5000 en la cuenta");
        }
    }
    private void withdrawMoneyC(double amount){
        if(this.amount-amount>10000){
            this.amount-= amount;
            System.out.println("Se retiró "+amount);
        } else {
            System.out.println("No es posible tener un saldo menor a 10,000 en la cuenta");
        }
    }
}
