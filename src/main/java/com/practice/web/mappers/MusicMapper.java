package com.practice.web.mappers;

import com.practice.web.music.MusicDTO;
import com.practice.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicMapper{
    public void insertMusic(MusicDTO musicDTO);
    public void updateMusic(MusicDTO musicDTO);
    public void deleteMusic(MusicDTO musicDTO);
    public void selectMusic(String value);
    public int count();
    public List<MusicDTO> selectMusics(Pager pager);
}
