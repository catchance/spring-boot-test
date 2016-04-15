package org.chance.service;

import org.chance.domain.Hotel;
import org.chance.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

/**
 * Created by wqg on 2016/3/14.
 */
public interface ReviewRepository extends Repository<Review, Long>{

    Page<Review> findByHotel(Hotel hotel, Pageable pageable);

    Review findByHotelAndIndex(Hotel hotel, int index);

    Review save(Review review);

}
