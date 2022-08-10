package com.platzi.market.domain.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String user;
    private String password;

}
