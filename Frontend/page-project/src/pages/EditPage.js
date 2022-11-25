import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import { updateDiary } from "../api/updateDiary";

function EditPage({ currentPost }) {
  const { currentPage, postNo } = useParams();
  console.log(currentPage, postNo);

  useEffect(() => {
    updateDiary({ postNo }); // api 사용
  }, []);

  console.log(currentPost);

  return (
    <div>
      <h1>Site Name - EditPage</h1>
      {postNo}
      <div></div>
    </div>
  );
}

export default EditPage;
