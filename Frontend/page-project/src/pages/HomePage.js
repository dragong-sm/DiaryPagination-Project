// 메인 페이지

// import styled from "styled-components";
import React from "react";
import { Link } from "react-router-dom";
import Pagination from "../components/Pagination";
import Posts from "../components/Posts";
import InsertPage from "./InsertPage";

/*
    1. 페이지당 출력 개수(10) postsPerPage
    2. indexOfLastPage
    3. indexOfFirstPage
    4. currentPage
  */

const HomePage = ({
  data,
  currentPage,
  postsPerPage,
  setCurrentPage,
  setPostsPerPage,
}) => {
  return (
    <div>
      <h1>Site Name - HomePage</h1>
      {/* 게시글목록 : posts */}
      {/* posts */}
      <Link to="/insert">
        <button>등록하기</button>
      </Link>
      <Posts
        data={data}
        currentPage={currentPage}
        postsPerPage={postsPerPage}
      ></Posts>
      {/* 페이지이동바(페이지네이션) : Pagination */}
      <Pagination
        data={data}
        postsPerPage={postsPerPage}
        setCurrentPage={setCurrentPage}
        setPostsPerPage={setPostsPerPage}
      ></Pagination>
    </div>
  );
};

export default HomePage;
