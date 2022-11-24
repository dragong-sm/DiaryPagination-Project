// 메인 페이지

/*
    1. 페이지당 출력 개수(10) postsPerPage
    2. indexOfLastPage
    3. indexOfFirstPage
    4. currentPage
  */

// import styled from "styled-components";
import React, { useEffect, useState } from "react";
import Pagination from "../components/Pagination";
import Posts from "../components/Posts";

const HomePage = ({
  posts,
  currentPage,
  postsPerPage,
  setCurrentPage,
  setPostsPerPage,
}) => {
  return (
    <div>
      <h1>Site Name - HomePage</h1>
      <Posts
        posts={posts}
        currentPage={currentPage}
        postsPerPage={postsPerPage}
      ></Posts>
      <Pagination
        posts={posts}
        postsPerPage={postsPerPage}
        setCurrentPage={setCurrentPage}
        setPostsPerPage={setPostsPerPage}
      ></Pagination>
    </div>
  );
};

export default HomePage;
