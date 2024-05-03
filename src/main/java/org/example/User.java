package org.example;

public class User {
    private long id;
    private String name;
    private String Lastname;
    private byte age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return Lastname;
    }

    public void setLastName(String lastname) {
        this.Lastname = lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

}
