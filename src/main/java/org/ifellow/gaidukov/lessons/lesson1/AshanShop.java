package org.ifellow.gaidukov.lessons.lesson1;

public class AshanShop extends ModelShop
{
    private String vegetable;

    AshanShop(String ShopName, String Fruit, String vegetable)
    {
        super(ShopName, Fruit);
        this.vegetable = vegetable;
    }
}
