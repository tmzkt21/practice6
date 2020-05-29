package com.practice.web.proxy;

import com.practice.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component @Lazy
public class Pager {
    @Autowired
    MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
            pageCount, pageSize, startPage, endPage, nowPage,
            blockCount, blockSize, prevBlock, nextBlock, existPrev, exisNext;

    public void paging() {
        rowCount = movieMapper.count();
        pageSize = 5;
        pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize + 1 : rowCount / pageSize;
        blockSize = 5;
        blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize + 1 : pageCount / blockSize;
        nowPage = 1;
        startRow = (nowPage - 1) * pageSize + 1;
        endRow = (nowPage != pageCount) ? nowPage * pageSize : rowCount;
//        nowBlock = (nowPage % blockSize != 0) ? nowPage / blockSize + 1 : nowPage / blockSize;
//        startPage = (nowBlock - 1) * blockSize + 1;
//        endPage = (nowBlock != blockCount) ? startPage + blockSize : pageCount;
//        prevBlock = startPage - blockSize;
//        nextBlock = startPage + blockSize;
//        existPrev = (nowBlock != 1);
//        existNext = (nowBlock != blockCount);
    }
}