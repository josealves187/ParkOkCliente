package br.com.crosoften.parkokcliente.commom;

import java.util.Date;

public class MyCards {

    //private String idImagen;
    private long number;
    private String name;
    private Date ShelfLife;
    private int cvc;
    private int idImage;

    public MyCards(long number, String name, Date shelfLife, int cvc,int idImage) {
        this.number = number;
        this.name = name;
        ShelfLife = shelfLife;
        this.cvc = cvc;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShelfLife() {
        return ShelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        ShelfLife = shelfLife;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}
