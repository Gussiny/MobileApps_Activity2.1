package com.itesm.tarea2;

public class Amigos {
    private String name, hobby, age, phone, address;

    public Amigos(String name, String hobby, String age, String phone, String address) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
