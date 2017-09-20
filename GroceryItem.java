class GroceryItem {
  String name;
  int quantity;
  boolean isBought = false;
  
  GroceryItem(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }
  
  void addQuantity(int quantity) {
    this.quantity += quantity;
  }
  
  public String toString() {
    if (isBought) {
      return "[x] " + this.name + " " + this.quantity; 
    } else {
      return "[ ] " + this.name + " " + this.quantity;
    }
  }
  
  public boolean equals(Object o) {
    if (o instanceof GroceryItem) {
      GroceryItem that = (GroceryItem) o;
      
      return this.name.equals(that.name);
      
    } else {
      return false;
    }
  }
 
}