package org.foree.duker.rssinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by foree on 16-7-23.
 */
public class RssProfile {
    private String locale;
    private String gender;
    private String givenName;
    private String familyName;
    private String fullName;
    @SerializedName("id")
    private String userId;
    private String picture;
    private String email;

    public RssProfile(String locale, String gender, String givenName, String familyName, String fullName, String userId, String picture, String email) {
        this.locale = locale;
        this.gender = gender;
        this.givenName = givenName;
        this.familyName = familyName;
        this.fullName = fullName;
        this.userId = userId;
        this.picture = picture;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setUserId(String UserId) {
        this.userId = UserId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }
}
