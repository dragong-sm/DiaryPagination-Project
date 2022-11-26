package com.spring.page.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.entity.Diary;

public interface DiaryService {
  
//  public DiaryDTO getDiary(Long diaryNo);
  public DiaryDTO getDiary(Long diaryNo);
  public PageResultDTO<DiaryDTO, Diary> getDiaryList(Pageable pageable);
  public Long insertDiary(DiaryDTO diaryDTO);
  public void updateDiary(Long diaryNo, DiaryDTO diaryDTO);
  public void deleteDiary(Long diaryNo);
  public void insertBatchData(List<DiaryDTO> diaryList);

}
