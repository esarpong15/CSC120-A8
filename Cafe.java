/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private double nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private double nSugarPackets; // The number of sugar packets remaining in inventory
    private double nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator; // Whether or not the building has an elevator

    // Constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    public String toString(){
        return (super.toString());
    }
    
    /**
     * Sells a coffee by reducing the inventory based on parameters.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        System.out.println("This is the original method being used");
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && 
            this.nCreams >= nCreams && this.nCups >= 1) {
            this.nCoffeeOunces-=size;
            this.nSugarPackets-=nSugarPackets;
            this.nCreams-=nCreams;
            this.nCups-=1;
            System.out.println("Coffee sold! Enjoy your drink.");
        } else {
            System.out.println("Low stock, Calling restock...");

            // Calling the restock method from within sellCoffee
            restock(50, 10, 10, 5);

            // Attempt to sell again after restocking
            sellCoffee(size, nSugarPackets, nCreams);
        }
    }
    
    /**
     * Restocks the cafe inventory.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        // restock when necessary
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
    }

    @Override
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams) \n + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    @Override
    public void goToFloor(int floorNum){
        if (this.hasElevator == true) {
            System.out.println("The upstairs is only available for workers.");
        } else {
            System.out.println("The "+ this.name+ " does not have an elevator.");
        }
    }

    // Overloading the sellCoffee() method
    
    public void sellCoffee(double size, double nSugarPackets, double nCreams){
        System.out.println("This is the overloaded method's being used");
        if (this.nCoffeeOunces >= size && this.nSugarPackets >= nSugarPackets && 
            this.nCreams >= nCreams && this.nCups >= 1) {
            this.nCoffeeOunces-=size;
            this.nSugarPackets-=nSugarPackets;
            this.nCreams-=nCreams;
            this.nCups-=1;
            System.out.println("Coffee sold! Enjoy your drink.");
        } else {
            System.out.println("Low stock, Calling restock...");

            // Calling the restock method from within sellCoffee
            restock(50.5, 10.5, 10.5, 5);

            // Attempt to sell again after restocking
            sellCoffee(size, nSugarPackets, nCreams);
        }
    }

    // Overloading the restock() meethod
    private void restock(double nCoffeeOunces, double nSugarPackets, double nCreams, int nCups){
        // restock when necessary
        this.nCoffeeOunces=nCoffeeOunces;
        this.nSugarPackets=nSugarPackets;
        this.nCreams=nCreams;
        this.nCups=nCups;
    }



    public static void main(String[] args) {
        Cafe ccCafe = new Cafe("Campus Center Cafe", "100 Elm St", 1,  20, 10, 10, 5, false);
        System.out.println(ccCafe);

        //Checking showOptions() Override
        ccCafe.showOptions();

        //Checking goToFloor(n) Override
        ccCafe.goToFloor(2);

    
    
        //buying one coffee
        ccCafe.sellCoffee(12, 2, 3);
        //Checking overload
        ccCafe.sellCoffee(12.5, 2.5, 3.5);

        //buying another coffee
        ccCafe.sellCoffee(16,2,2);
        //Checking overload
        ccCafe.sellCoffee(16.5,2.5,2.5);
    }
    
}
