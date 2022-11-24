// 내용부분
// 뒤로가기버튼(goBackBtn), 수정버튼(editBtn)

import React from "react";
import styled from "styled-components";

const Contents = (contents) => {
  console.log(contents);
  return (
    <div>
      <h3>내용</h3>
      {/* {contents} */}
      <button>수정</button>
    </div>
  );
};

export default Contents;
