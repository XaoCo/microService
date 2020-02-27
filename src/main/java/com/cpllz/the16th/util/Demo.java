package com.cpllz.the16th.util;

/**
 * @auther admin
 * @date 2020/2/26 17:23
 */
public class Demo {

    /**
     * name
     */
    private String name;

    /**
     * addr
     */
    private String addr;

    /**
     * age
     */
    private int age;

    public Demo(String name, String addr, int age) {
        this.name = name;
        this.addr = addr;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
