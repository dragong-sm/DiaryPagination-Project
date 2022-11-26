package com.spring.page.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.page.dto.FileDTO;
import com.spring.page.entity.Diary;
import com.spring.page.entity.File;
import com.spring.page.repository.DiaryRepository;
import com.spring.page.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileRepository fileRepo;
	
	@Autowired
	DiaryRepository diaryRepo;
	
	public void insertFile(Long diaryId, MultipartFile file) {
		FileDTO fileDTO = FileDTO.builder()
								.originalFileName(file.getOriginalFilename())
								.fileName(UUID.randomUUID() + "_" + file.getOriginalFilename())
								.filePath(System.getProperty("user.dir") + "\\files")
								.build();
		File fileEntity = FileDTO.dtoToEntity(fileDTO);
		
		Diary diary = diaryRepo.getDiaryByNo(diaryId);
		
		fileEntity.updateDiary(diary); 
		fileRepo.save(fileEntity);
	}
	
	public String getUrl(Long fileId) {
		Optional<File> file = fileRepo.findFileByNo(fileId);
		FileDTO fileDTO = File.entityToDTO(file.get());
		return fileDTO.getFilePath();
	}

	public String getFileName(Long fileId) {
		Optional<File> file = fileRepo.findFileByNo(fileId);
		FileDTO fileDTO = File.entityToDTO(file.get());
		return fileDTO.getOriginalFileName();
	}
}
