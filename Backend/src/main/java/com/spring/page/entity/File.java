package com.spring.page.entity;

import java.util.UUID;

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
@ToString(exclude = "diary")
@Builder
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_no", nullable = false)
	private Long no;
	
	@ManyToOne(fetch = FetchType.LAZY) // 하나의 Diary에는 여러개의 File이 들어갈 수 있음, diary를 호출할때만 diary를 불러올 수 있게 LAZY 설정
	@JoinColumn(name = "diary_no") // 부모 컬럼을 자식 엔티티에서 어떤 이름으로 설정하여 보여줄 것 인지
	private Diary diary;
	
	private String originalFileName;
	private String fileName;
	private String filePath;
	
	public void updateDiary(Diary diary) {
		this.diary = diary;
	}
	
	public FileDTO entityToDTO(File file) {
		FileDTO fileDTO = FileDTO.builder()
								.no(file.getNo())
								.originalFileName(file.getOriginalFileName() + " / UUID = " + UUID.randomUUID().toString())
								.fileName(file.getFileName())
								.filePath(file.getFilePath())
								.build();
		return fileDTO;
	}
	
}
