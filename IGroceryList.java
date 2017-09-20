interface IGroceryList {
  boolean add(GroceryItem item);
  
  boolean remove(String name);
  
  boolean markAsBought(String name);
  
  void display();
}