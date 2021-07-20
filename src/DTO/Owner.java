/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nguyen Tan Loc
 */
public class Owner implements Comparable<Owner> {
    private String id;
    private String name;
    private String address;

    public Owner(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Pet{" + "ID=" + id + ", name=" + name + ", address=" + address + '}';
    }
    
    public void showProfile() {
        System.out.printf("|OWNER|ID: %-10s|NAME: %-15s|ADDRESS: %-15s|\n", id, name, address);
    }

    @Override
    public int compareTo(Owner that) {
        return this.id.compareToIgnoreCase(that.id);
    }
}
