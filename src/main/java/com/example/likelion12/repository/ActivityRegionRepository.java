package com.example.likelion12.repository;

import com.example.likelion12.domain.ActivityRegion;
import com.example.likelion12.domain.base.BaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRegionRepository extends JpaRepository<ActivityRegion, Long> {

    Optional<ActivityRegion> findByIdAndStatus(Long activityRegionId, BaseStatus status);
}
