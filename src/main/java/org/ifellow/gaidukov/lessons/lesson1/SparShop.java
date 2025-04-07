package org.ifellow.gaidukov.lessons.lesson1;

public class SparShop
{
    private String shopName;
    private String fruit;

    public SparShop(String shopName, String fruit)
    {
        this.shopName = shopName;
        this.fruit = fruit;
    }

    public SparShop(String fruit)
    {
        this.fruit = fruit;
    }

    void PrintInformationAboutShop()
    {
        System.out.println(this.shopName + " " + this.fruit);
    }

    void ChangeInformationAboutShop(String shopName, String fruit)
    {
        if(shopName != null)
            this.shopName = shopName;

        if(fruit != null)
            this.fruit = fruit;
    }
}
