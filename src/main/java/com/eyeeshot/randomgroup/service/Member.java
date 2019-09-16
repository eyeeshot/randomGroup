package com.eyeeshot.randomgroup.service;

import com.eyeeshot.randomgroup.dto.MemberDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import com.eyeeshot.randomgroup.library.ParserJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Member {

    private List<MemberDto> totalMembers = new ArrayList<>();
    private List<MemberDto> thisMonthMembers = new ArrayList<>();

    public Member() {
        ParserJson parserJson = new ParserJson();

        Room roomService = new Room();
        List<String> originRooms = roomService.getOriginRoom();

        List<JSONObject> jsonMembers = parserJson.getResouceJsonData("member");
        for (JSONObject json : jsonMembers) {
            MemberDto mem = new MemberDto();
            mem.setName((String) json.get("name"));

            List<String> rooms = (List<String>) json.get("rooms");
            for (String room : rooms) {
                if (originRooms.contains(room)) {
                    mem.getRooms().add(new RoomDto(room));
                }
            }
            totalMembers.add(mem);
        }
    }

    public List<MemberDto> getTotalMember() {
        totalMembers.sort(Comparator.reverseOrder());
        return totalMembers;
    }

    public List<MemberDto> setThisMember(String month) {

        JSONObject jsonObject = new ParserJson().getJson(month+"/not_join.json");
        if (jsonObject != null) {
            JSONArray returnMembers = (JSONArray)jsonObject.get("member");
            for (MemberDto member : this.totalMembers) {
                if (!returnMembers.contains(member.getName())) {
                    MemberDto mem = new MemberDto();
                    mem.setName(member.getName());
                    mem.setRooms(member.getRooms());
                    thisMonthMembers.add(mem);
                }
            }
        }
        return null;
    }

    public List<MemberDto> getThisMonthMembers(String month) {
        if (thisMonthMembers.isEmpty()) {
            this.setThisMember(month);
            thisMonthMembers.sort(Comparator.reverseOrder());
        }
        return this.thisMonthMembers;
    }
}