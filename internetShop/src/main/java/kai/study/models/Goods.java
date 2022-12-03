package kai.study.models;

public class Goods {
    private int goods_ID;
    private String name;
    private int price;
    private String producer_Name;
    private int category_ID;
    private int availability;
    private String image;

    public Goods(int goods_ID, String name, int price, String producer_Name, int category_ID, int availability, String image) {
        this.goods_ID = goods_ID;
        this.name = name;
        this.price = price;
        this.producer_Name = producer_Name;
        this.category_ID = category_ID;
        this.availability = availability;
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public int getGoods_ID() {
        return goods_ID;
    }

    public void setGoods_ID(int goods_ID) {
        this.goods_ID = goods_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducer_Name() {
        return producer_Name;
    }

    public void setProducer_Name(String producer_Name) {
        this.producer_Name = producer_Name;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

}
