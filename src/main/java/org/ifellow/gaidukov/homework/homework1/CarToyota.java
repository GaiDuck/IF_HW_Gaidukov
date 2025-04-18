package org.ifellow.gaidukov.homework.homework1;

public class CarToyota extends Car {
    CarToyota(String carBrand, String carModel, String carColor, boolean automaticTransmission, int carSpeed, double carGasMileage, int carReleaseYear) {
        super("Toyota", carModel, carColor, automaticTransmission, carSpeed, carGasMileage, carReleaseYear);
    }

    @Override
    public void parkCar() {
        System.out.println("Паркуем ваш " + getCarBrand() + " " + getCarModel() + ":");
        System.out.println("Анализирую ситуацию... Причина остановки: ваш автомобиль в реке.");
    }
}