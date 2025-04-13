package org.ifellow.gaidukov.homework.homework1;

import lombok.Getter;

import java.util.List;

public class Main
{
    static CarParking parking = new CarParking();
    static CarProcessing processing = new CarProcessing();

    public static void main(String[] args)
    {
        parking.ParkTheCar(ToyotaCamry);
        System.out.println();
        processing.RecolorCars(cars,"Red", "Green");
        System.out.println();
        processing.GetInformationAboutCarsReliaseYear(cars, 2016);
        System.out.println();

    }

    private static CarToyota ToyotaCamry = new CarToyota("secret","Camry", "Silver", true,
            210, 8.5, 2007);
    private static final CarToyota ToyotaRav4Prime = new CarToyota("secret","RAV4 Prime", "White", false,
            195, 2.6, 2015);

    private static final CarMercedes MercedesC300 = new CarMercedes("secret","C300 4MATIC", "Grey",
            true, 245, 6.8, 2018);
    private static final CarMercedes MercedesGle450 = new CarMercedes("secret","GLE 450 4MATIC", "Yellow",
            false, 250, 8.7, 2005);

    private static final CarHyundai HyundaiTucsonNLine = new CarHyundai("secret","Tucson N Line", "Red",
            true, 215, 7.1, 2024);
    private static final CarHyundai HyundaiSonataNLine = new CarHyundai("secret","Sonata N Line", "Black",
            false, 245, 7.9, 2009);

    private static final CarFord FordFocusST = new CarFord("secret","Focus ST", "Red", false,
            250, 7.2, 2011);
    private static final CarFord FordMustangDarkHorse = new CarFord("secret","Mustang Dark Horse", "Blue",
            true, 265, 12.1, 1999);

    private static final CarBMW BMW550e = new CarBMW("secret","550e xDrive", "Black", true,
            250, 2.1, 2020);
    private static final CarBMW BMWX5 = new CarBMW("secret","X5 xDrive50e", "Blue", true,
            240, 2.3, 2003);

    @Getter
    private static final List<Car> cars = List.of(ToyotaCamry, ToyotaRav4Prime,
            MercedesC300, MercedesGle450,
            HyundaiTucsonNLine, HyundaiSonataNLine,
            FordFocusST, FordMustangDarkHorse,
            BMW550e, BMWX5);
}
