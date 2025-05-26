import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "/node_modules/bootstrap/dist/js/bootstrap.min.js";
import React from "react";
import Home from "./Home";
import StudentsView from "./components/student/StudentsView";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NavBar from "./common/NavBar";

export default function App() {
  return (
    <main className="container mt-2">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/view-students" element={<StudentsView />} />
        </Routes>
      </Router>
    </main>
  );
}
