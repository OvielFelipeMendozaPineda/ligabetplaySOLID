package models;

public class Person {
    String name;
    int age;
    String rol;
    int id;
    public Person(String name, int age, int id, String rol) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.rol = rol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
