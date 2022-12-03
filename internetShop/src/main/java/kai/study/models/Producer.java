package kai.study.models;

public class Producer {
    private String producer_Name;
    private String country;

    public Producer(String producer_Name, String country) {
        this.producer_Name = producer_Name;
        this.country = country;
    }

    public String getProducer_Name() {
        return producer_Name;
    }

    public void setProducer_Name(String producer_Name) {
        this.producer_Name = producer_Name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
