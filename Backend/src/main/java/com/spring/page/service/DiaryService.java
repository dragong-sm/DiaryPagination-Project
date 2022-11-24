package com.spring.page.service;

import java.util.List;

import com.spring.page.common.dto.PageRequestDTO;
import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;

public interface DiaryService {
  
  public DiaryDTO getDiary(Long diaryNo);
  public PageResultDTO getDiaryList(PageRequestDTO requestDTO);
  public void deleteDiary(Long diaryNo);
  public void insertBatchData(List<DiaryDTO> diaryList);

}
