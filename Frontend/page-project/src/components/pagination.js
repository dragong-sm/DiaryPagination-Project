// index 부분 설정

// index size : 5
// 이전버튼(prevBtn), 다음버튼(nextBtn)

import React from "react";
import styled from "styled-components";

const PageUl = styled.ul`
  float: center;
  list-style: none;
  text-align: center;
  border-radius: 3px;
  color: white;
  padding: 1px;
  border-top: 3px solid #186ead;
  border-bottom: 3px solid #186ead;
  background-color: rgba(0, 0, 0, 0.4);
`;

const PageLi = styled.li`
  display: inline-block;
  font-size: 17px;
  font-weight: 600;
  padding: 5px;
  border-radius: 5px;
  width: 25px;
  &:hover {
    cursor: pointer;
    color: white;
    background-color: #263a6c;
  }
  &:focus::after {
    color: white;
    background-color: #263a6c;
  }
`;

const PageSpan = styled.span`
  &:hover::after,
  &:focus::after {
    border-radius: 100%;
    color: white;
    background-color: #263a6c;
  }
`;

const Pagination = ({ data, postsPerPage, setCurrentPage }) => {
  return (
    <div>
      <nav>
        <PageUl>
          {data.prev ? (
            // 이전버튼
            <PageLi onClick={() => setCurrentPage(data.start - 10)}>◀</PageLi>
          ) : (
            <></>
          )}
          {data.pageList ? (
            // 페이지번호 표시
            data.pageList.map((pageNumber) => (
              <PageLi key={pageNumber}>
                <PageSpan onClick={() => setCurrentPage(pageNumber)}>
                  {pageNumber}
                </PageSpan>
              </PageLi>
            ))
          ) : (
            <></>
          )}
          {data.next ? (
            // 다음버튼
            <PageLi onClick={() => setCurrentPage(data.start + 10)}>▶</PageLi>
          ) : (
            <></>
          )}
        </PageUl>
      </nav>
    </div>
  );
};

export default Pagination;
