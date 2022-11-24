package com.spring.page.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public void insertFile(Long diaryId, MultipartFile file);
}
