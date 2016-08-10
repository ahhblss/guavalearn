package com.lss.guava.collections;

/**
 * Created by Sean.liu on 2016/7/27.
 */
public class Person {
    private String givenName;
    private String famlyName;
    private int age;
    private String sex;
    private int ID;

    public Person(String givenName, String famlyName, int age, String sex) {
        this.givenName = givenName;
        this.famlyName = famlyName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String givenName, String famlyName, int age, String sex, int ID) {
        this.givenName = givenName;
        this.famlyName = famlyName;
        this.age = age;
        this.sex = sex;
        this.ID = ID;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamlyName() {
        return famlyName;
    }

    public void setFamlyName(String famlyName) {
        this.famlyName = famlyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
