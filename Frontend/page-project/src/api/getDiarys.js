// 다이어리불러오기

import axios from "axios";

export const getDiarys = async ({ currentPage, postPerPage }) => {
  const response = await axios.get("", {
    params: {
      page: currentPage,
      perPage: postPerPage,
    },
  });
};
