package com.example.matthieucolliaux.tp1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by matthieucolliaux on 18/10/2015.
 */
public class User implements Parcelable{
    private String nom;
    private String prenom;
    private String date;
    private String ville;

    public User(String name, String firstname, String date, String city){
        this.nom=name;
        this.prenom=firstname;
        this.date=date;
        this.ville=city;
    }
    //décrit le contenu du Parcel et
    // plus précisément le nb d'objet spéciaux contenus dans le Parcel
    public int describeContents(){
        return 0;
    }
    //écrit l'objet dans un parcel
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(date);
        dest.writeString(ville);
    }
    //getter
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getDate(){
        return date;
    }
    public String getVille(){
        return ville;
    }
    /* création d'un objet creator de la classe Parcelable avec un constructeur
    * prenant comme argument un Parcel pour l'User(permet de reconstruire l'objet à partir d'un Parcel)*/
    public static final Parcelable.Creator<User> CREATOR=new Parcelable.Creator<User>(){
        public User createFromParcel(Parcel source){
            return new User(source);
        }
        public User[] newArray(int size){
            return new User[size];
        }
    };

    public User(Parcel p){
        this.nom=p.readString();
        this.prenom=p.readString();
        this.date=p.readString();
        this.ville=p.readString();
    }
}

