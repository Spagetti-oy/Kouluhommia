package com.example.bottledispenser;

public class Bottle {

    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;
    //String name, double size, double price

    public Bottle(String nimi, double koko, double hinta){
        name = nimi;
        manufacturer = "Pepsi";
        total_energy = 0.3;
        size = koko;
        price = hinta;
    }

/*
	    public Bottle(String name, String manuf, float totE){

	    }
*/

    public String getName(){
        return name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getEnergy(){
        return total_energy;
    }

    public double getPrice(){
        return price;
    }

    public double getSize(){
        return size;
    }
}
