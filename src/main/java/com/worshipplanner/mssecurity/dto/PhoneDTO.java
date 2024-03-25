package com.worshipplanner.mssecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class PhoneDTO {
    private String number;
    private int cityCode;
    private int cityCountry;
}
