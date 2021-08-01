/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary.dto;

import java.util.Date;

/**
 *
 * @author DivyaDeverapally
 */
public class DVD {

    private String title;
    private Date release_date;
    private int mpaa_rating;
    private String director_name;
    private String studio;
    private int user_rating;
    private String note;
    private String dvdId;

    public DVD() {

    }

    public DVD(String dvdId) {
        this.dvdId = dvdId;

    }

    public DVD(String title, Date release_date, int mpaa_rating, String director_name, String studio, int rating) {
        super();
        this.title = title;
        this.release_date = release_date;
        this.mpaa_rating = mpaa_rating;
        this.director_name = director_name;
        this.studio = studio;
        this.user_rating = rating;

    }

    public DVD(String title, Date release_date, int mpaa_rating, String director_name, String studio, String note) {
        super();
        this.title = title;
        this.release_date = release_date;
        this.mpaa_rating = mpaa_rating;
        this.director_name = director_name;
        this.studio = studio;
        this.note = note;
    }

    public String getDvdId() {
        return dvdId;
    }

    public void setDvdId(String dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(int mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(int user_rating) {
        this.user_rating = user_rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return " ID=" + dvdId +", title=" + title + ", release_Date=" + release_date + ", mpaa_rating=" + mpaa_rating
                + ", Director_name=" + director_name + ", studio=" + studio + ", rating=" + user_rating + ", note="
                + note;
    }

}
