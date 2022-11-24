package com.spring.page.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.page.common.dto.PageRequestDTO;
import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.entity.Diary;
import com.spring.page.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	DiaryRepository diaryRepository;


	@Override
	public DiaryDTO getDiary(Long diaryNo) {
		Optional<Diary> diary = diaryRepository.findById(diaryNo);
		if (diary.isPresent()) {
			return Diary.entityToDTO(diary.get());
		} else {
			//다이어리가 존재하지 않는다는 에러처리!
			return null;
		}
	}

  @Override
	public PageResultDTO getDiaryList(PageRequestDTO requestDTO) {
		Pageable pageable = requestDTO.getPageable();
		
		Page<Diary> result = diaryRepository.findAll(pageable);

		Function<Diary, DiaryDTO> fn = (diary -> Diary.entityToDTO(diary));
		
		return new PageResultDTO<DiaryDTO, Diary>(result, fn);
	}


	@Override
	public void insertBatchData(List<DiaryDTO> diaryList) {
		
		List<Diary> entities = diaryList.stream()
										.map(diaryDTO -> diaryDTO.dtoToEntity(diaryDTO))
										.collect(Collectors.toList());
		
		diaryRepository.saveAll(entities);
	}


}
