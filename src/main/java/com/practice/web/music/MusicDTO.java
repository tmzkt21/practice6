package com.practice.web.music;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MusicDTO {
    private String musicSeq,artists,title,thumbnail;
}
