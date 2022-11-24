package com.spring.page.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileDTO {
	private String originalFileName;
	private String fileName;
	private String filePath;
	
	// DTO -> Entity
	public File dtoToEntity(FileDTO fileDTO) {
		File file = File.builder()
						.originalFileName(fileDTO.getOriginalFileName())
						.fileName(fileDTO.getFileName())
						.filePath(fileDTO.getFilePath())
						.build();
		return file;
	}					

}
