package com.exam.one_team_anywhere.requests;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class NoteRequest {
    @NonNull
    private String title;
    @NotBlank(message = "Please provide a username")
    private String body;
}
