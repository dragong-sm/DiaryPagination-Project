// 내용부분
// 뒤로가기버튼(goBackBtn), 수정버튼(editBtn)

import React from "react";
import styled from "styled-components";

const Contents = ({ contents }) => {
  // console.log(contents);
  return (
    <div>
      <h3>내용</h3>
      <div>{contents}</div>
      <hr></hr>
      <a href="http://localhost:3001/">
        <button>🏡 Home</button>
      </a>
      <button>🔨 Edit</button>
    </div>
  );
};

export default Contents;
