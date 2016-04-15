package org.chance.domain;

/**
 * Created by wqg on 2016/3/14.
 */
public interface HotelSummary {
    City getCity();

    String getName();

    Double getAverageRating();

    default Integer getAverageRatingRounded() {
        return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
    }
}
