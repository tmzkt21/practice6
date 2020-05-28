package com.practice.web.proxy;

import com.practice.web.music.Music;
import com.practice.web.music.MusicRepository;
import com.practice.web.proxy.Box;
import com.practice.web.proxy.Inventory;
import com.practice.web.proxy.Proxy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
@Component @Lazy
public class Crawler extends Proxy {
    @Autowired
    Inventory<Music> inventory;
    @Autowired
    Box<String> box;
    @Autowired
    MusicRepository musicRepository;

    public void bugsMusic(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            Music music = null;
            for(int i=0; i < title.size(); i++){
                music = new Music();
                music.setSeq( string(i+1));
                music.setTitle(title.get(i).text());
                music.setArtists(artist.get(i).text());
                music.setThumbnail(thumbnail.get(i).select("img").attr("src"));
                musicRepository.save(music);
            }
        }catch (Exception e){
            print("에러 발생");
        }
        print("******************** 크롤링 결과 *****************\n");
        // inventory.get().forEach(System.out::print);
        //print(inventory.get().get(0).toString());

    }
}