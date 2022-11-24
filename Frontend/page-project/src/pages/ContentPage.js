// 콘텐츠 페이지

import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import Article from "../components/Article";
import Contents from "../components/Contents";
import ErrorPage from "./ErrorPage";

function ContentPage({ posts }) {
  console.log(posts);

  const { postNo } = useParams();
  console.log(typeof parseInt(postNo));

  return (
    <div>
      <h1>Site Name - ContentPage</h1>
      <ul>
        {posts ? (
          posts.map((post) => (
            <div key={post.no}>
              {post.no === parseInt(postNo) ? (
                <div>
                  {/* <h1>true : {post.no}</h1> */}
                  <Article post={post}></Article>
                  <Contents contents={post.content}></Contents>
                </div>
              ) : (
                <>{/* <h4>false : {post.no}</h4> */}</>
              )}
            </div>
          ))
        ) : (
          <></>
        )}
      </ul>
      {/* <ul>
        {posts ? (
          posts.map((post) => (
            <div key={post.no}>
              <Article post={post}></Article>
              <Contents contents={post.content}></Contents>
            </div>
          ))
        ) : (
          <>
            <ErrorPage></ErrorPage>
          </>
        )}
      </ul> */}
    </div>
  );
}

export default ContentPage;
