package kai.study.models;

public class Category {
    private int category_ID;
    private String descr;

    public Category(int category_ID, String descr) {
        this.category_ID = category_ID;
        this.descr = descr;
    }

    public int getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(int category_ID) {
        this.category_ID = category_ID;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
