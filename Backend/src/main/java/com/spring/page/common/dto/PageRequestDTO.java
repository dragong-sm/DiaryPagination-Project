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

	// 화면에서 전달되는 page, size
	private int page;
	private int size;
	
	public Pageable getPageable() {
		return PageRequest.of(page - 1, size);
	}
}
