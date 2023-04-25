package lt.baltrimas.lukas;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lt.baltrimas.lukas.HMS.Hibernate.Hibernate_config;

public class Main
{
	public static void main( String[] args )
    {
		Hibernate_config hc = new Hibernate_config();
		
		Random rand = new Random();
	    List<String> givenList = Arrays.asList("Single", "Double");
	    int numberOfElements = 1;
		for(int i = 1; i <= 164; i++)
		{
			String randomElement = null;
			 for (int j = 0; j < numberOfElements; j++) {
			        int randomIndex = rand.nextInt(givenList.size());
			        randomElement = givenList.get(randomIndex);
			    }
			 
			 hc.saveRoom(i, randomElement, false, false, null);
			 hc = new Hibernate_config();
		}
		
    }
}
