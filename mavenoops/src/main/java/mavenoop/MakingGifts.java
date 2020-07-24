package mavenoop;

import java.util.*;
public class MakingGifts extends Gifts
{
	static Scanner scanValue=new Scanner(System.in);
	static int[] sweetsWeight;
	static int[] sweetsPrice;
	static int noOfSweets;
	static int[] chocolatesWeight;
	static int[] chocolatesPrice;
	static int noOfChocolates;
	static String[] candyNames;
	static int[] candyWeights;
	static int[] candyPrices;
	static int noOfCandies=0;
	public static void inputGift() throws Exception
	{
		System.out.println("Enter number of Sweets:");
	    noOfSweets= scanValue.nextInt();
		sweetsWeight=new int[noOfSweets];
		sweetsPrice=new int[noOfSweets];	
		for(int sweet=0;sweet<noOfSweets;sweet++)
		{
			System.out.println("Enter the Type of Sweet(Badhusha/KalaKaani)?");
			String typeOfSweet= scanValue.next();
			Class<?> cls=Class.forName(typeOfSweet);
			Object o=cls.newInstance();
			Sweets s=(Sweets)o;
			Gifts newyeargift=new Gifts();
			newyeargift.setSweet(s);
			newyeargift.sweetInput();	
		    sweetsWeight[sweet]=wt;
		    sweetsPrice[sweet]=pr;
		}	
		System.out.println("Enter number of Chocolates:");
		noOfChocolates= scanValue.nextInt();
		chocolatesWeight=new int[noOfChocolates];
		chocolatesPrice=new int[noOfChocolates];
		candyWeights=new int[noOfChocolates];
		candyNames=new String[noOfChocolates];
		candyPrices=new int[noOfChocolates];
		for(int chocolate=0;chocolate<noOfChocolates;chocolate++)
		{
			System.out.println("Enter the Type of Chocolate(DiaryMilk/Candy)?");
			String typeOfChocolate=scanValue.next();
			Class<?> cls=Class.forName(typeOfChocolate);
			Object o=cls.newInstance();
			Chocolate c=(Chocolate)o;
			Gifts newyeargift=new Gifts();
			newyeargift.setChocolate(c);
			newyeargift.chocolateInput();	
		    chocolatesWeight[chocolate]=wt;
		    chocolatesPrice[chocolate]=pr;
		    if(typeOfChocolate.equals("Candy"))
			{
				System.out.println("Enter the name of the candy:");
				String name= scanValue.next();
				candyNames[noOfCandies]=name;
				candyWeights[noOfCandies]=wt;
				candyPrices[noOfCandies]=pr;
				noOfCandies++;
			}
		}	
	 }
	public static void totalGiftWeight()
	{
	    int giftBoxWeight=0;
	     for(int sweet=0;sweet<noOfSweets;sweet++)
	     {
	    	 giftBoxWeight+=sweetsWeight[sweet];
	     }
	     for(int chocolate=0;chocolate<noOfChocolates;chocolate++)
	     {
	    	 giftBoxWeight+=chocolatesWeight[chocolate];
	     }
	    System.out.println("Total Weight of Gift Box is: "+giftBoxWeight);
	}
	public static void sortChocolates(String sortType)
	{
		int temp;
		if(sortType.equals("price"))
		{
		  for(int chocolate=0;chocolate<noOfChocolates-1;chocolate++)
		  {
			  for(int chocolate1=0;chocolate1<noOfChocolates-chocolate-1;chocolate1++)
			  {
				  if(chocolatesPrice[chocolate1]>chocolatesPrice[chocolate1+1])
				  {
					  temp=chocolatesPrice[chocolate1];
					  chocolatesPrice[chocolate1]=chocolatesPrice[chocolate1+1];
					  chocolatesPrice[chocolate1+1]=temp;
					  temp=chocolatesWeight[chocolate1];
					  chocolatesWeight[chocolate1]=chocolatesWeight[chocolate1+1];
					  chocolatesWeight[chocolate1+1]=temp;
				  }
			  }
		  }
		}
		else
		{
			for(int chocolate=0;chocolate<noOfChocolates-1;chocolate++)
			  {
				  for(int chocolate1=0;chocolate1<noOfChocolates-chocolate-1;chocolate1++)
				  {
					  if(chocolatesWeight[chocolate1]>chocolatesWeight[chocolate1+1])
					  {
						  temp=chocolatesPrice[chocolate1];
						  chocolatesPrice[chocolate1]=chocolatesPrice[chocolate1+1];
						  chocolatesPrice[chocolate1+1]=temp;
						  temp=chocolatesWeight[chocolate1];
						  chocolatesWeight[chocolate1]=chocolatesWeight[chocolate1+1];
						  chocolatesWeight[chocolate1+1]=temp;
					  }
				  }
			  }
		}
		System.out.println("Sorted Chocolates:");
		System.out.println("-------------------");
		System.out.println("WEIGHT        PRICE");
		for(int chocolate=0;chocolate<noOfChocolates;chocolate++)
		{
          
			System.out.println(chocolatesWeight[chocolate]+" "+chocolatesPrice[chocolate]);
		}
	}
	public static void getCandies(String candieType)
	{
		System.out.println("Enter the lower limit:");
		int lowerLimit= scanValue.nextInt();
		System.out.println("Enter the higher limit:");
		int higherLimit= scanValue.nextInt();
		if(candieType.equals("price"))
		{
			for(int candy=0;candy<noOfCandies;candy++)
			{
				if(candyPrices[candy]>=lowerLimit && candyPrices[candy]<=higherLimit)
				{
					System.out.println(candyNames[candy]);
				}
			}
		}
		else
		{
			for(int candy=0;candy<noOfCandies;candy++)
			{
				if(candyWeights[candy]>=lowerLimit && candyWeights[candy]<=higherLimit)
				{
					System.out.println(candyNames[candy]);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		inputGift();
		totalGiftWeight();
		System.out.println("Enter the option by which you want to sort(price/weight)?");
		String sortType= scanValue.next();
		sortChocolates(sortType);
		System.out.println("Enter the option by which you want to get candies(price/weight)?");
		String candieType= scanValue.next();
		getCandies(candieType); 
	}
		
}