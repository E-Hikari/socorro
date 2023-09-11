import React from "react";
import "./styles.css";
import { Route, Routes } from "react-router-dom";
import Projects from "./routes/Projects";
import Graph from "./routes/Graph";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Projects/>} />
        <Route path="/Graph" element={<Graph/>} />
      </Routes>
    </div>
  );
}

export default App;