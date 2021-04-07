import React from "react";
import Main from "./Main";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { StateProvider } from "./state/StateProvider";
import reducer, { initalState } from "./reducer/reducer";
import reportWebVitals from "./reportWebVitals";

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <StateProvider initalState={initalState} reducer={reducer}>
        <Main />
      </StateProvider>
    </BrowserRouter>
  </React.StrictMode>,

  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
