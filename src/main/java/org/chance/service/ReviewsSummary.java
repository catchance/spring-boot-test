package org.chance.service;

import org.chance.domain.Rating;

/**
 * Created by wqg on 2016/3/14.
 */
public interface ReviewsSummary {
    long getNumberOfReviewsWithRating(Rating rating);
}
