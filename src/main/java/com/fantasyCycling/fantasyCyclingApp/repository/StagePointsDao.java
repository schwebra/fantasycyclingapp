package com.fantasyCycling.fantasyCyclingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fantasyCycling.fantasyCyclingApp.model.StagePoints;

@Repository
public interface StagePointsDao extends JpaRepository<StagePoints, Long> {
	
	@Query(value = "WITH SPID AS (SELECT CS.STAGERESULTS_STAGEPOINTSID FROM USER_CYCLIST UC LEFT JOIN CYCLIST_STAGERESULTS CS ON UC.TEAM_CYCLISTID = CS.CYCLIST_CYCLISTID WHERE UC.USER_USERID = :userId)\r\n"
			+ "SELECT STAGEPOINTSID, STAGERANK ,SPRINTPOINTS ,MOUNTAINPOINTS ,GCRANK ,POINTSRANK ,MOUNTAINSRANK ,MOSTCOMBATIVE ,STAGEID FROM SPID LEFT JOIN STAGEPOINTS SP ON SPID.STAGERESULTS_STAGEPOINTSID = SP.STAGEPOINTSID WHERE STAGEID = :stageId", nativeQuery = true)
	List<StagePoints> getS(@Param("userId") Long userId, @Param("stageId") Long stageId);

//	@Query(value = "Select stagePoints from User u join u.stagePointsList stagePoints where u.userId = :userId", nativeQuery = true)
//	List<StagePoints> getUserStagePointsList(@Param("userId") Long userId);
	
	@Query(value="WITH SPID AS (SELECT STAGEPOINTSLIST_STAGEPOINTSID AS STAGEPOINTSID FROM USER_STAGEPOINTS WHERE USER_USERID = :userId)\r\n"
			+ "SELECT SP.STAGEPOINTSID, STAGERANK ,SPRINTPOINTS ,MOUNTAINPOINTS ,GCRANK ,POINTSRANK ,MOUNTAINSRANK ,MOSTCOMBATIVE ,STAGEID FROM SPID LEFT JOIN STAGEPOINTS SP ON SPID.STAGEPOINTSID = SP.STAGEPOINTSID", nativeQuery = true)
	List<StagePoints> getUserStagePointsList(@Param("userId") Long userId);
	
	}
