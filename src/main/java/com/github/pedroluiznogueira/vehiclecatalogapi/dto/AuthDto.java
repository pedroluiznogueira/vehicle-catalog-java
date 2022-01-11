package com.github.pedroluiznogueira.vehiclecatalogapi.dto;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {

    private String type;
    private String token;
    private Integer userId;
    private Boolean isAdmin;
}
