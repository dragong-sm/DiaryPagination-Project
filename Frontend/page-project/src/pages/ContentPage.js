// 콘텐츠 페이지

import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import { getDiary } from "../api/getDiary";
import Article from "../components/Article";
import Contents from "../components/Contents";
import EditPage from "./EditPage";
import { Route, Router, Routes } from "react-router-dom";

function ContentPage({ setCurrentPost }) {
  const [post, setPost] = useState([]); // post 한개만 불러오기

  const { currentPage, postNo } = useParams(); // parameter
  // console.log(typeof parseInt(postNo));
  // console.log("currentPage: " + currentPage);
  // console.log("postNo : " + postNo);

  //  n번게시물(postNo) 불러오기 : getDiary(postNo, setPost)
  useEffect(() => {
    getDiary({ postNo, setPost }); // api 사용
  }, [currentPage]);

  console.log(post); // test

  return (
    <div>
      <h1>Site Name - ContentPage</h1>
      <ul>
        {post ? (
          <div>
            <Article post={post}></Article>
            <Contents
              post={post}
              currentPage={currentPage}
              postNo={postNo}
              setCurrentPost={setCurrentPost}
            ></Contents>
          </div>
        ) : (
          <></>
        )}
      </ul>
    </div>
  );
}

export default ContentPage;
