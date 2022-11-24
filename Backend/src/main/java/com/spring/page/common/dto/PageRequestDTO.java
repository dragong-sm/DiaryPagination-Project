package com.spring.page.common.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
		//PageRequest: contains the information to request a specific page. -> request is then passed to the Pageable interface.
		//Pageable: interface to encapsulate pagination information.
		//Pagination : the process of dividing a document into discrete pages, either electronic pages or printed pages.

	// 화면에서 전달되는 page, size
	private int page;
	private int size;
	
	public PageRequestDTO(page, size) {
		this.page = page;
		this.size = size;
	}
	
	public Pageable getPageable() {
		return PageRequest.of(page - 1, size); //create pageRequest with page and size (page starts from 0)
	}
	
}
