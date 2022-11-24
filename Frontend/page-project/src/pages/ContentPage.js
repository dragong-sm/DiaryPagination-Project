// 콘텐츠 페이지

import React from "react";
import styled from "styled-components";
import Article from "../components/Article";
import Contents from "../components/Contents";

function ContentPage({ posts }) {
  console.log(posts);
  return (
    <div>
      <h1>Site Name - ContentPage</h1>
      <ul>
        {/* {posts.map((post) => (
          <li key={post.no}>
            {post.no} : {post.title}
            <Article titles={post.title}></Article>
            <Contents contents={post.content}></Contents>
          </li>
        ))} */}
      </ul>
    </div>
  );
}

export default ContentPage;
