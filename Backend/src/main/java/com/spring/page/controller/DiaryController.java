package com.spring.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.spring.page.common.dto.PageRequestDTO;
import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.service.DiaryServiceImpl;
import com.spring.page.service.FileServiceImpl;

@RestController
public class DiaryController {	
	
	@Autowired
	DiaryServiceImpl diaryService;
	
	@Autowired
	FileServiceImpl fileService;

	@GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		return diaryService.getDiary(diaryNo);
	}

	@GetMapping("/diary") //method for getting diary list
	public PageResultDTO getDiaryList(@RequestParam int size, @RequestParam int page) {
		PageRequestDTO pageRequestDTO = new PageRequestDTO(page, size); //파라미터를 받아서 Service에 넘겨주기 위한 PageRequestDTO 생성
		return diaryService.getDiaryList(pageRequestDTO);
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
}
