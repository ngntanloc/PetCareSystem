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
public class TimeSheet {
    private Pet pet;
    private Service service;

    public TimeSheet(Pet pet, Service service) {
        this.pet = pet;
        this.service = service;
    }

    public Pet getPet() {
        return pet;
    }
    
    public int getServicePrice() {
        if (this.service == null)
            return 0;
        else
            return this.service.getPrice();
    }
    
    public String getPetID() {
        if (this.pet == null)
            return null;
        else
            return String.valueOf(this.pet.getId());
    }
    
    public String getServiceID() {
        if (this.service == null)
            return null;
        else
            return String.valueOf(this.service.getId());
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    public void showProfile() {
        System.out.printf("|TIMESHEET|PET ID: %-10s|SERVICE ID: %-10s|\n", getPetID(), getServiceID());
    }
    
    
    
}
