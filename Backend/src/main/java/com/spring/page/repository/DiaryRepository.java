package com.spring.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.page.entity.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

}

