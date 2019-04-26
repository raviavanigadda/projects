public class DeluxePizza {
	public String size;
	public int cheeseTopping;
	public int pepperoniTopping;
	public int mushroomTopping;

	//additional attributes
	public boolean stuffedWithCheese; //additional attribute to the class
	public int veggieTopping; //veggie toppings excluding mushrooms
	public static int numberOfPizzas = 0; //track no of pizzas
	public int pizzaIndex; //index to track pizza
	// Constructors
	//-------------
	public DeluxePizza()
	{
		size = "";
		stuffedWithCheese = false;
		veggieTopping = 0;
		numberOfPizzas = numberOfPizzas +1;

	}

	//copy constructor for number of pizzas
	public DeluxePizza(DeluxePizza obj)
	{
		numberOfPizzas = numberOfPizzas;

	}

	//static method pizzasofSize to check for size and display
	public static void pizzasOfSize(String size)
	{


	}
	public DeluxePizza(String sz, int cheese, int pepperoni, int mushroom, boolean stuffedwithcheese, int veggietopping)
	{
		size = sz.toUpperCase();
		cheeseTopping = cheese;
		pepperoniTopping = pepperoni;
		mushroomTopping = mushroom;
		stuffedWithCheese = stuffedwithcheese;
		veggieTopping = veggietopping;
	}
	
	// Accessor methods
	//-----------------
	public String getSize()
	{
		return size;
	}
	
	public int getCheeseTopping()
	{
	return cheeseTopping;
	}
	
	public int getPepperoniTopping()
	{
		return pepperoniTopping;
	}
	
	public int getMushroomTopping()	{ return mushroomTopping;	}

	public boolean isStuffedWithCheese() { return stuffedWithCheese; }

	public int getVeggieTopping() {	return veggieTopping;	}

	public int getNumberOfPizzas() { return  numberOfPizzas; }
	
	//Mutator methods
	//---------------
	public void setSize(String sz)
	{
		this.size = sz.toUpperCase();
	}
	
	public void setCheeseTopping(int cheese)
	{
		this.cheeseTopping = cheese;
	}
	
	public void setPepperoniTopping(int pepperoni)
	{
		this.pepperoniTopping = pepperoni;
	}
	
	public void setMushroomTopping(int mushroom)
	{
		this.mushroomTopping = mushroom;
	}

	//mutator methods for additional attributes

	public void setStuffedWithCheese(boolean stuffedWithCheese) { this.stuffedWithCheese = stuffedWithCheese;	}

	public void setVeggieTopping(int veggieTopping) { this.veggieTopping = veggieTopping;	}


	// Other methods
	public int calcCost()
	{
		int cost = 0;
		if(size.equals("SMALL")) {
			cost = 10;
			if(stuffedWithCheese = true)
			{
				cost = cost + 2;
			}
		}
		else if (size.equals("MEDIUM")) {
			cost = 12;
			if(stuffedWithCheese = true)
			{
				cost = cost + 4;
			}
		}else if (size.equals("LARGE")) {
			cost = 14;
			if(stuffedWithCheese = true)
			{
				cost = cost + 6;
			}

		}

		  return cost + (cheeseTopping + pepperoniTopping + mushroomTopping ) * 2 + veggieTopping * 3;
	}
	
	public boolean equals(DeluxePizza pizza)
	{
		return size.equals(pizza.size) && cheeseTopping == pizza.cheeseTopping
		&& pepperoniTopping == pizza.pepperoniTopping
		&& mushroomTopping == pizza.mushroomTopping
				&& veggieTopping == pizza.veggieTopping;
	}


	public String toString()
	{
		return "\n\tPizza size: "+ size + "\n\tCheese filled dough: "+ stuffedWithCheese +
				"\n\tNumber of cheese toppings: "+ cheeseTopping + "\n\tNumber of pepperoni toppings: " +
		       pepperoniTopping +"\n\tNumber of mushroom toppings: "+ mushroomTopping +
				"\n\tNumber of vegetable toppings: "+veggieTopping;
	}

}
