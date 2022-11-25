import React, { useEffect, useState } from "react";
import { insertDiary } from "../api/insertDiary";

function InsertPage() {
  const [diary, insertDiary] = useState({
    title: "",
    content: "",
  });

  const { title, content } = diary;
  const addDiary = (e) => {
    const { name, value } = e.target;
    console.log(name, value);
    useEffect(() => {
      insertDiary({
        ...diary,
        [name]: value,
      });
    }, []);
  };

  return (
    <div>
      <h1>Site Name - InsertPage</h1>

      <div>
        {/* 제목 */}
        <input
          type="text"
          placeholder="title"
          onChange={addDiary}
          value={title}
        ></input>
        <br />
        {/* 내용 */}
        <input
          type="text"
          placeholder="content"
          onChange={addDiary}
          value={content}
        ></input>
        <br />
        {/* 파일첨부 */}
        <form action="file-upload" method="post" encType="multipart/form-data">
          <input type="file" />
        </form>
        {/* 등록 */}
        <button
          type="submit"
          onClick={() => insertDiary({ title: "", content: "" })}
        >
          등록하기
        </button>
      </div>
    </div>
  );
}

export default InsertPage;
