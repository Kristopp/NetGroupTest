//Here is global data that gets passed around comopnents

export const initalState = {
  inventory: [],
  itemList: [],
  user: null,
  locationAadress: {},
  items: []
};

const reducer = (state, action) => {
  switch (action.type) {
    case "CREATE_INVENTORY":
      return {
        ...state,
        inventory: [...state.inventory, action.item],
      };
    case "CREATE_NEW_LOCATION":
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
    case "ADD_ITEM_INTO_INVENTORY":
      let newIitemListCopy = state.itemList[0].slice().concat(action.item);
      return {
        ...state,
        itemList: [newIitemListCopy],
      };
    default:
      return state;
  }
};

export default reducer;
