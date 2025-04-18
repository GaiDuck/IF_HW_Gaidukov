package org.ifellow.gaidukov.homework.homework1;

import java.util.List;

public class Main {
    static CarProcessing processing = new CarProcessing();

    public static void main(String[] args) {
        //It's hotfix origin.

        CarToyota toyotaCamry = new CarToyota("secret", "Camry", "Silver", true, 210, 8.5, 2007);
        CarToyota toyotaRav4Prime = new CarToyota("secret", "RAV4 Prime", "White", false, 195, 2.6, 2015);
        CarMercedes mercedesC300 = new CarMercedes("secret", "C300 4MATIC", "Grey", true, 245, 6.8, 2018);
        CarMercedes mercedesGle450 = new CarMercedes("secret", "GLE 450 4MATIC", "Yellow", false, 250, 8.7, 2005);
        CarHyundai hyundaiTucsonNLine = new CarHyundai("secret", "Tucson N Line", "Red", true, 215, 7.1, 2024);
        CarHyundai hyundaiSonataNLine = new CarHyundai("secret", "Sonata N Line", "Black", false, 245, 7.9, 2009);
        CarFord fordFocusST = new CarFord("secret", "Focus ST", "Red", false, 250, 7.2, 2011);
        CarFord fordMustangDarkHorse = new CarFord("secret", "Mustang Dark Horse", "Blue", true, 265, 12.1, 1999);
        CarBMW bmw550E = new CarBMW("secret", "550e xDrive", "Black", true, 250, 2.1, 2020);
        CarBMW bmwX5 = new CarBMW("secret", "X5 xDrive50e", "Blue", true, 240, 2.3, 2003);

        List<Car> cars = List.of(toyotaCamry, toyotaRav4Prime, mercedesC300, mercedesGle450, hyundaiTucsonNLine, hyundaiSonataNLine, fordFocusST, fordMustangDarkHorse, bmw550E, bmwX5);

        System.out.println();
        processing.recolorCars(cars, "Red", "Green");
        System.out.println();

        processing.getInformationAboutCarsReleaseYear(cars, 2016);
        System.out.println();

        processing.printNumbersOfCars(cars);
        processing.getInformationAboutCar(cars, processing.getNumberOfCar(cars));

        System.out.println();
        processing.parkCars(cars);
    }
}