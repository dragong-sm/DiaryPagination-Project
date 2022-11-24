package com.spring.page.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.page.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
	public Diary getDiaryByNo(Long diaryNo);
	public Optional<Diary> findDiaryByNo(Long diaryNo);
}

