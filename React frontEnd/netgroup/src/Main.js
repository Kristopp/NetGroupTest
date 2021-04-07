import React from "react";
import { Link, Route, BrowserRouter as Router, Switch } from "react-router-dom";
import Login from "./Components/Layout/Login";
import Home from "./Components/Layout/Home";
import Products from "./Components/Layout/Products";
import Header from "./Components/Layout/Header"
import "bootstrap/dist/css/bootstrap.min.css";


function Main() {
  return (
    <main>
      <Router>
        <Header />
        <Route path="/" component={Home}></Route>
        <Route path="/login" component={Login}></Route>
        <Route path="/inventory" component={Products}></Route>
      </Router>
    </main>
  );
}

export default Main;
