package kai.study.models;

public class Receiving {
    private String receiving_Method;
    private String address;

    public Receiving(String receiving_Method, String address) {
        this.receiving_Method = receiving_Method;
        this.address = address;
    }

    public String getReceiving_Method() {
        return receiving_Method;
    }

    public void setReceiving_Method(String receiving_Method) {
        this.receiving_Method = receiving_Method;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
