package org.ifellow.gaidukov.homework.homework1;

public class CarParking
{
    public void ParkTheCar(CarToyota toyota)
    {
        System.out.println("Перед тем как начать парковку, проверьте режим парковочного ассистента.\n" +
                           "Если парковочный ассистент выключен - включите его.");

        toyota.PrintParkingAssistantStatus();

        if(!toyota.CheckParkingAssistantIsOn())
            toyota.TurnOnParkingAssistant();

        toyota.PrintParkingAssistantStatus();

        System.out.println("Теперь аккуратно припаркуйте свой автомобиль.\n" +
                           "Затем выключите парковочный ассистент.");

        if(toyota.CheckParkingAssistantIsOn())
            toyota.TurnOffParkingAssistant();

        toyota.PrintParkingAssistantStatus();
    }
}
