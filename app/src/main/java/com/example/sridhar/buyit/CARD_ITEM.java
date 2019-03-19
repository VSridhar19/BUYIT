package com.example.sridhar.buyit;

/**
 * Created by Sridhar on 20-04-2018.

*/
class CARD_ITEM {
    private String name1;
    private String price;
    private byte[] images1;

    CARD_ITEM( String name1, String price, byte[] images1) {

        this.name1 = name1;
        this.price = price;
        this.images1 = images1;
    }

    public CARD_ITEM() {

    }


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public byte[] getImages1() {
        return images1;
    }

    public void setImages1(byte[] images1) {
        this.images1 = images1;
    }
}


