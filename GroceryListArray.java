class GroceryListArray implements IGroceryList {
  int max = 10;
  GroceryItem items[] = new GroceryItem[max];
  int size = 0;
  
  GroceryListArray() {}
  
  // GroceryItem -> boolean
  // Accepts this item to be added to the list
  // Returns true if this item is added, else false
  // public boolean add(GroceryItem item) {
  // return true
  // }
  public boolean add(GroceryItem item) {
    if (size == max) {
      int i = 0;
      max += 10;
      GroceryItem bigger[] = new GroceryItem[max];
      for(i = 0; i < items.length; i++){
        bigger[i] = items[i]; 
      }
      bigger[i + 1] = item;
      items = bigger;
    }
    int i = indexOf(item.name);
    if (i > -1) {
      items[i].addQuantity(item.quantity);
    } else {    
      items[this.size] = item;
      this.size++;
    }
    return true;
  }
  
   // TEMPLATE
  /*  Fields:
   *    this.max
   *    this.items   -- GroceryItem[]
   *    this.size
   * 
   *  Methods:
   *    this.add
   *    this.indexOf
   *    this.remove
   *    this.markAsBought
   *    this.display
   *    this.totalQuantity
   *    this.checkItemExistence
   *    this.reductionProcess
   *    this.reduceQuantity
   * 
   *  Methods on this.items[i]:
   *    this.items[i].addQuantity()
   *    this.items[i].equals()
   *    this.items[i].toString()
   */
  
   
  // String -> int
  // Given the name of a GroceryItem, returns the
  // Corresponding GroceryItem index from the list. If it is not in the list,
  // returns -1
  // int indexOf(String name) {
  // return -1;
  // }
  int indexOf(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(new GroceryItem(name, 0))) {
        return i;
      }
    }
    return -1;
  }
  
  // String -> boolean
  // Accepts the name of an item
  // Returns true if item is removed, else false
  // public boolean remove(String name) {
  //  return false;
  // }
  public boolean remove(String name) {
    int i = 0;
    boolean found = false;
    for(i = 0; i < this.size; i++){
      if(items[i].name.equals(name)){
        found = true;
        items[i] = items[size - 1];
        break;
      }
    }
    max--;
    this.size--;
    return found;
  }
  
  // String -> boolean
  // Accepts the name of an item and marks the item bought
  // Returns true if the item exists, else false
  // public boolean markAsBought(String name) {
  //  return false;
  // }
  public boolean markAsBought(String name) {
    boolean found = false;
    int i = indexOf(name);
    if( i >= 0){
      items[i].isBought = true;
      return true;
    }
    else 
      return false;
  }
  
  // -> int
  // Returns the total quantity of all items in the list
  // public int totalQuantity(){
  //  return 0;
  // }
  public int totalQuantity(){
    int sum = 0;
    for(int i = 0; i < this.size; i++){
      sum = items[i].quantity + sum;
    }
    return sum;
  }
  
  // String, int, int ->
  // Accepts the item's name, the item's index and the item's quantity
  // Checks the number of the item's quantity
  // If the quantity is 0, remove the item from the list
  // void checkItemExistence(String itemName, int index, int itemLeft){}
  void checkItemExistence(String itemName, int index, int itemLeft){
    if( itemLeft < 1) //checks if quantity is greater than zero else remove.
      remove(itemName); 
  }

  // String, int, int ->
  // Accepts the item's name, item's quantity and the item's index
  // Subtracts the original quantity of the item to the desired quantity for the item
  // Check the item's quantity number
  // void reductionProcess(String itemName, int quantity, int index){}
  void reductionProcess(String itemName, int quantity, int index){
    items[index].quantity -= quantity;   //reducing 
    checkItemExistence(itemName, index, items[index].quantity);
  }
  
  // String, int -> boolean
  // Accepts the item's name and the item's quantity
  // Returns true if the item's quantity was reduced, else return false
  // boolean reduceQuantity(String itemName, int quantity){
  // return false;
  // }
  boolean reduceQuantity(String itemName, int quantity){
    int index = indexOf(itemName);
    if(index >= 0){ // this means item is found in the list
      reductionProcess(itemName, quantity, index);
      return true;
    } else
      return false;
  }

  // ->
  // Displays the list of items
  // public void display() {}
  public void display() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(items[i]);
    }
  }
}
  