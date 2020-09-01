package com.example.pwpb_latihanintent;

import android.os.Parcel;
import android.os.Parcelable;

public class orank implements Parcelable {

    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    private String jenis_kelamin;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.jenis_kelamin);
    }

    public orank(String data) {
        setNama(data);
        setJenis_kelamin(data);
    }

    public orank() {
    }

    protected orank(Parcel in) {
        this.nama = in.readString();
        this.jenis_kelamin = in.readString();
    }

    public static final Parcelable.Creator<orank> CREATOR = new Parcelable.Creator<orank>() {
        @Override
        public orank createFromParcel(Parcel source) {
            return new orank(source);
        }

        @Override
        public orank[] newArray(int size) {
            return new orank[size];
        }
    };
}
