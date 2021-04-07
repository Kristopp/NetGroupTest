import React, { useState, useRef } from "react";
import Table from "react-bootstrap/Table";
import { css } from "@emotion/css";
import Container from "react-bootstrap/Container";
import NewLocation from "./NewLocation";
import Button from "react-bootstrap/Button";
import { useStateValue } from "../../state/StateProvider";
import AddItemModal from "./AddItemModal";
//This compomnent renders Inventory Location table

const buttonStyle = css`
  align-self: center;
`;

function ProductTable() {
  const [{ inventory }, dispatch] = useStateValue();
  const [modalShow, setModalShow] = useState(false);
  const nodeRef = useRef(modalShow);

  const openModal = (location) => {
    dispatch({
      type: "GET_INVENTORY_LOCATION",
      item: location,
    });
    setModalShow(true);
  };

  const renderTableData = inventory.map((item) => {
    return item.map((e) => {
      return (
        <tr key={e.id} className="d-flex">
          <td className="col-1">{e.id}</td>
          <td className="col-2">{e.name}</td>
          <td className="col-1">{e.parentId}</td>
          <td className="col-3">{e.createdBy}</td>
          <td className="col-3">{e.item}</td>
          <td className="col-1 w-50 mx-auto">
            <Button
              className="mx-auto"
              css={buttonStyle}
              variant="success"
              onClick={() => openModal(e)}
            >
              add
            </Button>
          </td>
          <td className="col-1 w-50 mx-auto">
            <Button
              className="mx-auto"
              css={buttonStyle}
              variant="light"
              size="sm"
              onClick={() => openModal(e)}
            >
              x
            </Button>
          </td>
        </tr>
      );
    });
  });
  return (
    <Container>
      <h2>Location List</h2>
      <NewLocation />
      <Table striped bordered hover size="sm" ref={nodeRef}>
        <thead>
          <tr className="d-flex">
            <th className="col-1">ID</th>
            <th className="col-2">Location Name</th>
            <th className="col-1">category</th>
            <th className="col-3">Created by</th>
            <th className="col-3">item</th>
            <th className="col-2">add/delete</th>
          </tr>
        </thead>
        <tbody>{renderTableData}</tbody>
      </Table>
      <AddItemModal show={modalShow} onHide={() => setModalShow(false)} />
    </Container>
  );
}

export default ProductTable;
