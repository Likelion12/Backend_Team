package com.example.likelion12.repository;

import com.example.likelion12.domain.MemberSocialring;
import com.example.likelion12.domain.base.BaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberSocialringRepository extends JpaRepository<MemberSocialring, Long> {
    //Optional<MemberSocialring> findByMemberIdAndSocialringIdAndStatus(Long memberId, Long socialringId, BaseStatus status);
    Optional<MemberSocialring> findByMember_MemberIdAndSocialring_SocialringIdAndStatus(Long memberId, Long socialringId, BaseStatus status);
}

