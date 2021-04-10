import React, { useState } from "react";
import { useStateValue } from "../../state/StateProvider";
import InputGroup from "react-bootstrap/InputGroup";
import Dropdown from "react-bootstrap/Dropdown";
import FormControl from "react-bootstrap/FormControl";
import DropdownButton from "react-bootstrap/DropdownButton";
import Button from "react-bootstrap/Button";

const NewLocation = () => {
  const [{ inventory }, dispatch] = useStateValue();
  const [dropDownvalue, SetDropDownValue] = useState(0);
  const [newLocation, setNewLocation] = useState({
    id: 0,
    name: "",
    createdBy: "kristo",
    parrentId: dropDownvalue,
  });

  const handleChange = (e) => {
    setNewLocation({
      ...newLocation,
      [e.target.name]: e.target.value,
    });
  };

  const handleDropDownClick = (e) => {
    parseInt(SetDropDownValue(e)) 
  };
  //Add new Location into database
  const handleSubmit = (event) => {
    event.preventDefault();
    setNewLocation({ ...newLocation, parrentId: dropDownvalue });
    console.log(newLocation);
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
    <InputGroup className="mb-3">
      <InputGroup.Prepend>
        <InputGroup.Text>ID</InputGroup.Text>
      </InputGroup.Prepend>
      <FormControl
        name="id"
        type="number"
        onChange={handleChange}
        value={newLocation.id}
        placeholder="location ID"
        aria-label="location ID"
      />
      <FormControl
        name="name"
        type="text"
        onChange={handleChange}
        value={newLocation.name}
        placeholder="location name"
        aria-label="location name"
      />
      <DropdownButton
        as={InputGroup.Append}
        variant="outline-secondary"
        title="Add parrent id"
        onSelect={handleDropDownClick}
      >
        <Dropdown.Item href="#">ID: 0</Dropdown.Item>
        {inventory.map((e) => {
          return e.map((f) => {
            return (
              <Dropdown.Item key={f.id} eventKey={f.id}>
                ID:{" " + f.id}
              </Dropdown.Item>
            );
          });
        })}
      </DropdownButton>
      <Button variant="outline-secondary" onClick={handleSubmit}>
        Create location
      </Button>
    </InputGroup>
  );
};

export default NewLocation;
