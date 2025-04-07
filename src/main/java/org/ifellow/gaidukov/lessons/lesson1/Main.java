package org.ifellow.gaidukov.lessons.lesson1;

public class Main
{
    public static void main(String[] args)
    {
        //PrintHelloWorld();

    /*
        System.out.println(GetShopName() + " " + GetFruitName());
        ChangeFruitName("lemon");
        System.out.println(GetShopName() + " " + GetFruitName());
    */

    /*
        firstSpar.PrintInformationAboutShop();
        secondSpar.PrintInformationAboutShop();

        firstSpar.ChangeInformationAboutShop("Spaaar", "lemon");
        secondSpar.ChangeInformationAboutShop(null, "pineapple");

        firstSpar.PrintInformationAboutShop();
        secondSpar.PrintInformationAboutShop();
    */
    }

    static Shop SHOP = new Shop();
    static SparShop FIRST_SPAR = new SparShop("apple");
    static SparShop SECOND_SPAR = new SparShop("Spar", "apple");
    static AshanShop ASHAN_SHOP = new AshanShop("Ashan", "apple", "tomato");

    //Не стал переименовывать методы под STATIC_STYLE, потому что,
    // их вообще не должно быть в Main, оставил их, потому
    // что это тренировочные задачки и эксперименты.

    static void PrintHelloWorld()
    {
        System.out.println("Hello, world!");
    }

    static String GetShopName()
    {
        return SHOP.getShopName();
    }

    static String GetFruitName()
    {
        return SHOP.getFruit();
    }

    static void ChangeFruitName(String newFruitName)
    {
        SHOP.setFruit(newFruitName);
    }

}
