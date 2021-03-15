package com.example.bottledispenser;

import java.text.DecimalFormat;

import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private double money;
    private ArrayList<Bottle> valikoima = null;

    public BottleDispenser() {
        bottles = 5;
        money = 0.000;

        this.valikoima = new ArrayList<Bottle>();

        valikoima.add(new Bottle("Pepsi Max", 0.5, 1.8));
        valikoima.add(new Bottle("Pepsi Max", 1.5, 2.2));
        valikoima.add(new Bottle("Coca-Cola Zero", 0.5, 2.0));
        valikoima.add(new Bottle("Coca-Cola Zero", 1.5, 2.5));
        valikoima.add(new Bottle("Fanta Zero", 0.5, 1.95));

    }

    public void printSelection() {
        int luku = 1;
        for (Bottle pullo : valikoima) {

            System.out.println(luku+". Name: " + pullo.getName());
            System.out.print("\tSize: " + pullo.getSize());
            System.out.print("\tPrice: " + pullo.getPrice());
            System.out.print("\n");
            luku += 1;
        }
    }

    public String addMoney(int addedMoney) {
        money += addedMoney;
        System.out.println("Klink! Added " + addedMoney + " €");

        String returnString;
        returnString = "Klink! Added " + addedMoney + " €";
        return returnString;
    }

    public String buyBottle(int choice) {

        choice -= 1;
        String returnString;
        System.out.println("number of bottles remaining: " + bottles);

        if (bottles == 0) {
            System.out.println("No bottles remaining!");
            returnString = "No bottles remaining!";
            return returnString;
        }

        else if (money < valikoima.get(choice).getPrice()) {
            System.out.println("Add money first!");
            returnString = "Add money first!";
            return returnString;
        }

        else {
            money -= valikoima.get(choice).getPrice();
            bottles -= 1;

            System.out.println("KACHUNK! " + valikoima.get(choice).getName() + " came out of the dispenser!");

            returnString = "KACHUNK! " + valikoima.get(choice).getName() + " came out of the dispenser";
            valikoima.remove(choice);

            return returnString;
        }
    }

    public String returnMoney() {
        String returnString;
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Klink klink. Money came out! You got " + df.format(money) + "€ back");
        returnString = "Klink klink. Money came out! You got " + df.format(money) + "€ back";
        money = 0;
        return returnString;
    }

}
