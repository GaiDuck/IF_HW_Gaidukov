package org.ifellow.gaidukov.homework.homework1;

import java.util.List;
import java.util.Objects;

public class CarProcessing
{
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
}
