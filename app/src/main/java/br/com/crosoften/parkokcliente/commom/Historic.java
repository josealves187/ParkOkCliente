package br.com.crosoften.parkokcliente.commom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Historic implements Parcelable {

    private long id;
    private Date serviceDate;
    private int typeService;
    private Date lenghtOfStay;
    private double amount;
    private double amountPaid;
    private int formOfPayment;
    private double discountAmount;


    public Historic(long id, Date serviceDate, Date lenghtOfStay, double amount,
                    double amountPaid, int formOfPayment, double discountAmount, int typeService) {
        this.id = id;
        this.serviceDate = serviceDate;
        this.typeService = typeService;
        this.lenghtOfStay = lenghtOfStay;
        this.amount = amount;
        this.amountPaid = amountPaid;
        this.formOfPayment = formOfPayment;
        this.discountAmount = discountAmount;
    }

    protected Historic(Parcel in) {
        id = in.readLong();
        typeService = in.readInt();
        amount = in.readDouble();
        amountPaid = in.readDouble();
        formOfPayment = in.readInt();
        discountAmount = in.readDouble();
        lenghtOfStay = new Date(in.readLong());

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(typeService);
        dest.writeDouble(amount);
        dest.writeDouble(amountPaid);
        dest.writeInt(formOfPayment);
        dest.writeDouble(discountAmount);
        dest.writeLong(lenghtOfStay.getTime());

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Historic> CREATOR = new Creator<Historic>() {
        @Override
        public Historic createFromParcel(Parcel in) {
            return new Historic(in);
        }

        @Override
        public Historic[] newArray(int size) {
            return new Historic[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }


    public int getTypeService() {
        return typeService;
    }

    public Date getLenghtOfStay() {
        return lenghtOfStay;
    }



    public double getAmount() {
        return amount;
    }



    public double getAmountPaid() {
        return amountPaid;
    }


    public int getFormOfPayment() {
        return formOfPayment;
    }



}