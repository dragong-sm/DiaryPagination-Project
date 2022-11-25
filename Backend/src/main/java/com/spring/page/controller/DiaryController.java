package com.spring.page.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.service.DiaryServiceImpl;
import com.spring.page.service.FileServiceImpl;

@CrossOrigin({"*"})
@RestController
public class DiaryController {	

	@Autowired
	DiaryServiceImpl diaryService;
	
	@Autowired
	FileServiceImpl fileService;
	 
	//1. Diary 번호로 조회
	@GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		
		return diaryService.getDiary(diaryNo);
	}

	//2. Diary 목록 조회 - 페이징 처리 포함
	@GetMapping("/diary/page") 
	public PageResultDTO getDiaryList(@RequestParam int size, @RequestParam int page) {
		Pageable pageable = PageRequest.of(page, size); 
		return diaryService.getDiaryList(pageable);
	}
		
	@PostMapping("diary")
	public void insertDiary(@ModelAttribute DiaryDTO diaryDTO, @ModelAttribute MultipartFile file) {
		Long diaryId = diaryService.insertDiary(diaryDTO);
		if(diaryId != null && file != null) {
			fileService.insertFile(diaryId, file);
		}
	}
	
	@PutMapping("/diary/{diaryNo}")
	public void updateDiary(@PathVariable Long diaryNo, @RequestBody DiaryDTO diaryDTO) {
		diaryService.updateDiary(diaryNo, diaryDTO);
	}
	
	@DeleteMapping("diary/{diaryNo}")
	public void deleteDiary(@PathVariable Long diaryNo) {
		diaryService.deleteDiary(diaryNo);
	}

	//기타
	//대용량 데이터 입력
	@GetMapping("/batch")
	public void insertBatchData() {
		List<DiaryDTO> diaryList = new ArrayList<DiaryDTO>();
		// List<FileDTO> fileList = new ArrayList<FileDTO>();
		IntStream.rangeClosed(101, 300).forEach(i -> {
			
			DiaryDTO diaryDTO = DiaryDTO.builder()
										.title("Title " + i)
										.content("Content " + i)
										.build();
			diaryList.add(diaryDTO);

		// 	FileDTO fileDTO = FileDTO.builder()
		// 								.fileName("fileName " + i)
		// 								.filePath("filePath " + i)
		// 								.build();
		// 	fileList.add(fileDTO);
		});
		
		diaryService.insertBatchData(diaryList);
		// fileSerivce.insertBatchData(fileList);
	}
}
