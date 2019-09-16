package com.eyeeshot.randomgroup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class MemberDto implements Comparable<MemberDto>{
    String name;
    List<RoomDto> rooms = new ArrayList<>();

    @Override
    public int compareTo(MemberDto getMemberDto){
        int targetCount = getMemberDto.rooms.size();

        if(this.rooms.size() == targetCount) return 0;
        else if(this.rooms.size() > targetCount) return 1;
        else return -1;

    }
}
