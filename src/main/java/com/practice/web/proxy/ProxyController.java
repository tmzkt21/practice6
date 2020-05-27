package com.practice.web.proxy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/proxys")

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProxyController {
@Autowired Box<Object> box;
@Autowired Crawler crawler;
@Autowired Proxy pxy;

@PostMapping("/bugsmusic")
  public HashMap<String,Object>bugsmusic(@RequestBody String searchWord){
    pxy.print("넘어온 키워드:" +searchWord);
    box.clear();
    ArrayList<HashMap<String,String>> list = crawler.bugsMusic();
    box.put("list",list);
    pxy.print("************");
    pxy.print("조회한수 :" +list.size());
    box.put("count",list.size());
    return box.get();
  }

  @PostMapping("/soccer")
  public String soccer(@RequestBody String searchWord){
    pxy.print("넘어온키워드" +searchWord);
    return searchWord;
  }

}


//  @Autowired Crawler crawler;
//
//  @GetMapping("/")
//  public String home(){
//    return "안녕크롤링";
//  }
//
//  @GetMapping("/crawler")
//  public ArrayList<HashMap<String,String>> crawler(){
//    return crawler.bugsMusic();
//  }




//    @CrossOrigin(origins="*",allowedHeaders = "*")

//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @RestController
//    @RequestMapping("/crawer")

//
//package com.lsg.web.controllers;
//
//        import com.lsg.web.domains.PlayerDTO;
//        import com.lsg.web.services.PlayerService;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.*;
//
//        import java.util.HashMap;
//        import java.util.List;
//        import java.util.Map;
//
//@CrossOrigin(origins="*", allowedHeaders = "*")
//
//@RestController
//
//@RequestMapping("/players")
//
//public class PlayerController {
//    @Autowired
//    PlayerService playerService;
//    @Autowired PlayerDTO player;
//    @GetMapping("")
//
//    public List<PlayerDTO> List(){
//        return playerService.retrieve();
//    }
//    @PostMapping("/{playerId}/access")
//    public Map<String, Object> login(
//            @PathVariable String playerId,
//            @RequestBody PlayerDTO params) {
//        Map<String,Object> map = new HashMap<>();
//        player = playerService.login(params);
//        if(player != null){
//            System.out.println("로그인 정보 "+ player.toString());
//            map.put("result", true);
//        }else{
//            map.put("result", false);
//        }
//        map.put("player", player);
//        return map;
//    }
//}
