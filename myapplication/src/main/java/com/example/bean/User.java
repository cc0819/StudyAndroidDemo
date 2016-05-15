package com.example.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cc on 16/5/14.
 */
public class User implements Parcelable {


    public int userId;
    public String userName;
    public boolean isMale;
//    public Book book;


    public User(int userId, boolean isMale, String userName) {
        this.userId = userId;
        this.isMale = isMale;
        this.userName = userName;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(userId);
        out.writeString(userName);
        out.writeInt(isMale?1:0);
//        out.writeParcelable(book,0);

    }



    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readInt() == 1;
//        book = in.readParcelable(Thread.currentThread().getContextClassLoader()-Loader());

    }




}
