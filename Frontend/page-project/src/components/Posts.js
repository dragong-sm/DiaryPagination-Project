// home 화면 게시글목록부분

// 한페이지에 표시할 게시글 수 : 10개
// 번호, 제목, 수정일시

// 할일: onClick으로 객체 전달
// dtoList에서 넘버 하나씩 자르기
import styled from "styled-components";
import React, { useEffect } from "react";

const Posts = ({ posts, currentPage, postsPerPage }) => {
  //
  return (
    <div>
      <ul>
        {posts.dtoList ? (
          posts.dtoList.map((post) => (
            <li key={post.no}>
              <p>{post.no}</p>
              <a id="link" href={`http://localhost:3001/content/${post.no}`}>
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
