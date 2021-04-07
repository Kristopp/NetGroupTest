import React, { useState, useRef } from "react";
import Table from "react-bootstrap/Table";
import Container from "react-bootstrap/Container";
import NewLocation from "./NewLocation";
import Button from "react-bootstrap/Button";
import { useStateValue } from "../../state/StateProvider";
import AddItemModal from "./AddItemModal";

function ProductTable() {
  const [{ inventory, user }, dispatch] = useStateValue();
  const [modalShow, setModalShow] = useState(false);
  const nodeRef = useRef(modalShow)

  console.log(modalShow);

  const renderTableData = inventory.map((item) => {
    return item.map((e) => {
      return (
        <tr key={e.id} className="d-flex">
          <td className="col-1">{e.id}</td>
          <td className="col-3">{e.name}</td>
          <td className="col-1">{e.parentId}</td>
          <td className="col-3">{e.createdBy}</td>
          <td className="col-4">
            phone
            <Button variant="success"  onClick={() => setModalShow(true)}>
              add new item
            </Button>{" "}
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
            <th className="col-3">Location Name</th>
            <th className="col-1">category id</th>
            <th className="col-3">Created by</th>
            <th className="col-4">item</th>
          </tr>
        </thead>
        <tbody>{renderTableData}</tbody>
      </Table>
      <AddItemModal show={modalShow} onHide={() => setModalShow(false)}/>
    </Container>
  );
}

export default ProductTable;
