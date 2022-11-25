package com.spring.page.dto;


import com.spring.page.entity.File;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDTO {
	private Long no;
	private String originalFileName;
	private String fileName;
	private String filePath;
	
	// DTO -> Entity
	public static File dtoToEntity(FileDTO fileDTO) {
		File file = File.builder()
						.no(fileDTO.getNo())
						.originalFileName(fileDTO.getOriginalFileName())
						.fileName(fileDTO.getFileName())
						.filePath(fileDTO.getFilePath())
						.build();
		return file;
	}					

}
