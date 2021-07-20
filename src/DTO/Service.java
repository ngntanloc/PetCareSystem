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
public class Service implements Comparable<Service> {
    private int id;
    private String name;
    private int price;

    public Service(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public void showProfile() {
        System.out.printf("|SERVICE|ID: %-10s|NAME: %-15s|PRICE: %10d|\n", id, name, price);
    }

    @Override
    public int compareTo(Service that) {
        if (this.id > that.id)
            return 1;
        else if (this.id < that.id)
            return -1;
        else
            return 0;
    }
    
}
