package com.spring.page.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.page.dto.DiaryDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Diary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_no")
	private Long no;
	
	private String title;
	
	private String content;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime writtenDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	public void updateDiary(DiaryDTO diaryDTO) {
		this.title = diaryDTO.getTitle();
		this.content = diaryDTO.getContent();
	}
	
	// Entity -> DTO
	public static DiaryDTO entityToDTO(Diary diary) {
		DiaryDTO diaryDTO = DiaryDTO.builder()
									.no(diary.getNo())
									.title(diary.getTitle())
									.content(diary.getContent())
									.createdDate(diary.getWrittenDate())
									.modifiedDate(diary.getModifiedDate())
									.build();
		
		return diaryDTO;
	}

}
