package com.ratingservice.RatingService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    private String id;

    private String userId;

    private String hotelId;

    private String about;

    private int rating;
}