package com.eyeeshot.randomgroup;

import com.eyeeshot.randomgroup.dto.MemberDto;
import com.eyeeshot.randomgroup.dto.RoomDto;
import com.eyeeshot.randomgroup.library.ParserJson;
import com.eyeeshot.randomgroup.service.Room;
import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGroupApplication {
    public static void main(String[] args){
        //new Room();

        ParserJson parserJson = new ParserJson();
        parserJson.getResouceJsonData("member");
    }
}

