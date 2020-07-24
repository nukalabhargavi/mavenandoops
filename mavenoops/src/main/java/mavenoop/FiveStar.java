package mavenoop;

public class FiveStar extends Chocolate 
{
	public void inputChocolate()
	{
		System.out.println("Enter the weight of FiveStar Chocolate:");
		wt=scanValue.nextInt();
		System.out.println("Enter the price of FiveStar Chocolate:");
		pr=scanValue.nextInt();	
	}
}