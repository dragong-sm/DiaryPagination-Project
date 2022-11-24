import logo from "./logo.svg";
import "./App.css";
import HomePage from "./pages/HomePage";
import ContentPage from "./pages/ContentPage";
import { Route, Routes } from "react-router-dom";
import { useEffect, useState } from "react";
import { getDiarys } from "./api/getDiarys";
import axios from "axios";

function App() {
  // 다이어리 불러오기 : getDiarys()
  // useEffect(() => getDiarys(currentPage, postPerPage), []);

  const [posts, setPosts] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get(
        "http://localhost:8080/page?page=10&size=5"
      );
      setPosts(response.data);
    };
    fetchData();
  }, []);

  console.log(posts);

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route
          path="/content"
          element={<ContentPage posts={posts.dtoList} />}
        />
      </Routes>
    </div>
  );
}

export default App;
