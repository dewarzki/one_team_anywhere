package com.exam.one_team_anywhere.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Note {
    private int id;
    private String title;
    private String Body;
}
