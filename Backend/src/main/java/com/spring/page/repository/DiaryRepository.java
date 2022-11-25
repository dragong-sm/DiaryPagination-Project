package com.spring.page.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.page.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
	public Diary getDiaryByNo(Long diaryNo);
	public Optional<Diary> findDiaryByNo(Long diaryNo);
}

