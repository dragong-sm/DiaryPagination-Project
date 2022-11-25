// 다이어리불러오기

import axios from "axios";
import { useEffect, useState } from "react";

export const getDiary = async ({ postNo, setPost }) => {
  // Test용
  const response = await axios.get(
    `http://localhost:8080/diary/${postNo}` // requestParams로 변경필요!
  );

  // requestParams 사용한 변경
  // const response = await axios.get({"",params: requestParams,});

  setPost(response.data);
};
