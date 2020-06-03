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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    //화면 던질때는 MovieDTO
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord) {

        pxy.print("넘어온 페이지번호:" + pageNumber);

        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어가" +searchWord);
        }


//        Pager pager = new Pager();
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.setExistNext(true);
        pager.Pager();
        IFuncion<Pager, List<MovieDTO>> f = s -> movieMapper.selectMovies(pager);
        List<MovieDTO> list = f.apply(pager);
        pxy.print("***********");
        for (MovieDTO m : list){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("pager",pager);
        box.put("list",list);
        return box.get();
    }


}
