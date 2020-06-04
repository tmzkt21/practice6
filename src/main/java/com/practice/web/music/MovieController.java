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
import java.util.function.Function;

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
        pxy.print("넘어온 검색어:" + searchWord);

        if(searchWord.equals("null")){
            pxy.print("검색어가 없음");
            pager.setSearchWord("");
        }else{
            pxy.print("검색어가" +searchWord);
            pager.setSearchWord(searchWord);
        }

        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
//        pager.setSearchWord(searchWord); 개놈시키
//        if(searchWord.equals(null))pager.setSearchWord(searchWord);
//        pager.setExistNext(true);
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
    @GetMapping("/{searchWord}")
    public MovieDTO detail(@PathVariable("searchWord") String searchWord){
        IFuncion<String,MovieDTO> f = p -> movieMapper.selectMovie(p);
        MovieDTO m = f.apply(searchWord);
        return f.apply(searchWord);
    }

}
