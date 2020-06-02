package com.practice.web.mappers;

import com.practice.web.music.MovieDTO;
import com.practice.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieMapper {
    public void insertMovie(MovieDTO movieDTO);
    public void updateMovie(MovieDTO movieDTO);
    public void deleteMovie(MovieDTO movieDTO);
    public void selectMovie(String value);
    public int count();
    public List<MovieDTO> selectMovies(Pager pager);
}