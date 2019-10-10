package br.com.crosoften.parkokcliente.commom;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {

    private long id;
    private String nameUser;
    private String cpf;
    private String email;

    public Users(long id, String nameUser) {
        this.id = id;
        this.nameUser = nameUser;
    }

    public Users(long id, String nameUser, String cpf, String email) {
        this.id = id;
        this.nameUser = nameUser;
        this.cpf = cpf;
        this.email = email;
    }

    protected Users(Parcel in) {
        id = in.readLong();
        nameUser = in.readString();
        cpf = in.readString();
        email = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nameUser);
        dest.writeString(cpf);
        dest.writeString(email);
    }
}
