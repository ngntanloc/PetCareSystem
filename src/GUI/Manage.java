/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Container.LogList;
import Container.OwnerList;
import Container.PetList;
import Container.ServiceList;
import DTO.Owner;
import DTO.Pet;
import DTO.Service;
import DTO.TimeSheet;
import java.util.ArrayList;
import java.util.List;
import ui.Menu;

/**
 *
 * @author Nguyen Tan Loc
 */
public class Manage {

    public static void main(String[] args) {
        Menu menuUI = new Menu("PET CARE SYSTEM");
        menuUI.addNewOption("---MENU---");
        menuUI.addNewOption("1. MANAGE THE PET LIST");
        menuUI.addNewOption("2. MANAGE THE OWNER LIST");
        menuUI.addNewOption("3. MANAGE THE SERVICE LIST");
        menuUI.addNewOption("4. SET RELATION FUNTIONS");
        menuUI.addNewOption("5. EXTRA FUNTIONS");
        menuUI.addNewOption("6. EXIT");

        PetList listPet = new PetList();
        OwnerList listOwner = new OwnerList();
        ServiceList listService = new ServiceList();
        LogList listLog = new LogList();

        String idOwner;
        int idPet, idService;

        Pet pet;
        Owner owner;
        Service service;

        int choiceAll, choice;

        do {
            menuUI.printMenu();
            choiceAll = menuUI.getChoice();
            switch (choiceAll) {
                case 1:
                    Menu menuPet = new Menu("PET LIST");
                    menuPet.addNewOption("1. Add a new Pet profile");
                    menuPet.addNewOption("2. Search a Pet profile");
                    menuPet.addNewOption("3. Update a Pet profile");
                    menuPet.addNewOption("4. Remove a Pet profile");
                    menuPet.addNewOption("5. Print Pet List profile ascending by ID");
                    menuPet.addNewOption("6. Print Pet List profile ascending by Name");
                    menuPet.addNewOption("7. Quit");
                    do {
                        menuPet.printMenu();
                        choice = menuPet.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.println("You are preparing to input a new Pet profile");
                                listPet.addNewPet();
                                break;
                            case 2:
                                System.out.println("You are required to input Pet ID to search profile");
                                listPet.searchPet();
                                break;
                            case 3:
                                System.out.println("You are required to input Pet ID to update profile");
                                listPet.updatePet();
                                break;
                            case 4:
                                System.out.println("You are required to input Pet ID to remove profile");
                                idPet = listPet.inputPetId();
                                if (listLog.idPetDetection(idPet) == 1) {
                                    System.out.println("Your Pet now using Service, can't remove");
                                    break;
                                }
                                listPet.removePet(idPet);

                                break;
                            case 5:
                                System.out.println("You are preparing to Print Pet List profile ascending by ID");
                                listPet.printPetListAscendingByID();
                                break;
                            case 6:
                                System.out.println("You are preparing to Print Pet List profile ascending by Name");
                                listPet.printPetListAscendingByName();
                                break;
                            case 7:
                                System.out.println("You choose out of PET LIST");
                                break;
                        }
                    } while (choice != 7);
                    break;
                case 2:
                    Menu menuOwner = new Menu("OWNER LIST");
                    menuOwner.addNewOption("1. Add a new OWNER profile");
                    menuOwner.addNewOption("2. Search a OWNER profile");
                    menuOwner.addNewOption("3. Update a OWNER profile");
                    menuOwner.addNewOption("4. Remove a OWNER profile");
                    menuOwner.addNewOption("5. Print OWNER List profile ascending by ID");
                    menuOwner.addNewOption("6. Print OWNER List profile ascending by Name");
                    menuOwner.addNewOption("7. Quit");
                    do {
                        menuOwner.printMenu();
                        choice = menuOwner.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.println("You are preparing to input a new OWNER profile");
                                listOwner.addNewOwner();
                                break;
                            case 2:
                                System.out.println("You are required to input OWNER ID to search profile");
                                listOwner.searchOwner();
                                break;
                            case 3:
                                System.out.println("You are required to input OWNER ID to update profile");
                                listOwner.updateOwner();
                                break;
                            case 4:
                                System.out.println("You are required to input OWNER ID to remove profile");
                                idOwner = listOwner.inputOwnerId();
                                if (listPet.idOwnerDetectionByID(idOwner) == 1) {
                                    System.out.println("This Owner has relation with Pet now, can't remove");
                                    break;
                                }
                                listOwner.removeOwner(idOwner);
                                break;
                            case 5:
                                System.out.println("You are preparing to Print OWNER List profile ascending by ID");
                                listOwner.printOwnerListAscendingByID();
                                break;
                            case 6:
                                System.out.println("You are preparing to Print OWNER List profile ascending by Name");
                                listOwner.printOwnerListAscendingByName();
                                break;
                            case 7:
                                System.out.println("You choose out of OWNER LIST");
                                break;
                        }
                    } while (choice != 7);
                    break;
                case 3:
                    Menu menuService = new Menu("SERVICE LIST");
                    menuService.addNewOption("1. Add a new SERVICE profile");
                    menuService.addNewOption("2. Search a SERVICE profile");
                    menuService.addNewOption("3. Update a SERVICE profile");
                    menuService.addNewOption("4. Remove a SERVICE profile");
                    menuService.addNewOption("5. Print SERVICE List profile ascending by ID");
                    menuService.addNewOption("6. Print SERVICE List profile ascending by Name");
                    menuService.addNewOption("7. Quit");
                    do {
                        menuService.printMenu();
                        choice = menuService.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.println("You are preparing to input a new SERVICE profile");
                                listService.addNewService();
                                break;
                            case 2:
                                System.out.println("You are required to input SERVICE ID to search profile");
                                listService.searchService();
                                break;
                            case 3:
                                System.out.println("You are required to input SERVICE ID to update profile");
                                listService.updateService();
                                break;
                            case 4:
                                System.out.println("Your are required to input SERVICE ID to remove profile");
                                idService = listService.intputServiceId();
                                if (listLog.idServiceDetection(idService) == 1) {
                                    System.out.println("This Service now has Pet using, can't remove");
                                    break;
                                }
                                listService.removeService(idService);
                                break;
                            case 5:
                                System.out.println("You are preparing to Print SERVICE List profile ascending by ID");
                                listService.printServiceListAscendingByID();
                                break;
                            case 6:
                                System.out.println("You are preparing to Print SERVICE List profile ascending by Name");
                                listService.printServiceListAscendingByName();
                                break;
                            case 7:
                                System.out.println("You choose out of SERVICE LIST");
                                break;
                        }
                    } while (choice != 7);
                    break;
                case 4:
                    Menu menuSet = new Menu("SET RELATION FUNCTIONS");
                    menuSet.addNewOption("1. SET RELATION PET-OWNER");
                    menuSet.addNewOption("2. SET RELATION PET-SERVICE");
                    menuSet.addNewOption("3. Quit");

                    do {
                        menuSet.printMenu();
                        choice = menuSet.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.println("You are prearing to Set a relation between PET-OWNER");

                                if (listOwner.isEmpty() == true) {
                                    System.out.println("Nothing in Owner list to set, please back later");
                                } else if (listPet.isEmpty() == true) {
                                    System.out.println("Nothing in Pet List to set, please back later");
                                } else {
                                    // nhập PET ID
                                    idPet = listPet.inputPetId();
                                    // NHẬp OWNER ID
                                    idOwner = listOwner.inputOwnerId();

                                    listPet.searchPetById(idPet).setOwner(listOwner.searchOwnerById(idOwner));

                                    System.out.println("Information of Pet after set Owner");
                                    listPet.searchPetById(idPet).showProfile();

                                    System.out.println("Success to set relationship between Pet - Owner");
                                }
                                break;
                            case 2:
                                System.out.println("You are prearing to Set a relation between PET-SERVICE");

                                if (listPet.isEmpty()) {
                                    System.out.println("Nothing in Pet List, please back later");
                                } else if (listService.isEmpty()) {
                                    System.out.println("Nothing in Service List, please back later");
                                } else {
                                    // nhập PET ID
                                    idPet = listPet.inputPetId();
                                    pet = listPet.searchPetById(idPet);

                                    if (pet.getOwnerId() == null) {
                                        System.out.println("This Pet still don't have Owner, can't record Using Service");
                                        break;
                                    }

                                    // NHẬP SERVICE
                                    idService = listService.intputServiceId();

                                    service = listService.searchServiceById(idService);

                                    listLog.add(pet, service);
                                    System.out.println("The record using is");
                                    new TimeSheet(pet, service).showProfile();

                                    System.out.println("Success to record the using Service of Pet");
                                }
                                break;
                            case 3:
                                System.out.println("You choose out of SET RELATION FUNTIONS");
                                break;

                        }
                    } while (choice != 3);
                    break;
                case 5:
                    Menu menuExtra = new Menu("EXTRA FUNCTIONS");
                    menuExtra.addNewOption("1. SHOW ALL RECORD USING PET-SERVICE");
                    menuExtra.addNewOption("2. Search Owner Information of Pet by PetID");
                    menuExtra.addNewOption("3. Show all Pet of Owner");
                    menuExtra.addNewOption("4. Caculate total money Owner have to pay for Pet");
                    menuExtra.addNewOption("5. Quit");
                    do {
                        menuExtra.printMenu();
                        choice = menuExtra.getChoice();
                        switch (choice) {
                            case 1:
                                System.out.println("You are preparing to print the record using Service of Pet");
                                listLog.showAllProfile();
                                break;
                            case 2:
                                if (listOwner.isEmpty() == true) {
                                    System.out.println("Nothing in Owner list to find, please back later");
                                    break;
                                } else if (listPet.isEmpty() == true) {
                                    System.out.println("Nothing in Pet List, please back later");
                                    break;
                                }

                                System.out.println("You are required to input the ID of Pet want to search Owner information");
                                idPet = listPet.inputPetId();
                                pet = listPet.searchPetById(idPet);
                                if (listOwner.searchOwnerById(pet.getOwnerId()) == null) {
                                    System.out.println("This Pet still don't have Owner, please back later");
                                    break;
                                }
                                System.out.println("Here is Owner Information of Pet");
                                listOwner.searchOwnerById(pet.getOwnerId()).showProfile();
                                break;

                            case 3:
                                if (listOwner.isEmpty() == true) {
                                    System.out.println("Nothing in Owner list, please back later");
                                    break;
                                } else if (listPet.isEmpty() == true) {
                                    System.out.println("Nothing in Pet List, please back later");
                                    break;
                                }
                                
                                System.out.println("You are required to input Owner ID to print all Pet infomation");
                                idOwner = listOwner.inputOwnerId();
                                System.out.println("Here is the Pet(s) Information of Owner have ID " + idOwner);
                                listPet.showPetOfOwnerID(idOwner);

                                break;
                            case 4:
                                if (listOwner.isEmpty() == true) {
                                    System.out.println("Nothing in Owner list, please back later");
                                    break;
                                } else if (listPet.isEmpty() == true) {
                                    System.out.println("Nothing in Pet List, please back later");
                                    break;
                                }
                                
                                System.out.println("You are required to input Owner ID to caculate total money have to pay");
                                idOwner = listOwner.inputOwnerId();
                                int total = 0;
                                List<Integer> list = listPet.searchPetHaveOwnerID(idOwner);
                                
                                for (int i = 0; i < list.size(); i++) {
                                    total += listLog.getTotalMoneyUsingServiceByPetID(list.get(i));
                                }
                                System.out.println("The total money Owner have to Pay is: " + total);

                                break;
                            case 5:
                                System.out.println("You choose out of EXTRA FUNCTIONS");
                                break;
                        }
                    } while (choice != 5);

                    break;
                case 6:
                    System.out.println("Good bye, see you again");
                    break;
            }

        } while (choiceAll != 6);

    }

}
