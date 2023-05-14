package com.malimaquintino.erp.commonmslib.dto.authentication;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginOutputDto {

    @ApiModelProperty(notes = "Username")
    private String username;

    @ApiModelProperty(notes = "Name")
    private String name;

    @ApiModelProperty(notes = "E-mail")
    private String email;

    @ApiModelProperty(notes = "Token")
    private String token;
}
