package com.eyeeshot.randomgroup;

import com.eyeeshot.randomgroup.dto.MemberDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class RandomGroupApplication {
    public static void main(String[] args){

        try {
            InputStream inputStream = RandomGroupApplication.class.getClassLoader()
                    .getResourceAsStream("rooms.json");

            if (inputStream != null) {
                BufferedReader streamReader = new BufferedReader(
                        new InputStreamReader(inputStream, "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();

                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(responseStrBuilder.toString());
                JSONArray returnRooms = (JSONArray)jsonObject.get("rooms");
                MemberDto memberDto = new MemberDto();


                for(int i=0;i<returnRooms.size();i++) {
                    memberDto.getRooms().add(new RoomDto(returnRooms.get(i).toString()));
                }


            } else {
                System.out.println("json non");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }
}