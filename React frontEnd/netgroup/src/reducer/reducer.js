export const initalState = {
  inventory: [],
  user: null,
  newItem: {
    name: "",
    serial: 0,
    quantity: 0,
    description: "",
  },
};

//Selector

const reducer = (state, action) => {
  switch (action.type) {
    case "CREATE_INVENTORY":
      console.log(action.item);
      return {
        ...state,
        inventory: [...state.inventory, action.item],
      };

    case "CREATE_NEW_ITEM":
      console.log(action.item);
      return {
        ...state,
        newItem: action.user,
      };
    default:
      return state;
  }
};
console.log(initalState.user);

export default reducer;
