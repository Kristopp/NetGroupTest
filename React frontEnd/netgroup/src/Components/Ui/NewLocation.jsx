import React from "react";
import InputGroup from "react-bootstrap/InputGroup";
import Dropdown from "react-bootstrap/Dropdown";
import FormControl from "react-bootstrap/FormControl";
import DropdownButton from "react-bootstrap/DropdownButton";
import Button from "react-bootstrap/Button";

const NewLocation = () => {
  //
  return (
      <InputGroup>
        <FormControl
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
        <Button variant="outline-secondary">Create location</Button>
      </InputGroup>
  );
};

export default NewLocation;
