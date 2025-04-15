package org.ifellow.gaidukov.homework.homework1;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CarProcessing
{
    Scanner in = new Scanner(System.in);

    public void RecolorCars(List<Car> cars, String oldColor, String newColor)
    {
        for(Car car : cars)
        {
            if(Objects.equals(car.getCarColor(), oldColor))
            {
                System.out.println("Ваша " + car.getCarBrand() + " " + car.getCarModel() +
                                   " цвета " + oldColor + ", это уже не модно!\n" +
                                   "Мы перекрасим ее в " + newColor + "!");
            }
        }
    }

    public void GetInformationAboutCarsReliaseYear(List<Car> cars, int minimumReliaseYear)
    {
        for(Car car : cars)
        {
            if(car.getCarReleaseYear() >= minimumReliaseYear)
            {
                System.out.println("Ваш " + car.getCarBrand() + " " + car.getCarModel() +
                                   " выпущен в " + car.getCarReleaseYear() + " году.");
            }
            else
            {
                System.out.println("Ваш " + car.getCarBrand() + " " + car.getCarModel() +
                                   " устарел.");
            }
        }
    }

    public void GetInformationAboutCar(List<Car> cars, int carNumber)
    {
        if (carNumber <= cars.size())
        {
            Car car = cars.get(carNumber-1);
            System.out.println("Краткая сводка по вашему автомобилю:\n" +
                    "Название: " + car.getCarBrand() + " " + car.getCarModel() + "\n" +
                    "Цвет: " + car.getCarColor() + "\n" +
                    "Коробка передач: " + car.GetInformationAboutTransmission() + "\n" +
                    "Максимальная скорость: " + car.getCarMaxSpeed() + "\n" +
                    "Расход топлива: " + car.getCarGasMileage() + " л/км\n" +
                    "Год выпуска: " + car.getCarReleaseYear() + " год \n");
        }
        else
        {
            System.out.println("У нас нет информации о таком автомобиле;");
        }
    }

    public void PrintNumbersOfCars(List<Car> cars)
    {
        System.out.println("Введите номер интересующего вас автомобиля:");
        for(int i = 0; i < cars.size(); i++)
        {
            System.out.println(i+1 + ". " + cars.get(i).getCarBrand() + " " + cars.get(i).getCarModel() + ";");
        }
    }

    public int GetNumberOfCar(List<Car> cars)
    {
        boolean correctInput;
        int carNumber = 1;

        do
        {
            correctInput = true;
            try
            {
                carNumber = Integer.parseInt(in.next());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Некорректный номер автомобиля. Попробуйте ещё раз.");
                correctInput = false;
                carNumber++;
            }
        }
        while(!correctInput && carNumber <= cars.size());

        return carNumber;
    }
}
