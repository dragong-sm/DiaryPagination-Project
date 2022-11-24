package com.spring.page.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.page.dto.FileDTO;

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
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_no", nullable = false)
	private Long no;
	
	@ManyToOne(fetch = FetchType.LAZY) // 하나의 Diary에는 여러개의 File이 들어갈 수 있음 
	@JoinColumn(name = "diary_no")
	private Diary diary;
	
	private String originalFileName;
	private String fileName;
	private String filePath;
	
	public void updateDiary(Diary diary) {
		this.diary = diary;
	}
	
	public FileDTO entityToDTO(File file) {
		FileDTO fileDTO = FileDTO.builder()
								.originalFileName(file.getOriginalFileName())
								.fileName(file.getFileName())
								.filePath(file.getFilePath())
								.build();
		return fileDTO;
	}
	
}
