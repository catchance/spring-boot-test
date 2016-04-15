package org.chance.service;

import org.chance.domain.City;
import org.chance.domain.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by wqg on 2016/3/14.
 */
public interface CityService {

    Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

    City getCity(String name, String country);

    Page<HotelSummary> getHotels(City city, Pageable pageable);

}
