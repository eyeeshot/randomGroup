package com.eyeeshot.randomgroup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomDto {
    String name;
    public RoomDto (String room) {
        this.name = room;
    }
}
