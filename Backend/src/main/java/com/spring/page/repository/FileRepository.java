package com.spring.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.page.entity.File;

public interface FileRepository extends JpaRepository<File, Long> {
	
}
