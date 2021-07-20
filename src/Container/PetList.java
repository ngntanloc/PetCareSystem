/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Container;

import DTO.Owner;
import DTO.Pet;
import java.util.*;
import ui.Menu;
import util.MyToys;

/**
 *
 * @author Nguyen Tan Loc
 */
public class PetList {

    List<Pet> listPet;

    public PetList() {
        listPet = new ArrayList();
    }

    public void addNewPet() {
        int id, pos;
        String name, birthday, gender;

        do {
            id = MyToys.getAnInteger("Input Pet ID", "Pet ID is a positive integer", 1);
            pos = searchPetByID(id);
            if (pos >= 0) {
                System.out.println("This Pet ID is existed, please choose other id!!");
            }
        } while (pos != -1);

        name = MyToys.getString("Input a Pet Name", "Pet name can't be empty");
        birthday = MyToys.getDay("Input Pet Birthday");
        gender = MyToys.getGender("Input a Pet gender", "Pet gender is [BOY/GIRL]");
        listPet.add(new Pet(id, name, birthday, gender, null));
        System.out.println("A Pet profile is added successfully");
    }

    public void searchPet() {
        int id;
        Pet x;
        if (listPet.isEmpty()) {
            System.out.println("Pet List is empty now. Nothing to search");
            return;
        }
        id = MyToys.getAnInteger("Input Pet ID", "Pet ID must be a positive integer", 1);
        x = searchPetById(id);

        System.out.println("===========================================================");
        if (x == null) {
            System.out.println("This pet is not existed!!");
        } else {
            System.out.println("Here is the Pet's information that you want to search");
            x.showProfile();
        }
    }

    public int searchPetByID(int id) {
        if (listPet.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < listPet.size(); i++) {
                if (listPet.get(i).getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Pet searchPetById(int id) {
        if (listPet.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < listPet.size(); i++) {
                if (listPet.get(i).getId() == id) {
                    return listPet.get(i);
                }
            }
        }
        return null;

    }

    public void updatePet() {
        int id, choice;
        String name;
        String birthDay;
        String gender;
        Pet pet;

        if (listPet.isEmpty()) {
            System.out.println("Pet List is empty now, nothing to update!");
            return;
        }

        id = MyToys.getAnInteger("Input Pet ID want to update", "Pet ID must be a positive integer", 1);
        pet = searchPetById(id);

        Menu menuOption = new Menu("Option Update");
        menuOption.addNewOption("1. Update Name");
        menuOption.addNewOption("2. Update Birthday");
        menuOption.addNewOption("3. Update Gender");
        menuOption.addNewOption("4. Quit");

        if (pet == null) {
            System.out.println("This Pet ID is not existed!");
        } else {
            System.out.println("Here is information of Pet that you want to update");
            pet.showProfile();
            do {
                menuOption.printMenu();
                choice = menuOption.getChoice();
                switch (choice) {
                    case 1:
                        name = MyToys.getString("Input new Name", "Name can't be empty");
                        pet.setName(name);
                        System.out.println("Update Name successfully");
                        break;
                    case 2:
                        birthDay = MyToys.getDay("Input new Pet Birthday");
                        pet.setBirthday(birthDay);
                        System.out.println("Update Birthday successfully");
                        break;
                    case 3:
                        gender = MyToys.getGender("Input new gender", "Gender is [Boy/Girl]");
                        pet.setGender(gender);
                        System.out.println("Update Gender successfully");
                        break;
                    case 4:
                        System.out.println("Here is Pet information after update");
                        pet.showProfile();
                        break;
                }
            } while (choice != 4);
            System.out.println("The Pet Information is updated successfully");
        }
    }
    
    public void removePet(int id) {
        Pet x;
        if (listPet.isEmpty()) {
            System.out.println("Pet List is empty now. Nothing to remove");
            return;
        }

        x = searchPetById(id);

        if (x == null) {
            System.out.println("This Pet ID is not existed!");
        } else {
            listPet.remove(x);
            System.out.println("The selected Pet is removed Successfully");
        }
    }

    public void printPetListAscendingByID() {
        if (listPet.isEmpty()) {
            System.out.println("There's nothing in Pet List, please back later");
            return;
        }
        Collections.sort(listPet);
        System.out.println("---------------");
        System.out.println("Here is the Pet List");
        for (Pet pet : listPet) {
            pet.showProfile();
        }
    }

    public void printPetListAscendingByName() {
        if (listPet.isEmpty()) {
            System.out.println("There's nothing in Pet List, please back later");
            return;
        }

        Comparator nameBalance = new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(listPet, nameBalance);
        System.out.println("---------------");
        System.out.println("Here is the Pet List");
        for (Pet pet : listPet) {
            pet.showProfile();
        }
    }

    public boolean isEmpty() {
        if (listPet.isEmpty())
            return true;
        else
            return false;
    }
    
    public int inputPetId() {
        int idPet;
        Pet x;
        do {
            idPet = MyToys.getAnInteger("Input Pet ID", "Pet ID must be a positive integer", 1);
            x = searchPetById(idPet);
            if (x == null) {
                System.out.println("Pet ID is not existed, please choose again");
            }
        } while (x == null);
        return idPet;
    }
    
    public void updateOwnerIDStatus(String id) {
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getOwnerId() != null && listPet.get(i).getOwnerId().equalsIgnoreCase(id))
                listPet.get(i).setOwner(null);
        }
    }
    
    public Owner searchOwnerIDByPetID(int petId) {
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getId() == petId)
                return listPet.get(i).getOwner();
        }
        return null;
    }
    
    public int searchPetIDByOwnerID(int ownerID) {
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getOwnerId().equalsIgnoreCase(String.valueOf(ownerID)) && listPet.get(i).getOwnerId() != null )
                return listPet.get(i).getId();
        }
        return 0;
    }
    
    public int idOwnerDetectionByID(String idOwner) {
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getOwnerId() != null && listPet.get(i).getOwnerId().equalsIgnoreCase(idOwner))
                return 1;
        }
        return 0;
    }
    
    public void showPetOfOwnerID(String ownerID) {
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getOwnerId() != null && listPet.get(i).getOwnerId().equalsIgnoreCase(ownerID))
                listPet.get(i).showProfile();
        }
    }
    
    public int size() {
        return listPet.size();
    }
    
    public List<Integer> searchPetHaveOwnerID(String ownerID) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < listPet.size(); i++) {
            if (listPet.get(i).getOwnerId() != null && listPet.get(i).getOwnerId().equalsIgnoreCase(ownerID))
                list.add(listPet.get(i).getId());
        }
        return list;
    }
    
    
}
