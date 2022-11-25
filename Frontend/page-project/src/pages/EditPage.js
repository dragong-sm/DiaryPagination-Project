import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";

function EditPage({}) {
  const { currentPage, postNo } = useParams();
  return (
    <div>
      <h1>Site Name - EditPage</h1>
    </div>
  );
}

export default EditPage;
