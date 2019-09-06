package com.eyeeshot.randomgroup.service;

import com.eyeeshot.randomgroup.dto.MemberDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import com.eyeeshot.randomgroup.library.ParserJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Room {
    private MemberDto memberDto = new MemberDto();

    public Room() {
        try {
            JSONObject jsonObject = new ParserJson().getJson("rooms.json");

            if (jsonObject != null) {

                JSONArray returnRooms = (JSONArray)jsonObject.get("rooms");

                for(int i=0;i<returnRooms.size();i++) {
                    memberDto.getRooms().add(new RoomDto(returnRooms.get(i).toString()));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MemberDto getOriginRoom(){
        return memberDto;
    }
}
