package bank;

public class BankAliorBank extends KontoBankowe{
    @Override
    public void addDebit(double price) {
        this.maxDebit = price;

    }

    @Override
    public void interest() {
        this.saldo *= 1.03;
    }

    @Override
    public String toString() {
        return "BankAliorBank{" +
                "nrKonta='" + nrKonta + '\'' +
                ", saldo=" + saldo +
                ", maxDebit=" + maxDebit +
                '}';
    }
}
