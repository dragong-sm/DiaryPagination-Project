package com.spring.page.dto;

import java.time.LocalDateTime;

import com.spring.page.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiaryDTO {
	private Long no;
	private String title;
	private String content;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	
	// DTO -> Entity
	public Diary dtoToEntity(DiaryDTO diaryDTO) {
		Diary diary = Diary.builder()
							.title(diaryDTO.getTitle())
							.content(diaryDTO.getContent())
							.build();
		return diary;
	}
	
	
}
