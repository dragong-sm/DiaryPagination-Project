import logo from "./logo.svg";
import "./App.css";
import HomePage from "./pages/HomePage";
import ContentPage from "./pages/ContentPage";

function App() {
  // 다이어리 불러오기 : getDiarys()

  return (
    <div className="App">
      <HomePage />
      <ContentPage />
    </div>
  );
}

export default App;
