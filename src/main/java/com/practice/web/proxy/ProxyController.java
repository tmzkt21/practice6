package com.practice.web.proxy;


import com.practice.web.music.Music;
import com.practice.web.music.MusicRepository;
import com.practice.web.soccer.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProxyController{
  @Autowired Box<Object> box;
  @Autowired Crawler crawler;
  @Autowired FileUploader uploader;
  @Autowired Proxy pxy;
  @Autowired MusicRepository musicRepository;


  @GetMapping("/naver/{searchWord}")
  public void naver(@PathVariable String searchWord){
    pxy.print("넘어온 키워드: "+searchWord);
    crawler.naverMovie();
  }


  @GetMapping("/soccer/{searchWord}")
  public HashMap<String,String> soccer(@PathVariable String searchWord){
    pxy.print("넘어온 키워드:"+ searchWord);
    uploader.upload();
    return null;
  }

  @PostMapping("/bugsmusic")
  public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
    pxy.print("넘어온 키워드: "+searchWord);
    box.clear();
    if(musicRepository.count() == 0) crawler.bugsMusic();
    List<Music> list = musicRepository.findAll();
    box.put("list", list);
    box.put("count", list.size());
    return box.get();
  }
}




