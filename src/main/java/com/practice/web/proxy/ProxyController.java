package com.practice.web.proxy;


import com.practice.web.mappers.MusicMapper;
import com.practice.web.music.MovieDTO;
import com.practice.web.music.Music;
import com.practice.web.music.MusicDTO;
import com.practice.web.music.MusicRepository;
import com.practice.web.soccer.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/musics")

public class ProxyController{
  @Autowired Box<Object> box;
  @Autowired Crawler crawler;
  @Autowired FileUploader uploader;
  @Autowired Proxy pxy;
  @Autowired MusicRepository musicRepository;
  @Autowired Pager pager;
  @Autowired MusicMapper musicMapper;


  @GetMapping("/naver/{searchWord}")
  public void naver(@PathVariable String searchWord){
    pxy.print("넘어온 키워드: "+searchWord);
    crawler.naverMovie();
  }


  @GetMapping("/soccer/{searchWord}")
  public HashMap<?,?> soccer(@PathVariable String searchWord){
    pxy.print("넘어온 키워드:"+ searchWord);
    uploader.upload();
    return null;
  }

  @GetMapping("/{searchWord}/{pageNumber}")
  public Map<?,?> bugsmusic(@PathVariable("pageNumber") String pageNumber,
                            @PathVariable("searchWord") String searchWord){
    if(searchWord.equals("")) {
      pxy.print("검색어가 없음");
    }else{
      pxy.print("검색어가" + searchWord);
    }
    pager.setPageNow(pxy.integer(pageNumber));
    pager.setBlockSize(5);
    pager.setPageSize(5);
    pager.Pager();
    IFuncion<Pager, List<MusicDTO>> f = s -> musicMapper.selectMusics(pager);
    List<MusicDTO> list = f.apply(pager);
    pxy.print("**********");
    for (MusicDTO m : list){
      pxy.print(m.toString());
    }
    box.clear();
    box.put("pager",pager);
    box.put("list",list);
    return box.get();
  }
}




