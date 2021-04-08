import React, { useState } from "react";
import InputGroup from "react-bootstrap/InputGroup";
import Dropdown from "react-bootstrap/Dropdown";
import FormControl from "react-bootstrap/FormControl";
import DropdownButton from "react-bootstrap/DropdownButton";
import Button from "react-bootstrap/Button";

const NewLocation = () => {
  const [newLocation, setNewLocation] = useState({
    id: 0,
    name: "",
    createdBy: "kristo",
    parrentId: 0,
  });

  const handleChange = (e) => {
    setNewLocation({
      ...newLocation,
      [e.target.name]: e.target.value,
    });
    console.log(newLocation);
  };

  const handleSubmit = (event) => {
    console.log(newLocation);
    event.preventDefault();
    fetch("http://localhost:7000/inventory/add", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },

      body: JSON.stringify(newLocation),
    })
      .then((response) => response.json())
      .then((responseJson) => {
        //Showing response message coming from server
        console.warn(responseJson);
      })
      .catch((error) => {
        //display error message
        console.warn(error);
      });
  };
  //
  return (
    <InputGroup>
      <FormControl
        name="name"
        onChange={handleChange}
        value={newLocation.name}
        placeholder="location name"
        aria-label="Recipient's username"
        aria-describedby="basic-addon2"
      />
      <DropdownButton
        as={InputGroup.Append}
        variant="outline-secondary"
        title="Category"
        id="input-group-dropdown-2"
      >
        <Dropdown.Item href="#">Category</Dropdown.Item>
        <Dropdown.Divider />
        <Dropdown.Item href="#">Separated link</Dropdown.Item>
      </DropdownButton>
      <Button variant="outline-secondary" onClick={handleSubmit}>Create location</Button>
    </InputGroup>
  );
};

export default NewLocation;
