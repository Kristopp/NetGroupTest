import React, { useState } from "react";
import { useStateValue } from "../../state/StateProvider";
import InputGroup from "react-bootstrap/InputGroup";
import Dropdown from "react-bootstrap/Dropdown";
import FormControl from "react-bootstrap/FormControl";
import DropdownButton from "react-bootstrap/DropdownButton";
import Button from "react-bootstrap/Button";

const NewLocation = () => {
  const [{ inventory, itemList }, dispatch] = useStateValue();
  const [dropDownvalue, SetDropDownValue] = useState(0);
  const [newLocation, setNewLocation] = useState({
    uniqueKey: 0,
    id: 0,
    name: "",
    createdBy: "kristo",
    parentId: 0,
    items: [],
  });

  const handleChange = (e) => {
    setNewLocation({
      ...newLocation,
      [e.target.name]: e.target.value,
    });
  };

  const addItemIntoLocation = (inventory, itemList) => {
    if (inventory.length === 0) {
      return (inventory = []);
    } else {
     inventory.map((location, locationIndex) => {
        itemList.map((itemL, itemLIndex) => {
          location[locationIndex].items = [];
          if (
            itemList.location ||
            itemList.locationCategory === location.name ||
            location.parentId
          ) {
            location[locationIndex].items = [itemList[itemLIndex]];
          }
        });
      });
    }
  };
  console.log(addItemIntoLocation(inventory, itemList));

  const handleDropDownClick = (id) => {
    parseInt(SetDropDownValue(id));
  };
  //Add new Location into database
  const handleSubmit = (event) => {
    event.preventDefault();
    setNewLocation({ ...newLocation, parentId: dropDownvalue });
    let { id, name, createdBy, parentId } = newLocation;
    fetch("http://localhost:7000/inventory/add", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },

      body: JSON.stringify({ id, name, createdBy, parentId }),
    })
      .then((response) => response.json())
      .then((responseJson) => {
        //Showing response message coming from server
        dispatch({
          type: "CREATE_NEW_LOCATION",
          item: newLocation,
        });
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
        title={dropDownvalue}
        onSelect={handleDropDownClick}
      >
        {inventory.map((e) => {
          return e.map((f) => {
            return (
              <Dropdown.Item key={f.uniqueKey} eventKey={f.id}>
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
