package org.ifellow.gaidukov.homework.homework1;


public class CarToyota extends Car
{
    private boolean parkingAssistantIsOn;

    CarToyota(String carBrand, String carModel, String carColor, boolean automaticTransmission,
              int carSpeed, double carGasMileage, int carReleaseYear)
    {
        super(carBrand = "Toyota", carModel, carColor, automaticTransmission,
                carSpeed, carGasMileage, carReleaseYear);

        this.parkingAssistantIsOn = false;
    }

    public boolean CheckParkingAssistantIsOn()
    {
        return this.parkingAssistantIsOn;
    }

    public void PrintParkingAssistantStatus()
    {
        if(parkingAssistantIsOn)
            System.out.println("Парковочный ассистент активен.");
        else
            System.out.println("Парковочный ассистент неактивен.");
    }

    public void TurnOnParkingAssistant()
    {
        if(parkingAssistantIsOn)
            System.out.println("Парковочный ассистент уже активен.");
        else
        {
            this.parkingAssistantIsOn = true;
            System.out.println("Парковочный ассистент активирован.");
        }
    }

    public void TurnOffParkingAssistant()
    {
        if(!parkingAssistantIsOn)
            System.out.println("Парковочный ассистент уже неактивен.");
        else
        {
            this.parkingAssistantIsOn = false;
            System.out.println("Парковочный ассистент деактивирован.");
        }
    }
}
