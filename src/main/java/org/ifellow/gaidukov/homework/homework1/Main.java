package org.ifellow.gaidukov.homework.homework1;

import lombok.Getter;

import java.util.List;

public class Main
{
    static CarParking parking = new CarParking();
    static CarProcessing processing = new CarProcessing();

    public static void main(String[] args)
    {
        //It's hotfix origin.
        parking.ParkTheCar(ToyotaCamry);
        System.out.println();
        processing.RecolorCars(cars,"Red", "Green");
        System.out.println();
        processing.GetInformationAboutCarsReliaseYear(cars, 2016);
        System.out.println();

    }
}
