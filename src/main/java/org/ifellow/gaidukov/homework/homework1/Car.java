package org.ifellow.gaidukov.homework.homework1;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Car
{
    private String carBrand;
    private String carModel;
    @Setter
    private String carColor;
    private boolean transmissionIsAutomatic;
    private int carMaxSpeed;
    private double carGasMileage;
    private int carReleaseYear;

    Car(String carBrand, String carModel, String carColor, boolean transmissionIsAutomatic,
        int carSpeed, double carGasMileage, int carReleaseYear)
    {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.transmissionIsAutomatic = transmissionIsAutomatic;
        this.carMaxSpeed = carSpeed;
        this.carGasMileage = carGasMileage;
        this.carReleaseYear = carReleaseYear;
    }

    public String GetInformationAboutTransmission()
    {
        String transmission;

        if(transmissionIsAutomatic)
            transmission = "automatic";
        else
            transmission = "manual";

        return transmission;
    }
}
