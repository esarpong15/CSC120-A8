/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator; // Whether or not the building has an elevator

  // Constructor
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");

  }

  // Overloaded Constructor
  public House(String name, String address){
    // offers default values (3 floors, no dining, no elevator)
    this(name, address, 3, false, false);
  }



  public String toString(){
    return(super.toString()+System.lineSeparator()+"The resident(s) of this hosue is/are:"+this.residents+System.lineSeparator()+"Does it have a dining hall?: "+this.hasDiningRoom);
  }

  /**
   * Accessor for hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  } 

  /**
   * Accessor nResidents
   */
  public int nResidents(){
    return this.residents.size();
  } 

  /**
   * Updates the ArrayList of residents every time
   * someone moves in.
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * Updates the ArrayList of residents every time
   * someone moves out.
   * Returns the Student who moved out
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  } 

  /**
   *  A boolean method that tells us whether or not
   *  a given person is a resident of the House.
   */
  public boolean isResident(Student s){
    return this.residents.contains(s);
  } 

  @Override
  public void showOptions(){
    super.showOptions();
    System.out.println(" + moveIn(s) \n + moveOut(s) \n + isResident(s)");
  }

  @Override
  public void goToFloor(int floorNum){

    if (this.hasElevator == true) {
      this.activeFloor = 1;
      super.goToFloor(floorNum);
    } else {
      System.out.println("The "+ this.name+ " does not have an elevator.");
      }
    }
  
    // Overloading moveOut() to evict everyone in the house

    public void moveOut(){
      this.residents.clear();
      System.out.println("Everyone has now been evicted.");
    }

    

  public static void main(String[] args) {

    Student elizabeth = new Student("Elizabeth", "99909abc", 2029);
    Student alice = new Student("Alice","1234xyz",2029);
    Student arriana = new Student("Arriana", "5678blah", 2029);
    Student jode = new Student("Jode", "192328",2029);

    House parsonsHouse = new House("Parsons", "24 Henshaw Ave",4, true, true);

    //Calling Overload Constructor
    House yolandaKingHouse = new House("Yolanda King","116 Elm St");

    //Checking showOptions() Override
    //parsonsHouse.showOptions();
    
    //Checking goToFloor(floorNum) Override
    //parsonsHouse.goToFloor(3);
  
    // Moving students into the House
    parsonsHouse.moveIn(elizabeth);
    parsonsHouse.moveIn(alice);
    System.out.println(parsonsHouse);

    // Moving student into YK House
    yolandaKingHouse.moveIn(arriana);
    yolandaKingHouse.moveIn(jode);
    System.out.println(yolandaKingHouse);

    // Calling Overload moveOut();
    yolandaKingHouse.moveOut();
    System.out.println(yolandaKingHouse);
    
    
  }

}