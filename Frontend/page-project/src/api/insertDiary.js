import axios from "axios";
import { useEffect, useState } from "react";

export const insertDiary = async ({}) => {
  const request = await axios.post("http://localhost:8080/diary/");
};
