//Here is global data that gets passed around comopnents

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

const reducer = (state, action) => {
  switch (action.type) {
    case "CREATE_INVENTORY":
      return {
        ...state,
        inventory: [...state.inventory, action.item],
      };
    case "CREATE_NEW_LOCATION":
      console.log(action.item);
      let newCopy = state.inventory[0].slice().concat(action.item);
      return {
        ...state,
        inventory: [newCopy],
      };
    //Get location by Id
    case "GET_INVENTORY_LOCATION":
      return {
        ...state,
        locationAadress: action.item,
      };
    case "DELETE_LOCATION":
      console.log(action.item);
      let deletedArray = state.inventory[0].filter((x, i) => i !== action.item);
      return {
        ...state,
        inventory: [deletedArray],
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
