package com.practice.web.music;

import com.practice.web.mappers.MovieMapper;
import com.practice.web.proxy.Box;
import com.practice.web.proxy.IFuncion;
import com.practice.web.proxy.Pager;
import com.practice.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    //화면 던질때는 MovieDTO
    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord) {
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어가" +searchWord);
        }
//        Pager pager = new Pager();
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFuncion<Pager, List<MovieDTO>> f = s -> movieMapper.selectMovies(pager);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("***********");
        for (MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager",pager);
        box.put("list",l);
        //        box.put("count",l.size());
        //        pxy.print(l.get(0).toString());
        return box.get();
    }


}
