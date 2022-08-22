package com.matzip.server.domain.me.model;

import com.matzip.server.domain.review.model.Review;
import com.matzip.server.domain.user.model.User;
import com.matzip.server.global.common.model.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="heart")
@NoArgsConstructor
@Getter
public class Heart extends BaseTimeEntity {
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Review review;

    public Heart(User user, Review review) {
        this.user = user;
        this.review = review;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Heart && this.user.equals(((Heart) obj).user) && this.review.equals(((Heart) obj).review);
    }
}