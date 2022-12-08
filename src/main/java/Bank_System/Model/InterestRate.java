package Bank_System.Model;

import Bank_System.KyHan;

public class InterestRate {
    private int id;
    private Double amount;
    private KyHan period;

    public InterestRate(Double laixuat, KyHan kyhan) {
        this.amount = laixuat;
        this.period = kyhan;
    }

    public InterestRate() {

    }

    @Override
    public String toString() {
        return String.format("Thông tin lãi xuất:\nLãi xuất:%.2f\nKỳ hạn:%s\n", this.amount, this.period);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public KyHan getPeriod() {
        return period;
    }

    public void setPeriod(KyHan period) {
        this.period = period;
    }
}
