import React from "react";
import {Container, Row , Col, Navbar} from "react-bootstrap"

const Header = () => {
  return (
<Navbar bg="dark" variant="dark">
  <Navbar.Brand href="#home">Navbar with text</Navbar.Brand>
  <Navbar.Toggle />
  <Navbar.Collapse className="justify-content-end">
    <Navbar.Text>
      Signed in as: <a href="#login">user</a>
    </Navbar.Text>
  </Navbar.Collapse>
</Navbar>
  );
};

export default Header;
