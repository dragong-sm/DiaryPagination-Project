import React, { useEffect, useState } from "react";
import { insertDiary } from "../api/insertDiary";

function InsertPage() {
  const [diary, setDiary] = useState([]);
  useEffect(() => {
    insertDiary({});
  }, []);

  return (
    <div>
      <h1>Site Name - InsertPage</h1>

      <div>
        {/* 제목 */}
        <input type="text" name={diary.title}></input> <br />
        {/* 내용 */}
        <input type="text" name={diary.content}></input> <br />
        {/* 파일첨부 */}
        <form action="file-upload" method="post" encType="multipart/form-data">
          <input type="file" />
        </form>
        {/* 등록 */}
        <button type="submit" onClick={insertDiary}>
          등록하기
        </button>
      </div>
    </div>
  );
}

export default InsertPage;
