package com.worshipplanner.mssecurity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String date;
    private String status;
    private String message;
}
