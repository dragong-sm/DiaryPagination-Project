import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import { updateDiary } from "../api/updateDiary";

function EditPage({}) {
  const { currentPage, postNo } = useParams();
  // console.log(currentPage, postNo);

  useEffect(() => {
    updateDiary({ postNo }); // api 사용
  }, []);

  return (
    <div>
      <h1>Site Name - EditPage</h1>
    </div>
  );
}

export default EditPage;
