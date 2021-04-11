//Here is global data that gets passed around comopnents

export const initalState = {
  inventory: [],
  itemList: [],
  user: null,
  locationAadress: {},
  items: [],
  //This is for passing clicked loaction object into added item 
  clickedLocation: {}
};

const reducer = (state, action) => {
  switch (action.type) {
    //creates invenotry list
    case "CREATE_INVENTORY":
      console.log(action.item)
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
    case "CREATE_ITEM_LIST":
      return {
        ...state,
        itemList: action.item,
      };
    case "CREATE_NEW_ITEM":
      return {
        ...state,
        newItem: action.item,
      };
    case "ADD_ITEM_INTO_INVENTORY_LOCATION":
      console.log(action.item)
      return {
        ...state,
        itemList: [],
      };
      //to pass clicked location object around where needed
      case "CLICKED_LOCATION_ADDRESS":
        console.log(action.item)
      return {
        ...state,
        locationAadress: action.item,
      };
    default:
      return state;
  }
};

export default reducer;
