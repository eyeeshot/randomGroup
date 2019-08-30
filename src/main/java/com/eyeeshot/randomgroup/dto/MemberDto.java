package com.eyeeshot.randomgroup.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberDto {
    String name;
    List<RoomDto> rooms;
}
