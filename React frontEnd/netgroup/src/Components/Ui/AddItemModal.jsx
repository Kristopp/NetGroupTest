import React, { useRef, useState } from "react";
import { Modal, Button, InputGroup, FormControl } from "react-bootstrap";
const AddItemModal = (props) => {
  const nodeRef = useRef(null)

  const [newItem, setNewItem] = useState({
    name: "",
    serial: 0,
    quantity: 0,
    description: "",
  });

  const handleChange = (e) => {
    setNewItem({
      ...newItem,
      [e.target.name]: e.target.value,
    });
    console.log(newItem)
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    alert("You have submitted the form.");
  };

  return (
    <Modal {...props} ref={nodeRef} size="md" aria-labelledby="Create new Item" centered>
      <Modal.Header closeButton>
        <Modal.Title id="Create new Item">Create new Item</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <InputGroup className="mb-3">
          <InputGroup.Prepend >
            <InputGroup.Text id="inputGroup-sizing-sm">Name</InputGroup.Text>
          </InputGroup.Prepend>
          <FormControl
            name="name"
            onChange={handleChange}
            value={newItem.name}
            aria-label="Small"
            aria-describedby="inputGroup-sizing-sm"
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Prepend>
            <InputGroup.Text id="inputGroup-sizing-sm">serial</InputGroup.Text>
          </InputGroup.Prepend>
          <FormControl
            name="serial"
            value={newItem.serial}
            type="number"
            onChange={handleChange}
            aria-label="Small"
            aria-describedby="inputGroup-sizing-sm"
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <InputGroup.Prepend>
            <InputGroup.Text id="inputGroup-sizing-sm">
              quantity
            </InputGroup.Text>
          </InputGroup.Prepend>
          <FormControl
            name="quantity"
            value={newItem.quantity}
            onChange={handleChange}
            type="number"
            aria-label="Small"
            aria-describedby="inputGroup-sizing-sm"
          />
        </InputGroup>
        <InputGroup
        >
          <InputGroup.Prepend>
            <InputGroup.Text id="inputGroup-sizing-sm">
              description
            </InputGroup.Text>
          </InputGroup.Prepend>
          <FormControl
            name="description"
            value={newItem.description}
            onChange={handleChange}
            aria-label="Small"
            aria-describedby="inputGroup-sizing-sm"
          />
        </InputGroup>
      </Modal.Body>
      <Modal.Footer>
          <Button variant="success" onClick={handleSubmit}>Add</Button>
        <Button onClick={props.onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  );
};

export default AddItemModal;
