// 내용부분

import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

// 뒤로가기버튼(goBackBtn), 수정버튼(editBtn)

const Contents = ({ contents, currentPage, postNo }) => {
  // console.log(contents);
  return (
    <div>
      <h3>내용</h3>
      <div>{contents}</div>
      <hr></hr>
      <a href="http://localhost:3000/">
        <button>🏡 Home</button>
      </a>
      <Link to={`/edit/${currentPage}/${postNo}`}>
        <button>🔨 Edit</button>
      </Link>
    </div>
  );
};

export default Contents;
