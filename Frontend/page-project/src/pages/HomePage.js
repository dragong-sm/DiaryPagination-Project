// 메인 페이지

import React from "react";
// import styled from "styled-components";
import Pagination from "../components/Pagination";
import Posts from "../components/Posts";

function HomePage() {
  return (
    <div>
      <h1>Site Name - HomePage</h1>
      <Posts></Posts>
      <Pagination></Pagination>
    </div>
  );
}

export default HomePage;
