package br.com.crosoften.parkokcliente.commom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class QrCode implements Parcelable {
    private long id;
    private String nome;
    private Date input;
    private Date exit;
    private Date balanceAvailable;
    private String boad;


    public QrCode(long id, String nome, Date input, Date exit, Date balanceAvailable, String boad) {
        this.id = id;
        this.nome = nome;
        this.input = input;
        this.input = exit;
        this.balanceAvailable = balanceAvailable;
        this.boad = boad;
    }

    protected QrCode(Parcel in) {
        id = in.readLong();
        nome = in.readString();
        boad = in.readString();
        input = new Date(in.readLong());
        exit = new Date(in.readLong());
        balanceAvailable = new Date(in.readLong());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nome);
        dest.writeString(boad);
        dest.writeLong(input.getTime());
        dest.writeLong(exit.getTime());
        dest.writeLong(balanceAvailable.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QrCode> CREATOR = new Creator<QrCode>() {
        @Override
        public QrCode createFromParcel(Parcel in) {
            return new QrCode(in);
        }

        @Override
        public QrCode[] newArray(int size) {
            return new QrCode[size];
        }
    };

    public Date getExit() {
        return exit;
    }

    public void setExit(Date exit) {
        this.exit = exit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInput() {
        return input;
    }

    public void setInput(Date input) {
        this.input = input;
    }

    public Date getBalanceAvailable() {
        return balanceAvailable;
    }

    public void setBalanceAvailable(Date balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public String getBoad() {
        return boad;
    }

    public void setBoad(String boad) {
        this.boad = boad;
    }
}
