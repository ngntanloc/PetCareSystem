/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Container;

import DTO.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ui.Menu;
import util.MyToys;

/**
 *
 * @author Nguyen Tan Loc
 */
public class ServiceList {

    List<Service> listService;

    public ServiceList() {
        listService = new ArrayList();
    }

    public void addNewService() {
        int id, price, pos;
        String name;
        do {
            id = MyToys.getAnInteger("Input a Services ID", "Service ID must be a positive integer", 1);
            pos = searchServiceByID(id);
            if (pos >= 0) {
                System.out.println("This Service ID is existed, please input again");
            }
        } while (pos != -1);
        name = MyToys.getString("Input Service Name", "Service Name can't be empty");
        price = MyToys.getAnInteger("Input a Servicer Price", "Service Price must be in [0..1000000000]", 1, 1000000001);

        listService.add(new Service(id, name, price));
        System.out.println("A Service profile is added successfully");
    }

    public int searchServiceByID(int id) {
        if (listService.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < listService.size(); i++) {
                if (listService.get(i).getId() == id) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Service searchServiceById(int id) {
        if (listService.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < listService.size(); i++) {
                if (listService.get(i).getId() == id) {
                    return listService.get(i);
                }
            }
        }
        return null;
    }

    public void printAllService() {
        if (listService.isEmpty()) {
            System.out.println("There's nothing in Service List, please back later");
            return;
        }
        System.out.println("Here is the Service List");
        for (Service service : listService) {
            service.showProfile();
        }
    }

    public void searchService() {
        int id;
        Service x;
        if (listService.isEmpty()) {
            System.out.println("Service List is empty now. Nothing to search");
            return;
        }
        id = MyToys.getAnInteger("Input Service ID", "Service ID must be a positive integer", 1);
        x = searchServiceById(id);

        System.out.println("===========================================================");
        if (x == null) {
            System.out.println("This service is not existed!!");
        } else {
            System.out.println("Here is the Service's information that you want to search");
            x.showProfile();
        }
    }

    public void updateService() {
        int choice;
        int idService;
        String name;
        int price;
        Service service;

        if (listService.isEmpty()) {
            System.out.println("Service List is empty now, nothing to update!");
            return;
        }

        idService = MyToys.getAnInteger("Intput Service ID", "Service ID must be a positive integer", 1);
        service = searchServiceById(idService);

        Menu menuOption = new Menu("Option Update");
        menuOption.addNewOption("1. Update Name");
        menuOption.addNewOption("2. Update Price");
        menuOption.addNewOption("3. Quit");
        if (service == null) {
            System.out.println("This Service ID is not existed!");
        } else {
            System.out.println("Here is information of Service");
            service.showProfile();
            do {
                menuOption.printMenu();
                choice = menuOption.getChoice();
                switch (choice) {
                    case 1:
                        name = MyToys.getString("Input new Name", "Name can't be empty");
                        service.setName(name);
                        System.out.println("Update Name successfully");
                        break;
                    case 2:
                        price = MyToys.getAnInteger("Input new Price", "Price must be a postive number", 1);
                        service.setPrice(price);
                        System.out.println("Update Price successfully");
                        break;
                    case 3:
                        System.out.println("Here is Service information after update");
                        service.showProfile();
                        break;
                }
            } while (choice != 3);
            System.out.println("The Service Information is updated successfully");
        }
    }

    public void removeService(int id) {
        Service x;
        if (listService.isEmpty()) {
            System.out.println("Service List is empty now. Nothing to remove");
            return;
        } else {

            x = searchServiceById(id);

            if (x == null) {
                System.out.println("This Service ID is not existed!");
            } else {
                // update status of Service ID for Timesheet status if existed Service ID corresponding
                listService.remove(x);
                System.out.println("The selected Service is removed Successfully");
            }
        }
    }

    public boolean isEmpty() {
        if (listService.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public int intputServiceId() {
        int idService;
        Service x;
        do {
            idService = MyToys.getAnInteger("Input Service ID", "Service ID must be a positive integer", 1);
            x = searchServiceById(idService);
            if (x == null) {
                System.out.println("Service ID is not existed, please choose again");
            }
        } while (x == null);
        return idService;
    }

    // PRINT
    public void printServiceListAscendingByID() {
        if (listService.isEmpty()) {
            System.out.println("There's nothing in Service List to print");
            return;
        }

        Collections.sort(listService);
        System.out.println("----------------");
        System.out.println("Here is the Course List");
        for (Service service : listService) {
            service.showProfile();
        }
    }

    public void printServiceListAscendingByName() {
        if (listService.isEmpty()) {
            System.out.println("There's nothing in Service List to print");
            return;
        }

        Comparator nameBalance = new Comparator<Service>() {
            @Override
            public int compare(Service o1, Service o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

        Collections.sort(listService, nameBalance);
        System.out.println("----------------");
        System.out.println("Here is the Course List");
        for (Service service : listService) {
            service.showProfile();
        }

    }

}
