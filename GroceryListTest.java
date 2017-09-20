import junit.framework.TestCase;

public class GroceryListTest extends TestCase {
  GroceryListArray gla = new GroceryListArray();
    GroceryItem a = new GroceryItem("Milk", 1);
    GroceryItem b = new GroceryItem("Sugar", 2);
    GroceryItem c = new GroceryItem("Spice", 3);
    GroceryItem d = new GroceryItem ("Rice", 4);
    GroceryItem e = new GroceryItem("Meat", 5);
    GroceryItem f = new GroceryItem("Meat", 6);
    GroceryItem g = new GroceryItem("Potato", 7);
    GroceryItem h = new GroceryItem("Tomato", 8);
    GroceryItem i = new GroceryItem("Orange", 9);
    GroceryItem j = new GroceryItem("Apple", 10);
    GroceryItem k = new GroceryItem("Cabbage", 11);
    GroceryItem l = new GroceryItem("Carrot", 12);
    GroceryItem m = new GroceryItem("Soap", 13);
    GroceryItem n = new GroceryItem("Shampoo", 14);
   
  public void testAddLessThanTen() {
    assertTrue(gla.add(a));
    assertTrue(gla.add(b));
    assertTrue(gla.add(c));
    assertTrue(gla.add(d));
    assertTrue(gla.add(e));
    assertTrue(gla.add(f));
    assertTrue(gla.add(g));
    assertTrue(gla.add(h));
    assertTrue(gla.add(i));
    assertTrue(gla.add(j)); 
  }
  public void testAddLessExceedingArraySize(){
    assertTrue(gla.add(a));
    assertTrue(gla.add(b));
    assertTrue(gla.add(c));
    assertTrue(gla.add(d));
    assertTrue(gla.add(e));
    assertTrue(gla.add(f));
    assertTrue(gla.add(g));
    assertTrue(gla.add(h));
    assertTrue(gla.add(i));
    assertTrue(gla.add(j)); 
    assertTrue(gla.add(k));
    assertTrue(gla.add(l));
    assertTrue(gla.add(m));
    assertTrue(gla.add(n));
  }
  public void testIndexOf(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    gla.add(f);
    gla.add(g);
    gla.add(h);
    gla.add(i);
    gla.add(j);
    gla.add(k);
    gla.add(l);
    gla.add(m);
    gla.add(n);
    assertEquals(gla.indexOf(a.name), 0);
    assertEquals(gla.indexOf(b.name), 1);
    assertEquals(gla.indexOf(c.name), 2);
    assertEquals(gla.indexOf("Hello"), -1);
    assertEquals(gla.indexOf(n.name), 12); //not thirteen because e and f are the same items so they are not added to the array instead, we just add quantity to the item :) yey!
  }
  public void testMarkAsBought(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    gla.add(f);
    gla.add(g);
    gla.add(h);
    gla.add(i);
    gla.add(j);
    assertTrue(gla.markAsBought("Spice"));
    assertTrue(gla.markAsBought("Potato"));
    assertFalse(gla.markAsBought("Hello chocolate bar"));
  }

  public void testRemoveUnexistingItem(){ 
    gla.add(a);
    gla.add(b);
    assertFalse(gla.remove(c.name));
  } 
  public void testRemoveFromEmptyArray(){
    assertFalse(gla.remove(a.name));
  }
  public void testRemoveFirst(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    assertTrue(gla.remove(a.name));
  }
  public void testRemoveMid(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    assertTrue(gla.remove(c.name)); 
  }
  public void testRemoveLast(){ 
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    assertTrue(gla.remove(e.name));
  }
  
  public void testTotalQuantity(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.add(d);
    gla.add(e);
    assertEquals(gla.totalQuantity(), 15);
  }
  
  public void testReduceQuantity(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    assertEquals(gla.reduceQuantity("Spice", 1), true);
    assertEquals(c.quantity, 2);
  }
  
  public void testReduceQuantityZero(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    assertEquals(gla.reduceQuantity("Sugar", 2), true);
    assertEquals(b.quantity, 0);
    assertEquals(gla.size, 2);
  }
  
  public void testCheckItemExistence(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.checkItemExistence("Milk", 0, 1);
    assertEquals(gla.size, 3);
    assertEquals(gla.reduceQuantity("Sugar", 2), true);
    gla.checkItemExistence("Sugar", 1, 2);
    assertEquals(gla.size, 2);
  }
  
  public void testReductionProcess(){
    gla.add(a);
    gla.add(b);
    gla.add(c);
    gla.reductionProcess("Spice", 1, 2);
    assertEquals(c.quantity, 2);
  }
  
}
