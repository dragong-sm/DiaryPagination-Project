package com.spring.page.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.page.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
	
	@Query("SELECT f FROM File f WHERE f.diary.no = :diaryNo")
	public List<File> getFileByDiaryNo(@Param("diaryNo") Long diaryNo); // @Query가 쿼리 메소드 보다 우선순위
	
	public File getFileByNo(Long fileId);
}
