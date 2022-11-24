// home 화면 게시글목록부분

// 한페이지에 표시할 게시글 수 : 10개
// 번호, 제목, 수정일시

// 할일: onClick으로 객체 전달
// dtoList에서 넘버 하나씩 자르기
import styled from "styled-components";
import React, { useEffect } from "react";
import ErrorPage from "../pages/ErrorPage";

const Posts = ({ data, currentPage, postsPerPage }) => {
  // 게시글리스트 : dtoList
  const posts = data.dtoList;

  // console.log("home : currentPage : " + currentPage);

  return (
    <div>
      <ul>
        {/* 게시글(post이 존재한다면? */}
        {posts ? (
          posts.map((post) => (
            <li key={post.no}>
              <p>{post.no}</p>
              <a
                id="link"
                href={`http://localhost:3001/content/${currentPage}/${post.no}`}
                // curretPage 가 어디인지도 파라미터로 넘어와야 데이터가 제대로 넘겨지는 것 같아요 !
                // 근데 아직 contentPage에서 pageNo가 undefined로 뜨는걸 해결을 못해서 .. 고민이 필요..
              >
                {/* post.no를 파라미터로 전달하여 해당 게시글의 내용만 불러올 수 있도록 link 설정 */}
                {post.title} - {post.modifiedDate}
              </a>
            </li>
          ))
        ) : (
          <></>
        )}
      </ul>
    </div>
  );
};

export default Posts;
