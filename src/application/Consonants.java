package application;

import java.util.ArrayList;

public class Consonants 
{
	
	private static Vowels vowelsObject = new Vowels();
	private static String text = vowelsObject.readTextFromFile("TomSawyer.txt");
	private String listOfConsonants;
	
	
	public Consonants()
	{
		
	}
	
	
	/**
	 * This method counts the total number of consonants in the text file
	 * @return count
	 */
	public int getNumberOfConsonants()
	{
		int count = 0;
		char[] stringArray = text.toCharArray();//text.split("[ ]");
		for(int i = 0; i < stringArray.length;i++)
		{
			{
				if(isConsonant(stringArray[i]))
					{
						count++;
					}
			}
		}
		return count;
	}
	/**
     * This function checks if the character is consonant (true) or not
     * @param character
     * @return
     */
	private static boolean isConsonant(char character)
	{
		if((character >= 65 && character <= 90)||(character >=97&&character<=122))
		{
			if(!vowelsObject.isVowel(character))
			{
				return true;//return true if it is a consonant
			}
		}
		return false;
	}
	
	/**
	 * This method generate a list of consonants
	 * @return consonant
	 */
	private static String getListOfConsonants()
	{
		String consonant = new String();
		char[] charArray = text.toCharArray();//text.split("[ ]");
		for(int i = 0; i < charArray.length;i++)
		{
			{
				if(isConsonant(charArray[i]))
					{
						consonant += charArray[i] + " \n";
					}
			}
		}
		return consonant;
	}
	
	/**
	 * @param count
	 */
	public static String getConsonantsAndCount() 
	{
	    int[] count = new int[256];
	    String consonantAndCount = "";
	    getFrequency(count);
	    for(int i = 0; i < count.length; i++)
	    {
	        if(count[i] > 0)
	        {
	            consonantAndCount += (char)i+" : "+count[i]+ " times\n";
	        }
	    }
	    return "List Of Consonants And Their Respective Counts\n"+consonantAndCount;
	}
	/**
	 * @param count
	 */
	private static void getFrequency(int[] count) 
	{
	    String characterSequence = getListOfConsonants();
	    
	    for(int i = 0; i < characterSequence.length(); i++)
	    {
	        count[characterSequence.charAt(i)]++;
	    }
	}
	

}
