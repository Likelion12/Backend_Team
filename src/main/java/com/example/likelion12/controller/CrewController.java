package com.example.likelion12.controller;

import com.example.likelion12.common.response.BaseResponse;
import com.example.likelion12.dto.PostCrewRequest;
import com.example.likelion12.dto.PostCrewResponse;
import com.example.likelion12.service.CrewService;
import com.example.likelion12.util.JwtProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CrewController {

    private final JwtProvider jwtProvider;
    private final CrewService crewService;

    /**
     * 크루 등록
     */
    public BaseResponse<PostCrewResponse> createCrew(@RequestHeader("Authorization") String authorization,
                                                     @RequestBody PostCrewRequest postCrewRequest){
        log.info("[CrewController.createCrew]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        return new BaseResponse<>(crewService.createCrew(memberId, postCrewRequest));
    }
}