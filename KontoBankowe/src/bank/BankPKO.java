package bank;

public class BankPKO extends KontoBankowe{


    @Override
    public void addDebit(double price) {
        this.maxDebit = price;
    }

    @Override
    public void interest() {
        this.saldo *= 1.05;
    }

    @Override
    public String toString() {
        return "BankPKO{" +
                "nrKonta='" + nrKonta + '\'' +
                ", saldo=" + saldo +
                ", maxDebit=" + maxDebit +
                '}';
    }
}
