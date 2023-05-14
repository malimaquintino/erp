package com.malimaquintino.erp.commonmslib.dto.authentication;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginInputDto {
    @NotNull(message = "Username")
    @ApiModelProperty(notes = "Username")
    private String username;

    @NotNull(message = "User's password")
    @ApiModelProperty(notes = "User's password")
    private String password;
}
