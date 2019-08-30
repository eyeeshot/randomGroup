package com.eyeeshot.randomgroup.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {
    String name;
    public RoomDto (String room) {
        this.name = room;
    }
}
