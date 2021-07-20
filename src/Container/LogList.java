/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Container;

import DTO.Pet;
import DTO.Service;
import java.util.List;
import DTO.TimeSheet;
import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Nguyen Tan Loc
 */
public class LogList {

    List<TimeSheet> listLog;

    public LogList() {
        listLog = new ArrayList();
    }

    public void add(Pet pet, Service service) {
        listLog.add(new TimeSheet(pet, service));
    }

    public void showAllProfile() {
        if (listLog.isEmpty()) {
            System.out.println("Don't have anything to show, back later");
            return;
        }
        for (TimeSheet timeSheet : listLog) {
            timeSheet.showProfile();
        }
    }

    public int inputIDPet() {
        Pet pet;
        int idPet;
        do {
            idPet = MyToys.getAnInteger("Input Pet ID want to count total price", "Pet ID must be a positive integer", 1);
            pet = searchPetByID(idPet);
            if (pet == null) {
                System.out.println("This Pet is not existed, please choose again");
            }
        } while (pet == null);
        return idPet;
    }


//    public void caculateSumPriceForOwner(int idOwner) {
//        int totalPriceForOwner = 0;
//        
//        
//        
//    }
    public Pet searchPetByID(int idPet) {
        if (listLog.isEmpty()) {
            return null;
        }
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getPetID().equalsIgnoreCase(String.valueOf(idPet))) {
                return listLog.get(i).getPet();
            }
        }
        return null;
    }

    public int getTotalMoneyUsingServiceByPetID(int idPet) {
        int total = 0;
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getPetID() != null && listLog.get(i).getPetID().equalsIgnoreCase(String.valueOf(idPet))) {
                if (listLog.get(i).getServiceID() != null) {
                    total += listLog.get(i).getServicePrice();
                }
            }
        }
        return total;
    }

    // id Dectection
    // nếu trùng thì return 1, không trùng thì return 0
    public int idPetDetection(int idPet) {
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getPetID() != null && listLog.get(i).getPetID().equalsIgnoreCase(String.valueOf(idPet))) {
                return 1;
            }
        }
        return 0;
    }

    public int idServiceDetection(int idService) {
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getServiceID() != null && listLog.get(i).getServiceID().equalsIgnoreCase(String.valueOf(idService))) {
                return 1;
            }
        }
        return 0;
    }
    
    

    // update status
    public void updatePetIDStatus(int id) {
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getPetID() != null && listLog.get(i).getPetID().equalsIgnoreCase(String.valueOf(id))) {
                listLog.get(i).setPet(null);
            }
        }
    }

    public void updateServiceIDStatus(int id) {
        for (int i = 0; i < listLog.size(); i++) {
            if (listLog.get(i).getServiceID() != null && listLog.get(i).getServiceID().equalsIgnoreCase(String.valueOf(id))) {
                listLog.get(i).setService(null);
            }
        }
    }

}
