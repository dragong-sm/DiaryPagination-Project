// 콘텐츠 제목부분

import React from "react";
import styled from "styled-components";

// 제목 + 날짜표시
// 작성일시(writtenDate), 수정일시(modifiedDate) 둘 다 표시

const Article = ({ post }) => {
  // console.log(post.title);
  // console.log(post.createdDate.slice(0, 10));
  // console.log(post.modifiedDate.slice(0, 10));
  return (
    <div>
      <h2>제목 : {post.title}</h2>
      <p> 작성일시 : {post.createdDate}</p>
      <p> 수정일시 : {post.modifiedDate}</p>
    </div>
  );
};

export default Article;
