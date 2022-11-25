// 내용부분

import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

// 뒤로가기버튼(goBackBtn), 수정버튼(editBtn)

const Contents = ({ post, currentPage, postNo, setCurrentPost }) => {
  const [files, setFiles] = useState([]);

  // 무한루프 해결을 위해 useEffect 안에 넣어줌
  useEffect(() => {
    setFiles(post.fileDTO);
  }, [post]); // post값을 받아주어야함

  // console.log("files", files);
  // files ? files.map((file) => console.log(file)) : console.log("hi");

  return (
    <div>
      <h3>내용</h3>
      <div>{post.content}</div>
      {files ? ( // file이 있다면 이름/경로 출력 ! (map 에러 해결)
        <div>
          <h3> 파일목록 </h3>
          {files.map((file) => (
            <div key={file.no}>
              <div>
                <div>
                  {file.no} : {""} {/* 띄어쓰기 */}
                  {/* <a href={`${file.filePath}`} target="_blank"> */}
                  <a href={`http://localhost:8080/download?fileId=${file.no}`}>
                    {file.fileName}
                  </a>
                </div>
              </div>
            </div>
          ))}
        </div>
      ) : (
        <></>
      )}
      <hr></hr>
      <a href="http://localhost:3000/">
        <button>🏡 Home</button>
      </a>
      {/* <Link to="edit-post"> */}
      <a
        href={`http://localhost:3000/content/${currentPage}/${postNo}/edit-post`}
      >
        <button onClick={() => setCurrentPost(post)}>🔨 Edit</button>
      </a>
      {/* </Link> */}
    </div>
  );
};

export default Contents;
