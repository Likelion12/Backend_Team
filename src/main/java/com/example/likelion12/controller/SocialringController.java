package com.example.likelion12.controller;

import com.example.likelion12.common.response.BaseResponse;
import com.example.likelion12.common.response.status.BaseExceptionResponseStatus;
import com.example.likelion12.dto.socialring.*;
import com.example.likelion12.service.SocialringService;
import com.example.likelion12.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/socialring")

public class SocialringController {

    private final SocialringService socialringService;
    private final JwtProvider jwtProvider;

    /**
     * 소셜링 등록
     */
    @PostMapping("")
    public BaseResponse<PostSocialringResponse> createSocialring(@RequestHeader("Authorization") String authorization ,
                                                                 @RequestBody PostSocialringRequest postSocialringRequest)
    {   //헤더에서 소셜링 등록하는 멤버아이디 찾기
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        return new BaseResponse<>(socialringService.createSocialring(memberId,postSocialringRequest));
    }

    /**
     * 소셜링 수정
     */
    @PatchMapping("")
    public BaseResponse<Void> modifySocialring(@RequestHeader("Authorization") String authorization, @RequestParam long socialringId,
                                                                 @RequestBody PatchSocialringModifyRequest patchSocialringModifyRequest)
    {
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        socialringService.modifySocialring(memberId,socialringId,patchSocialringModifyRequest);
        return new BaseResponse<>(BaseExceptionResponseStatus.SUCCESS, null);
    }

    /**
     * 소셜링 상세 조회
     */
    @GetMapping("")
    public BaseResponse<GetSocialringDetailResponse> getSocialringDetail(@RequestHeader("Authorization") String authorization,
                                                                         @RequestParam Long socialringId){
        log.info("[SocialringController.getSocialringDetail]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        return new BaseResponse<>(socialringService.getSocialringDetail(memberId, socialringId));
    }

    /**
     * 소셜링 참여하기
     */
    @PostMapping("/join")
    public BaseResponse<Void> joinSocialring(@RequestHeader("Authorization") String authorization,@RequestParam Long socialringId){
        log.info("[SocialringController.joinSocialring]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        socialringService.joinSocialring(memberId, socialringId);
        return new BaseResponse<>(BaseExceptionResponseStatus.SUCCESS, null);
    }

    /**
     * 참가 예정인 소셜링
     */
    @GetMapping("/join/before")
    public BaseResponse<List<GetSocialringJoinStatusResponse>> joinBeforeSocialring(@RequestHeader("Authorization") String authorization){
        log.info("[SocialringController.joinBeforeSocialring]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        return new BaseResponse<>(socialringService.joinBeforeSocialring(memberId));
    }

    /**
     * 참가 완료한 소셜링
     */
    @GetMapping("/join/complete")
    public BaseResponse<List<GetSocialringJoinStatusResponse>> joinCompleteSocialring(@RequestHeader("Authorization") String authorization){
        log.info("[SocialringController.joinCompleteSocialring]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        return new BaseResponse<>(socialringService.joinCompleteSocialring(memberId));
    }

   /**
     * 소셜링 삭제하기
     */
    @PatchMapping("/delete")
    public BaseResponse<Void> deleteSocialring(@RequestHeader("Authorization") String authorization,
                                               @RequestParam("socialringId") Long socialringId) {
        log.info("[SocialringController.deleteSocialring]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        socialringService.deleteSocialring(memberId, socialringId);
        return new BaseResponse<>(BaseExceptionResponseStatus.SUCCESS, null);
    }

    /**
     * 소셜링 취소하기
     */
    @PatchMapping("/cancel")
    public BaseResponse<Void> cancelSocialring(@RequestHeader("Authorization") String authorization,
                                               @RequestParam("socialringId") Long socialringId) {
        log.info("[SocialringController.cancelSocialring]");
        Long memberId = jwtProvider.extractIdFromHeader(authorization);
        socialringService.cancelSocialring(memberId, socialringId);
        return new BaseResponse<>(BaseExceptionResponseStatus.SUCCESS, null);
    }

}
