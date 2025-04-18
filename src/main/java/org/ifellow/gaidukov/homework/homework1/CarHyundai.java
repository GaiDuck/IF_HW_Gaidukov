package org.ifellow.gaidukov.homework.homework1;

public class CarHyundai extends Car {
    CarHyundai(String carBrand, String carModel, String carColor, boolean automaticTransmission, int carSpeed, double carGasMileage, int carReleaseYear) {
        super("Hyundai", carModel, carColor, automaticTransmission, carSpeed, carGasMileage, carReleaseYear);
    }

    @Override
    public void parkCar() {
        System.out.println("Паркуем ваш " + getCarBrand() + " " + getCarModel() + ":");
        System.out.println("Вы можете убрать руки от руля, парковочный ассистент сделает все самостоятельно.");
    }
}