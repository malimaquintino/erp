package com.malimaquintino.erp.gateway.controller;

import com.malimaquintino.erp.commonmslib.constant.HttpStatusConstants;
import com.malimaquintino.erp.commonmslib.dto.authentication.LoginInputDto;
import com.malimaquintino.erp.commonmslib.dto.authentication.LoginOutputDto;
import com.malimaquintino.erp.commonmslib.dto.common.CommonResponse;
import com.malimaquintino.erp.gateway.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static com.malimaquintino.erp.gateway.constants.Constants.API_GATEWAY_PREDICATE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = API_GATEWAY_PREDICATE + "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> executeQuery(@Valid @RequestBody LoginInputDto inputDto) {
        log.info("Creating new report {}", inputDto);
        CommonResponse<?> commonResponse;
        LoginOutputDto outputDto = null;
        if (authenticate(inputDto)) {
            String token = jwtTokenUtil.generateToken(inputDto.getUsername());
            outputDto = LoginOutputDto.builder()
                    .username("malima")
                    .name("Matheus Quintino")
                    .email("malima@gmail.com")
                    .token(token)
                    .build();
        }
        commonResponse = getResponse(outputDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    private boolean authenticate(LoginInputDto inputDto) {
        return !inputDto.getUsername().equals("foo") || !inputDto.getPassword().equals("foo");
    }

    private CommonResponse getResponse(LoginOutputDto outputDto) {
        return CommonResponse.builder()
                .result(outputDto)
                .error(Boolean.FALSE)
                .status(HttpStatusConstants.HttpOK.CODE)
                .message(HttpStatusConstants.HttpOK.DESCRIPTION)
                .detailMessage("Authentication successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
