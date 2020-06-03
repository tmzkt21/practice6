package com.practice.web.proxy;

import com.practice.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Data
@Component @Lazy
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount,rowStart,rowEnd,
                pageCount,pageSize,pageStart,pageEnd,pageNow,
                blockCount,blockSize,prevBlock,nextBlock,blockNow;

private boolean existPrev, existNext;
private String searchWord;
    public void Pager(){
        rowCount = movieMapper.count();
        rowStart = pageNow * pageSize; // 0
        rowEnd = (pageNow != pageCount -1) ? rowStart + (pageSize-1):rowCount-1; // 4
        pageCount = (rowCount % pageSize != 0) ? rowCount/pageSize +1 :rowCount / pageSize ; // 10
        pageStart = blockNow *  blockSize; // 0
        pageEnd = (blockNow !=(blockNow-1)) ? pageStart + (blockSize - 1):pageCount -1; // 4
//        pageSize = 5; 주석 = 외부에서 set 받는값
//        pageNow = 0;
        blockCount = (pageCount % blockSize != 0) ? pageCount/blockSize +1 :pageCount / blockSize ; // 2
        prevBlock = pageStart - blockSize; // 0
        nextBlock = pageStart + blockSize; // 1
//        blockSize = 5;
        blockNow = pageNow / blockSize; // 0
        System.out.println("blockNow :: "+blockNow);
        existPrev = blockNow != 0;
        System.out.println("existPrev :: "+existPrev);
        existNext = (blockNow +1) != blockNow;
        System.out.println("existPrev :: "+existNext);

    }
}
