package mavenoop;

import java.util.*;
public class Gifts {
	Scanner scanValue=new Scanner(System.in);
	static int wt=0;
    static int pr=0;
	Sweets sweet;
	Chocolate chocolate;
	public void setSweet(Sweets sweet)
	{
		this.sweet=sweet;
	}
	public void setChocolate(Chocolate chocolate)
	
	{
		this.chocolate=chocolate;
	}
	public void sweetInput()
	{
		sweet.inputSweet();
	}
	public void chocolateInput()
	{
		chocolate.inputChocolate();
	}
}