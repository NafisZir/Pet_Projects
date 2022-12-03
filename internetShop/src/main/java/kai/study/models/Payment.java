package kai.study.models;

public class Payment {
    private String pay_Method;

    public Payment(String pay_Method) {
        this.pay_Method = pay_Method;
    }

    public String getPay_Method() {
        return pay_Method;
    }

    public void setPay_Method(String pay_Method) {
        this.pay_Method = pay_Method;
    }
}
