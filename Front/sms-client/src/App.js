import React from "react";
import Home from "./Home";
import StudentsView from "./components/student/StudentsView";

export default function App() {
  return (
    <div>
      <h1>Welcome to Frontend page of this website </h1>
      <Home />
      <StudentsView />
    </div>
  );
}
