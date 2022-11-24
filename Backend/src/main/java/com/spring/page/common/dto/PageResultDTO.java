package com.spring.page.common.dto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;

import com.spring.page.entity.Diary;

import lombok.Data;

@Data
public class PageResultDTO<DTO, EN> {
	// DTO 리스트
	private List<DTO> dtoList;
	
	// 총 페이지 번호
	private int totalPage;
	
	// 현재 페이지 번호
	private int page;
	
	// 페이지 목록 개수
	private int size;
	
	// 시작 페이지, 종료 페이지
	private int start, end;
	
	// 이전, 다음
	private boolean prev, next;
	
	// 페이지 출력 개수
	private List<Integer> pageList; // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 형태

	public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {   //외부에서 메서드 fn을 전달받아서 사용
		this.dtoList = result.stream()	//Entity로 이루어진 Page를 stream을 통해 DTO로 변환 -> List에 저장
							 .map(fn)
							 .collect(Collectors.toList());

		this.totalPage = result.getTotalPages();
		
		// 
		this.page = result.getPageable().getPageNumber() + 1;
		this.size = result.getPageable().getPageSize();
		
		int tempEnd = (int)(Math.ceil(page/10.0)) * 10;  //tempEnd : 해당 page가 속한 페이지 목록의 마지막 번호
		// 1~10, 11~20, 21~30, 31~40, 41~50, 51~60, 61~70, 71~80, 81~90, 91~100
		this.start = tempEnd - 9;
		
		this.prev = start > 1; //start가 1보다 크면 true, 1이면 false
		
		this.end = totalPage > tempEnd ? tempEnd : totalPage; //totalPage가 tempEnd보다 크면 tempEnd, 작으면 totalPage
				
		this.next = totalPage > tempEnd; //totalPage가 tempEnd보다 크면 true, 작으면 false -> 다음 버튼 활성화 여부
	
		this.pageList = IntStream.rangeClosed(this.start, this.end) //create a stream of int from start to end
											.boxed() //.boxed() : convert int to Integer
											.collect(Collectors.toList()); //collect to list
											//output is List<Integer>
	}
}
