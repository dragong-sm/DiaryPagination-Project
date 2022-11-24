package com.spring.page.controller;

public class DiaryController {
  @GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		return diaryService.getDiary(diaryNo);
	}

	@GetMapping("/diary") //method for getting diary list
	public PageResultDTO getDiaryList(@RequestParam("size") int size, @RequestParam("page") int page) {
		PageRequestDTO pageRequestDTO = new PageRequestDTO(page, size); //파라미터를 받아서 Service에 넘겨주기 위한 PageRequestDTO 생성
		return diaryService.getDiaryList(pageRequestDTO);
	}
}
