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
public class Pet implements Comparable<Pet> {
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private Owner owner;

    public Pet(int id, String name, String birthday, String gender, Owner owner) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
    }
    
    public String getOwnerId() {
        if (this.owner == null)
            return null;
        else
            return String.valueOf(this.owner.getID());
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    public void showProfile() {
        System.out.printf("|PET  |ID: %10d|NAME: %-15s|BIRTHDAY: %-10s|GENDER: %-5s|OWNER ID: %-10s|\n", id, name, birthday, gender, getOwnerId());
    }

    @Override
    public int compareTo(Pet that) {
        if (this.id > that.id)
            return 1;
        else if (this.id < that.id)
            return -1;
        else
            return 0;
    }
    
    
}
