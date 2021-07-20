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
public class OwnerList {

    List<Owner> listOwner;

    public OwnerList() {
        listOwner = new ArrayList();
    }

    public void addNewOwner() {
        int pos;
        String id, name, address;
        do {
            id = MyToys.getString("Input a Owner ID", "Owner ID can't be empty");
            pos = searchOwnerByID(id);
            if (pos >= 0) {
                System.out.println("Owner ID is existed, please input again");
            }
        } while (pos != -1);

        name = MyToys.getString("Input a Owner Name", "Owner Name can't be empty");
        address = MyToys.getString("Input Owner Address", "Owner Address can't be empty");
        listOwner.add(new Owner(id, name, address));
        System.out.println("A Owner profile is added successfully");
    }

    public void searchOwner() {
        String id;
        Owner x;
        if (listOwner.isEmpty()) {
            System.out.println("Owner List is empty now. Nothing to search");
            return;
        }

        id = MyToys.getString("Input Owner ID", "Owner ID can't be empty");
        x = searchOwnerById(id);
        if (x == null) {
            System.out.println("This owner is not existed");
        } else {
            System.out.println("Here is the Owner's information that you want to search");
            x.showProfile();
        }
    }

    public int searchOwnerByID(String id) {
        if (listOwner.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < listOwner.size(); i++) {
                if (listOwner.get(i).getID().equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Owner searchOwnerById(String id) {
        if (listOwner.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < listOwner.size(); i++) {
                if (listOwner.get(i).getID().equalsIgnoreCase(id)) {
                    return listOwner.get(i);
                }
            }
        }
        return null;
    }

    public void updateOwner() {
        int choice;
        String idOwner;
        String name;
        String address;
        Pet pet;
        Owner owner;

        if (listOwner.isEmpty()) {
            System.out.println("Owner List is empty now, nothing to update!");
            return;
        }

        idOwner = MyToys.getString("Intput Owner ID", "Owner ID can't be empty");
        owner = searchOwnerById(idOwner);

        Menu menuOption = new Menu("Option Update");
        menuOption.addNewOption("1. Update Name");
        menuOption.addNewOption("2. Update Address");
        menuOption.addNewOption("3. Quit");
        if (owner == null) {
            System.out.println("This Owner ID is not existed!");
        } else {
            System.out.println("Here is information of Owner");
            owner.showProfile();
            do {
                menuOption.printMenu();
                choice = menuOption.getChoice();
                switch (choice) {
                    case 1:
                        name = MyToys.getString("Input new Name", "Name can't be empty");
                        owner.setName(name);
                        System.out.println("Update Name successfully");
                        break;
                    case 2:
                        address = MyToys.getString("Input new adddress", "Birthday must has format [dd/mm/yyyy]");
                        owner.setAddress(address);
                        System.out.println("Update Address successfully");
                        break;
                    case 3:
                        System.out.println("Here is Owner information after update");
                        owner.showProfile();
                        break;
                }
            } while (choice != 3);
            System.out.println("The Owner Information is updated successfully");
        }
    }

    public void removeOwner(String id) {
        Owner owner;
        if (listOwner.isEmpty()) {
            System.out.println("Owner List is empty now. Nothing to remove");
            return;
        }
        owner = searchOwnerById(id);
        if (owner == null) {
            System.out.println("This Owner ID not existed!");
        } else {
            listOwner.remove(owner);
            System.out.println("The selected Owner is removed successfully");
        }
    }
    
    public void printOwnerListAscendingByID() {
        if (listOwner.isEmpty()) {
            System.out.println("There's nothing in Owner List, please back later");
            return;
        }
        Collections.sort(listOwner);
        System.out.println("---------------");
        System.out.println("Here is the Owner List");
        for (Owner owner : listOwner) {
            owner.showProfile();
        }
    }

    public void printOwnerListAscendingByName() {
        if (listOwner.isEmpty()) {
            System.out.println("There's nothing in Owner List, please back later");
            return;
        }

        Comparator nameBalance = new Comparator<Owner>() {
            @Override
            public int compare(Owner o1, Owner o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        Collections.sort(listOwner, nameBalance);
        System.out.println("---------------");
        System.out.println("Here is the Owner List");
        for (Owner owner : listOwner) {
            owner.showProfile();
        }
    }
    
    public boolean isEmpty() {
        if (listOwner.isEmpty())
            return true;
        else
            return false;
    }
    
    public String inputOwnerId() {
        String idOwner;
        Owner x;
        do {
            idOwner = MyToys.getString("Input Owner ID", "Owner ID can't be empty");
            x = searchOwnerById(idOwner);
            if (x == null) {
                System.out.println("Owner ID is not existed, please choose again");
            }
        } while (x == null);
        return idOwner;
    }

}
