package com.example.vinod.recyclerviewdemoone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vinod on 10/12/17.
 */

public class Model implements Parcelable {
    public String firstName;
    public String lastName;
    public int images;

    protected Model(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        images = in.readInt();
    }

    public Model() {
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeInt(images);
    }

    @Override
    public String toString() {
        return "Model{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", images=" + images +
                '}';
    }
}
