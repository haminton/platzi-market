package com.platzi.market.domain.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {

    private String jwt;

    public AuthResponseDTO(String jwt) {
        this.jwt = jwt;
    }

}
