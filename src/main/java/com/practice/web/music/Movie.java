package com.practice.web.music;


import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;

    @Column(length = 4, nullable = false)
    private String rank;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String rankDate;



    @Builder
    public Movie(String rank,
                 String title,
                 String rankDate) {
        this.rank = rank;
        this.title = title;
        this.rankDate = rankDate;


    }
}
