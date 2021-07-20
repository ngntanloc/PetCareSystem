/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Nguyen Tan Loc
 */
public class Menu {
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }
    
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is nothing in menu");
            return;
        }
        System.out.println("\n-------------------------------");
        System.out.println("Welcome to " + menuTitle);
        for (String x : optionList) {
            System.out.println(x);
        }
            
    }
    
    public int getChoice() {
        int maxOption = optionList.size();
        String inputMsg = "Choose [1..." + maxOption + "]: ";
        String outputMsg = "Your are required to choose the option 1.." + maxOption;
        return MyToys.getAnInteger(inputMsg, outputMsg, 1, maxOption);
    }
}
