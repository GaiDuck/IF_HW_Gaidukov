package org.ifellow.gaidukov.homework.homework1;

public class CarBMW extends Car {
    CarBMW(String carBrand, String carModel, String carColor, boolean automaticTransmission, int carSpeed, double carGasMileage, int carReleaseYear) {
        super("BMW", carModel, carColor, automaticTransmission, carSpeed, carGasMileage, carReleaseYear);
    }

    @Override
    public void parkCar() {
        System.out.println("Паркуем ваш " + getCarBrand() + " " + getCarModel() + ":");
        System.out.println("Вы припарковались. \n");
    }
}