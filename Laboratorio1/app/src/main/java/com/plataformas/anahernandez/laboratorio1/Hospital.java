package com.plataformas.anahernandez.laboratorio1;

import android.os.Parcel;
import android.os.Parcelable;

/** Ana Lucia Hernandez 17138
 * 08/05/2017
 * Laboratorio 1: Plataformas Moviles y Juegos
 *
 */

public class Hospital implements Parcelable {

    private String nombreHospital;
    private Doctor doc1;
    private Doctor doc2;
    private Enfermera enf1;
    private Enfermera enf2;

    public Hospital() {
    }

    public Hospital(String nombreHospital, Doctor doc1, Doctor doc2, Enfermera enf1, Enfermera enf2) {
        this.nombreHospital = nombreHospital;
        this.doc1 = doc1;
        this.doc2 = doc2;
        this.enf1 = enf1;
        this.enf2 = enf2;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public Doctor getDoc1() {
        return doc1;
    }

    public void setDoc1(Doctor doc1) {
        this.doc1 = doc1;
    }

    public Doctor getDoc2() {
        return doc2;
    }

    public void setDoc2(Doctor doc2) {
        this.doc2 = doc2;
    }

    public Enfermera getEnf1() {
        return enf1;
    }

    public void setEnf1(Enfermera enf1) {
        this.enf1 = enf1;
    }

    public Enfermera getEnf2() {
        return enf2;
    }

    public void setEnf2(Enfermera enf2) {
        this.enf2 = enf2;
    }

    protected Hospital(Parcel in) {
        doc2 = in.readParcelable(Doctor.class.getClassLoader());
        doc1 = in.readParcelable(Doctor.class.getClassLoader());
        enf1 = in.readParcelable(Enfermera.class.getClassLoader());
        enf2 = in.readParcelable(Enfermera.class.getClassLoader());
        nombreHospital = in.readString();

    }

    public static final Creator<Hospital> CREATOR = new Creator<Hospital>() {
        @Override
        public Hospital createFromParcel(Parcel in) {
            return new Hospital(in);
        }

        @Override
        public Hospital[] newArray(int size) {
            return new Hospital[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(doc2, flags);
        dest.writeParcelable(doc1, flags);
        dest.writeParcelable(enf1, flags);
        dest.writeParcelable(enf2, flags);
        dest.writeString(nombreHospital);
    }

    @Override
    public String toString() {


        return "\nNombre del Hospital: " + nombreHospital + "\n\nDoctor 1: "+ doc1.toString() + "\n"+ "\nDoctor 2: "+ doc2.toString() + "\n"+ "\nEnfermera 1: "+ enf1.toString() + "\n" + "\nEnfermera 2: "+ enf2.toString();
    }
}
