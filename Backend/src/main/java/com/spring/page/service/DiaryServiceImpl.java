package com.spring.page.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.entity.Diary;
import com.spring.page.repository.DiaryRepository;
import com.spring.page.repository.FileRepository;

@Service
public class DiaryServiceImpl implements DiaryService {
	
	@Autowired
	DiaryRepository diaryRepository;
	
	@Autowired
	FileRepository fileRepository;
	
	@Override
	public DiaryDTO getDiary(Long diaryNo) {
		Optional<Diary> diary = diaryRepository.findById(diaryNo);
		return Diary.entityToDTO(diary.get());
		}

	@Override
	public PageResultDTO<DiaryDTO, Diary> getDiaryList(Pageable pageable) {
		
		Page<Diary> result = diaryRepository.findAll(pageable);
		
		Function<Diary, DiaryDTO> fn = (diary -> Diary.entityToDTO(diary));
		
		return new PageResultDTO<DiaryDTO, Diary>(result, fn);
	}
	
	@Override
	public Long insertDiary(DiaryDTO diaryDTO) {
		Diary diary = diaryDTO.dtoToEntity(diaryDTO);
		return diaryRepository.save(diary).getNo();			
	}
	
	@Override
	public void updateDiary(Long diaryNo, DiaryDTO diaryDTO) {
		Diary diary = diaryRepository.getDiaryByNo(diaryNo);
		diary.updateDiary(diaryDTO);
		diaryRepository.flush();
	}
	
	@Override
	public void deleteDiary(Long diaryNo) {
		Diary diary = diaryRepository.getDiaryByNo(diaryNo);
		diaryRepository.delete(diary);
	}

	@Override
	public void insertBatchData(List<DiaryDTO> diaryList) {
		
		List<Diary> entities = diaryList.stream()
										.map(diaryDTO -> diaryDTO.dtoToEntity(diaryDTO))
										.collect(Collectors.toList());
		diaryRepository.saveAll(entities);
	}


}
