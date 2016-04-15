package org.chance.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by wqg on 2016/3/14.
 */

@Entity
public class Hotel implements Serializable {

    private static final long serialVersionUID = -5559401225101286163L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @NaturalId
    private City city;

    @Column(nullable = false)
    @NaturalId
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String zip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    private Set<Review> reviews;

    protected Hotel() {
    }

    public Hotel(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }
}
