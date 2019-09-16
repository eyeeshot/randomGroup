package com.eyeeshot.randomgroup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class GroupDto {
    String roomName;
    int limit;
    List<String> member = new ArrayList<>();
}
