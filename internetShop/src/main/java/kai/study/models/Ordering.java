package kai.study.models;

public class Ordering {
    private int order_ID;
    private int goods_ID;
    private int client_ID;
    private int count;
    private int price;
    private String receive_Method;
    private String pay_Method;

    public Ordering(int order_ID, int goods_ID, int client_ID, int count, int price, String receive_Method, String pay_Method) {
        this.order_ID = order_ID;
        this.goods_ID = goods_ID;
        this.client_ID = client_ID;
        this.count = count;
        this.price = price;
        this.receive_Method = receive_Method;
        this.pay_Method = pay_Method;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public int getGoods_ID() {
        return goods_ID;
    }

    public void setGoods_ID(int goods_ID) {
        this.goods_ID = goods_ID;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReceive_Method() {
        return receive_Method;
    }

    public void setReceive_Method(String receive_Method) {
        this.receive_Method = receive_Method;
    }

    public String getPay_Method() {
        return pay_Method;
    }

    public void setPay_Method(String pay_Method) {
        this.pay_Method = pay_Method;
    }
}
