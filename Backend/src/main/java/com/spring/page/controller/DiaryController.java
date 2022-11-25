package com.spring.page.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	//
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	

	@Autowired
	DiaryServiceImpl diaryService;
	
	@Autowired
	FileServiceImpl fileService;
	
	//1. Diary 번호로 조회
	@GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		logger.info("getDiary() 호출됨. diaryNo : {} ", diaryNo);
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

	//Exception 테스트용 메소드
	@GetMapping("/diary/error")
	public void error() {
		throw new RuntimeException("Test Exception");
	}

	//Exception Handling
@ExceptionHandler(RuntimeException.class)
public String handleRuntimeException(RuntimeException e) {
	logger.error("RuntimeException : {}", e.getMessage());
	return "error";
}
}
