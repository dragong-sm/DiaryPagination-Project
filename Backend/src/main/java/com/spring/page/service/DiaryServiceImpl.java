package com.spring.page.service;

public class DiaryServiceImpl {

  @Override
	public PageResultDTO getDiaryList(PageRequestDTO requestDTO) {
		Pageable pageable = requestDTO.getPageable();
		
		Page<Diary> result = diaryRepo.findAll(pageable);
		
		Function<Diary, DiaryDTO> fn = (diary -> diary.entityToDTO(diary));
		
		return new PageResultDTO<DiaryDTO, Diary>(result, fn);
	}
}
