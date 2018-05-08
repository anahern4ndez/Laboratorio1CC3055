package com.plataformas.anahernandez.laboratorio1;

import android.os.Parcel;
import android.os.Parcelable;

/** Ana Lucia Hernandez 17138
 * 08/05/2017
 * Laboratorio 1: Plataformas Moviles y Juegos
 *
 */

public class Doctor implements Parcelable {
    private String nombre;
    private String especializacion;
    private String numColegiado;
    private double sueldo;

    public Doctor() {

    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre +
                ", Se especializo en: " + especializacion +
                ", Numero de Colegiado: " + numColegiado +
                ", Sueldo: Q" + sueldo;
    }

    public Doctor(String nombre, String especializacion, String numColegiado, double sueldo) {
        this.nombre = nombre;
        this.especializacion = especializacion;
        this.numColegiado = numColegiado;
        this.sueldo = sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public double getSueldo() {
        return sueldo;
    }

    protected Doctor(Parcel in) {
        nombre = in.readString();
        especializacion = in.readString();
        numColegiado = in.readString();
        sueldo = in.readDouble();
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(especializacion);
        dest.writeString(numColegiado);
        dest.writeDouble(sueldo);
    }
}
