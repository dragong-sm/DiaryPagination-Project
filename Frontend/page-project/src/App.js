import logo from "./logo.svg";
import "./App.css";
import HomePage from "./pages/HomePage";
import ContentPage from "./pages/ContentPage";
import ErrorPage from "./pages/ErrorPage";
import { Route, Router, Routes } from "react-router-dom";
import { useEffect, useState } from "react";
import { getDiarys } from "./api/getDiarys";
import axios from "axios";

function App() {
  const [data, setData] = useState([]); // 불러온 data
  const [currentPage, setCurrentPage] = useState(1); // 현재 페이지
  const [postsPerPage, setPostsPerPage] = useState(5); // 한 페이지당 게시글 수

  // 다이어리 불러오기 : getDiarys(currentPage, postPerPage, setData)
  useEffect(() => {
    getDiarys({ currentPage, postsPerPage, setData }); // api 사용
  }, [currentPage]);

  // console.log(data);
  // console.log(data.dtoList);

  return (
    <div className="App">
      <Routes>
        {/* HomePage */}
        <Route
          path="/"
          element={
            <HomePage
              posts={data}
              currentPage={currentPage}
              postsPerPage={postsPerPage}
              setCurrentPage={setCurrentPage}
              setPostsPerPage={setPostsPerPage}
            />
          }
        />
        {/* ContentPage */}
        <Route
          path="/content/:postNo"
          element={<ContentPage posts={data.dtoList} />}
        />
        {/* ErrorPage */}
        <Route path="*" element={<ErrorPage />} />
      </Routes>
    </div>
  );
}

export default App;
