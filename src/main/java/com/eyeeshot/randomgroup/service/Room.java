package com.eyeeshot.randomgroup.service;

import com.eyeeshot.randomgroup.dto.GroupDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import com.eyeeshot.randomgroup.library.ParserJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<String> totalRoom = new ArrayList<>();
    private List<GroupDto> thisMonthlRoom = new ArrayList<>();

    public Room() {
        try {
            JSONObject jsonObject = new ParserJson().getJson("rooms.json");

            if (jsonObject != null) {

                JSONArray returnRooms = (JSONArray)jsonObject.get("rooms");

                for(int i=0;i<returnRooms.size();i++) {
                    totalRoom.add(returnRooms.get(i).toString());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getOriginRoom(){
        return totalRoom;
    }

    public List<String> setThisRooms(String month) {

        JSONObject jsonObject = new ParserJson().getJson(month+"/choice_room.json");
        if (jsonObject != null) {
            JSONArray returnRooms = (JSONArray)jsonObject.get("rooms");
            for(int i=0;i<returnRooms.size();i++) {
                GroupDto groupDto = new GroupDto();
                JSONObject returnRoom = (JSONObject)returnRooms.get(i);
                groupDto.setRoomName(returnRoom.get("name").toString());
                groupDto.setLimit(Integer.parseInt(returnRoom.get("limit").toString()));
                thisMonthlRoom.add(groupDto);
            }
        }

        return null;
    }

    public List<GroupDto> getThisRoom(String month){
        if (thisMonthlRoom.isEmpty()) {
            this.setThisRooms(month);
        }
        return thisMonthlRoom;
    }
}
