// 콘텐츠 페이지

import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import Article from "../components/Article";
import Contents from "../components/Contents";
import ErrorPage from "./ErrorPage";

function ContentPage({ posts }) {
  console.log(posts);

  const { pageNo, postNo } = useParams();
  // console.log(typeof parseInt(postNo));
  console.log("pageNo" + pageNo); // 왜 .. undefined로 뜰까 .. 해결하자
  console.log("postNo" + postNo);

  return (
    <div>
      <h1>Site Name - ContentPage</h1>
      <ul>
        {/* posts 값이 있다면 풀어주고 아니라면 ErrorPage*/}
        {posts ? (
          posts.map((post) => (
            <div key={post.no}>
              {/* postNo(파라미터)값이 post.no 와 같다면 content 보여주고 아니라면 Errorpage */}
              {/* postNo는 String 타입이므로 parseInt를 이용해 number 타입으로 변경 */}
              {post.no === parseInt(postNo) ? (
                <div>
                  {/* <h1>true : {post.no}</h1> */} {/* testCode */}
                  <Article post={post}></Article>
                  <Contents contents={post.content}></Contents>
                </div>
              ) : (
                <>
                  {/* <h4>false : {post.no}</h4> */}
                  <></>
                </>
              )}
            </div>
          ))
        ) : (
          <></>
        )}
      </ul>
    </div>
  );
}

export default ContentPage;
