package ru.kai.vvpi.realEstateAgency.models;

import javax.persistence.*;

@Entity
@Table(name = "rielt")
public class Employee {
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    public Employee(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
