package com.example.assignment_3.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelPojo { /* implements Parcelable */

    private String image;
    private String largeimage;
    private String title;

    @SerializedName("dj")
    @Expose
    private String DJ;

    @SerializedName("djmail")
    @Expose
    private String DJEmail;

    @SerializedName("listeners")
    @Expose
    private String numberOfListeners;
    private String genre;
    private String description;
    //private String[] playlists;

    public ChannelPojo(){}

    public ChannelPojo(String largeimage, String title, String DJ, String DJEmail, String numberOfListeners, String genre) {
        this.largeimage = largeimage;
        this.title = title;
        this.DJ = DJ;
        this.DJEmail = DJEmail;
        this.numberOfListeners = numberOfListeners;
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLargeimage() {
        return largeimage;
    }

    public void setLargeimage(String largeimage) {
        this.largeimage = largeimage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDJ() {
        return DJ;
    }

    public void setDJ(String DJ) {
        this.DJ = DJ;
    }

    public String getDJEmail() {
        return DJEmail;
    }

    public void setDJEmail(String DJEmail) {
        this.DJEmail = DJEmail;
    }

    public String getNumberOfListeners() {
        return numberOfListeners;
    }

    public void setNumberOfListeners(String numberOfListeners) {
        this.numberOfListeners = numberOfListeners;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(String[] playlists) {
        this.playlists = playlists;
    }*/

    @Override
    public String toString() {
        return "ChannelPojo{" +
                "largeimage='" + largeimage + '\'' +
                ", title='" + title + '\'' +
                ", DJ='" + DJ + '\'' +
                ", DJEmail='" + DJEmail + '\'' +
                ", numberOfListeners='" + numberOfListeners + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    /*@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.title);
        dest.writeString(this.DJ);
        dest.writeString(this.DJEmail);
        dest.writeString(this.numberOfListeners);
        dest.writeString(this.genre);
        dest.writeString(this.largeimage);
    } */
}
