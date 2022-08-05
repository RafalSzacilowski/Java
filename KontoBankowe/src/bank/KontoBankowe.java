package bank;

abstract public class KontoBankowe {

    String nrKonta;
    double saldo;
    double maxDebit;

    public void addSaldo(double price){
        this.saldo += price;
    }
    public void subSaldo(double price){
        double limit = saldo + maxDebit;
        if(price <= limit) {
            this.saldo -= price;
        }else {
            System.out.println("Brak srodkow");
        }
    }


    abstract public void addDebit(double price);
    abstract public void interest();

}
