// 다이어리불러오기

import axios from "axios";
import { useEffect, useState } from "react";

// currentPage : 현재 page
// postPerPage : 표시 게시글 수
// setData : response.data
export const getDiarys = async ({ currentPage, postsPerPage, setData }) => {
  console.log(currentPage);
  console.log(postsPerPage);

  // requestParams 설정
  // const requestParams = { };

  // Test용
  const response = await axios.get(
    `http://localhost:8080/page?page=${currentPage}&size=${postsPerPage}` // requestParams로 변경필요!
  );

  // requestParams 사용한 변경
  // const response = await axios.get({"",params: requestParams,});

  setData(response.data);
};
