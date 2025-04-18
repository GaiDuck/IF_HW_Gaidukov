package org.ifellow.gaidukov.homework.homework1;

public class CarFord extends Car {
    CarFord(String carBrand, String carModel, String carColor, boolean automaticTransmission, int carSpeed, double carGasMileage, int carReleaseYear) {
        super("Ford", carModel, carColor, automaticTransmission, carSpeed, carGasMileage, carReleaseYear);
    }

    @Override
    public void parkCar() {
        System.out.println("Паркуем ваш " + getCarBrand() + " " + getCarModel() + ":");
        System.out.println("Парковочный лидар активирован.");
    }
}