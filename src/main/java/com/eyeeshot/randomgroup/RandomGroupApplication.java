package com.eyeeshot.randomgroup;

import com.eyeeshot.randomgroup.dto.GroupDto;
import com.eyeeshot.randomgroup.service.Group;
import com.eyeeshot.randomgroup.service.Room;

import java.util.List;

public class RandomGroupApplication {
    public static void main(String[] args){
        Group group = new Group();
        List<GroupDto> results = group.randomGroup("201909");

        for (GroupDto result:results) {
            System.out.println("방이름 : "+result.getRoomName());
            System.out.println("멤버 : "+result.getMember());
            System.out.println();
        }
    }
}