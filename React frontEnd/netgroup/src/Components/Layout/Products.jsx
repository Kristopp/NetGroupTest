import React, { useState, useEffect } from "react";
import { useStateValue } from "../../state/StateProvider";
import ProductTable from "./../Ui/ProductTable";

const Products = () => {
  const [state, dispatch] = useStateValue();
  useEffect(() => {
    //getProducts data from backend
    fetch("http://localhost:7000//inventory/all")
      .then((response) => response.json())
      .then((data) =>
        dispatch({
          type: "CREATE_INVENTORY",
          item: data,
        })
      );
  }, []);

  return (
    <div>
      <ProductTable />
      hello
    </div>
  );
};

export default Products;
