package org.ifellow.gaidukov.homework.homework1;

public class CarMercedes extends Car {
    CarMercedes(String carBrand, String carModel, String carColor, boolean automaticTransmission, int carSpeed, double carGasMileage, int carReleaseYear) {
        super("Mercedes", carModel, carColor, automaticTransmission, carSpeed, carGasMileage, carReleaseYear);
    }

    @Override
    public void parkCar() {
        System.out.println("Паркуем ваш " + getCarBrand() + " " + getCarModel() + ":");
        System.out.println("Ваша красная ковровая дорожка уже развернута!");
    }
}