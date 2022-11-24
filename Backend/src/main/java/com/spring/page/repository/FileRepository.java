package com.spring.page.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.page.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {
	
	@Query("SELECT f FROM file f WHERE f.diary_no = :diaryNo")
	public Optional<File> getFileByNo(Long diaryNo); // @Query가 쿼리 메소드 보다 우선순위
}
