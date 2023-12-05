package my.task.appReceipt;

public class Receipt {
    private final String number;
    private final double netWorth;
    private final double VATrate;

    public Receipt(String number, double netWorth, double VATrate) {
        this.number = number;
        this.netWorth = netWorth;
        this.VATrate = VATrate;
    }

    public String getNumber() {return number;}

    public double getNetWorth() {return netWorth;}

    public double getVATrate() {return VATrate;}
}