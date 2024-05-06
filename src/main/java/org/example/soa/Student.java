package org.example.soa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

    @JsonProperty("cedula")
    private String ID;

    @JsonProperty("nombre")
    private String firstName;

    @JsonProperty("apellido")
    private String lastName;

    @JsonProperty("direccion")
    private String address;

    @JsonProperty("telefono")
    private String phone;

    public Student() {
    }

    public Student(String ID, String firstName, String lastName, String address, String phone) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return this.ID + " " + this.firstName + " " + this.lastName + " " + this.address + " " + this.phone;
    }
}
