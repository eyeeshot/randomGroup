package com.eyeeshot.randomgroup.service;

import com.eyeeshot.randomgroup.dto.GroupDto;
import com.eyeeshot.randomgroup.dto.MemberDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Group {

    public List<GroupDto> randomGroup(String month){
        Member member = new Member();
        Room room = new Room();
        List<MemberDto> thisMember = member.getThisMonthMembers(month);
        List<GroupDto> thisRoom = room.getThisRoom(month);

        List<GroupDto> result = setRandomGroup(thisMember,thisRoom);

        return result;
    }

    public List<GroupDto> setRandomGroup(List<MemberDto> thisMember,List<GroupDto> thisRoom) {
        List<MemberDto> thisMonthMembers = new ArrayList<>();
        List<GroupDto> thisMonthGroups = new ArrayList<>();

        for (MemberDto member:thisMember) {
            MemberDto thisMonthMember = new MemberDto();
            List<GroupDto> rooms = thisRoom.stream()
                    .filter(e -> (member.getRooms().stream()
                            .filter(d -> d.getName().equals(e.getRoomName()))
                            .count())<1)
                    .collect(Collectors.toList());
            thisMonthMember.setName(member.getName());
            for (GroupDto room:rooms) {
                thisMonthMember.getRooms().add(new RoomDto(room.getRoomName()));
            }
            thisMonthMembers.add(thisMonthMember);
        }

        int i = 0;
        int x = 0;

        for (MemberDto member: thisMonthMembers) {
            while (true) {
                int rnd = (int) (Math.random() * member.getRooms().size());

                GroupDto group = thisMonthGroups.stream().filter(e->e.getRoomName().equals(member.getRooms().get(rnd).getName())).findAny().orElse(null);
                int limit = thisRoom.stream().filter(e->e.getRoomName().equals(member.getRooms().get(rnd).getName())).findAny().orElse(null).getLimit();

                if(group == null) {
                    GroupDto groupDto = new GroupDto();
                    groupDto.setRoomName(member.getRooms().get(rnd).getName());
                    groupDto.getMember().add(member.getName());
                    thisMonthGroups.add(groupDto);
                    break;
                } else if (group.getMember().size() > 0 && group.getMember().size() < limit) {
                    group.getMember().add(member.getName());
                    break;
                }
                i++;
            }
        }

        return thisMonthGroups;
    }
}
