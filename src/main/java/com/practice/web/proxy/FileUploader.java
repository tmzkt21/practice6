package com.practice.web.proxy;


import com.practice.web.music.Music;
import com.practice.web.music.MusicRepository;
import com.practice.web.proxy.Inventory;
import com.practice.web.proxy.Proxy;
import com.practice.web.soccer.Player;
import com.practice.web.soccer.PlayerDTO;
import com.practice.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("uploader") @Lazy
@Component

public class FileUploader extends Proxy {
    @Autowired
    Inventory<String> inventory;
    @Autowired PlayerRepository playerRepository;

//    @Autowired Music music;
//    @Autowired Player player;
    MusicRepository musicRepository;
//    @Autowired Player player;

    public void upload(){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(
                            new FileReader(
                            new File("C:\\Users\\bit\\IdeaProjects\\lambda\\src\\main\\resources\\static\\files\\player.csv")));
            String player = "";
            while((player = reader.readLine()) != null){
                inventory.add(player);
            }
        }catch(Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        print("--------------------------------------\n");
        print(inventory.get().get(0).toString());
        String[] arr = inventory.get().get(0).toString().split(",");
        // "2000003","유동우","K10","YOU,  DONGWOO","","","DF","40","","07-MAR-1978","1","177","70"

        Player p = new Player();

        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setePlayerName(arr[2]);
        p.setNickname(arr[3]);
        p.setJoinYyyy(arr[4]);
        p.setPosition(arr[5]);
        p.setBackNo(arr[6]);
        p.setNation(arr[7]);
        p.setBirthDate(arr[8]);
        p.setSolar(arr[9]);
        p.setHeight(arr[10]);
        p.setWeight(arr[11]);
        print("***************************\n");
        print(p.toString());
        // p.setTeam();
        playerRepository.save(p);

    }
    public void music_upload(ArrayList<HashMap<String,String>> list){
        print("***************************\n");
        print(list.get(0).toString());
        Music m = new Music();

        m.setSeq(list.get(0).get("seq"));
        m.setTitle(list.get(0).get("title"));
        m.setArtists(list.get(0).get("artist"));
        m.setThumbnail(list.get(0).get("thumbnail"));
        musicRepository.save(m);
    }
}