package org.chance.service;

import org.chance.domain.City;
import org.chance.domain.Hotel;
import org.chance.domain.Review;
import org.chance.domain.ReviewDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by wqg on 2016/3/14.
 */
public interface HotelService {

    Hotel getHotel(City city, String name);

    Page<Review> getReviews(Hotel hotel, Pageable pageable);

    Review getReview(Hotel hotel, int index);

    Review addReview(Hotel hotel, ReviewDetails details);

    ReviewsSummary getReviewSummary(Hotel hotel);


}
