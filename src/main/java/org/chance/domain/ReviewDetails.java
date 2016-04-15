package org.chance.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wqg on 2016/3/14.
 */
public class ReviewDetails implements Serializable{

    private static final long serialVersionUID = 2441257600742675572L;

    private Rating rating;

    private Date checkInDate;

    private TripType tripType;

    private String title;

    private String details;

    public ReviewDetails() {
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
