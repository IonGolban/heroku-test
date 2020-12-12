package com.example.homeworkproject.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeletedResponse {

    private Boolean isDeleted;

}
