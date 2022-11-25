package com.spring.page.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.page.service.FileServiceImpl;

@CrossOrigin({"*"})
@RestController
public class FileController {
	
	@Autowired
	FileServiceImpl fileService;
	
	// file id를 받아서 그에 맞는 경로를 불러와서 다운로드를 할 수 있게
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam Long fileId){
		String url = fileService.getUrl(fileId);
		Path path = Paths.get(url);
		Resource resource = null;
		try {
			resource = new InputStreamResource(Files.newInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileService.getFileName(fileId)).build());
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	
	
	
	
}
