package org.ifellow.gaidukov.homework.homework1;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CarProcessing {
    Scanner in = new Scanner(System.in);

    public void recolorCars(List<Car> cars, String oldColor, String newColor) {
        for (Car car : cars) {
            if (Objects.equals(car.getCarColor(), oldColor)) {
                System.out.println("Ваша " + car.getCarBrand() + " " + car.getCarModel() +
                        " цвета " + oldColor + ", это уже не модно!\n" +
                        "Мы перекрасим ее в " + newColor + "!");
            }
        }
    }

    public void getInformationAboutCarsReleaseYear(List<Car> cars, int minimumReleaseYear) {
        for (Car car : cars) {
            if (car.getCarReleaseYear() >= minimumReleaseYear) {
                System.out.println("Ваш " + car.getCarBrand() + " " + car.getCarModel() +
                        " выпущен в " + car.getCarReleaseYear() + " году.");
            } else {
                System.out.println("Ваш " + car.getCarBrand() + " " + car.getCarModel() +
                        " устарел.");
            }
        }
    }

    public void getInformationAboutCar(List<Car> cars, int carNumber) {
        if (carNumber <= cars.size()) {
            Car car = cars.get(carNumber - 1);
            System.out.println("Краткая сводка по вашему автомобилю:\n" +
                    "Название: " + car.getCarBrand() + " " + car.getCarModel() + "\n" +
                    "Цвет: " + car.getCarColor() + "\n" +
                    "Коробка передач: " + car.getInformationAboutTransmission() + "\n" +
                    "Максимальная скорость: " + car.getCarMaxSpeed() + "\n" +
                    "Расход топлива: " + car.getCarGasMileage() + " л/км\n" +
                    "Год выпуска: " + car.getCarReleaseYear() + " год \n");
        } else {
            System.out.println("У нас нет информации о таком автомобиле;");
        }
    }

    public void printNumbersOfCars(List<Car> cars) {
        System.out.println("Введите номер интересующего вас автомобиля:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(i + 1 + ". " + cars.get(i).getCarBrand() + " " + cars.get(i).getCarModel() + ";");
        }
    }

    public int getNumberOfCar(List<Car> cars) {
        boolean correctInput;
        int carNumber = 1;

        do {
            correctInput = true;
            try {
                carNumber = Integer.parseInt(in.next());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный номер автомобиля. Попробуйте ещё раз.");
                correctInput = false;
                carNumber++;
            }
        }
        while (!correctInput && carNumber <= cars.size());

        return carNumber;
    }

    public void parkCarsByCarBrand(List<Car> cars) {
        for (int i = 0; i < cars.size(); i = i + 2) {
            cars.get(i).parkCar();
        }
    }
}