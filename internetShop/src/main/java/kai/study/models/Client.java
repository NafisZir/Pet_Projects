package kai.study.models;

public class Client {
    private int client_ID;
    private String name;
    private String phone;
    private String email;
    private String password;

    public Client(){

    }
    public Client(int client_ID, String name, String email, String password) {
        this.client_ID = client_ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = null;
    }

    public Client(int client_ID, String name, String phone, String email, String password) {
        this.client_ID = client_ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
