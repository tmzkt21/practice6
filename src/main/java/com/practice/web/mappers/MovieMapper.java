package com.practice.web.mappers;

import com.practice.web.music.MovieDTO;
import com.practice.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieMapper {


    public void insertMovie(MovieDTO movie);
    public void updateMovie(MovieDTO movie);
    public void deleteMovie(MovieDTO movie);
    public MovieDTO selectMovie(String movieSeq);
    public int count();
    public List<MovieDTO> selectMovies(Pager pager);


}
