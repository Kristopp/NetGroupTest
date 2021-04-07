export const initalState = {
  inventory: [],
  user: null,
  locationAadress: {},
  newItemState: {
    name: "",
    location: "",
    location_category: 0,
    serial: 0,
    quantity: 0,
    description: "",
  },
};

//Selector

const reducer = (state, action) => {
  switch (action.type) {
    case "CREATE_INVENTORY":
      return {
        ...state,
        inventory: [...state.inventory, action.item],
      };
      case "GET_INVENTORY_LOCATION":
        console.log(action.item)
        return {
          ...state,
          locationAadress: action.item
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

export default reducer;
