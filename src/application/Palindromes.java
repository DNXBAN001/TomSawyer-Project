package application;
import java.util.*;
import java.io.*;

public class Palindromes 
{
	
	private String arrayOfPalindromes;
	private static Vowels vowelsObject = new Vowels();
	private static Consonants consonantsObject = new Consonants();
	private static String text = vowelsObject.readTextFromFile("TomSawyer.txt");
	private String[] stringArray = text.split("[ ,.-_+=#@!$%^{}*?!'()]");
	private int numberOfPalindomes;
	private String listOfPalindomes;
	
	public Palindromes()
	{
		
		
	
	}
	
	
	public String toString()
	{
		return String.format("Palindromes : %d\nConsonants : %d\n Vowels : %d", getNumberOfPalindromes(),vowelsObject.getNumberOfVowels(),consonantsObject.getNumberOfConsonants());
	}
	public String displayResults()
	{
		return "Palindromes : "+getNumberOfPalindromes()+"\n\nVowels : "+vowelsObject.getNumberOfVowels()+"\n\nConsonants : "+consonantsObject.getNumberOfConsonants();
	}
	
	public int getNumberOfPalindromes()
	{
		int count = 0;
		//String[] stringArray = text.split("[ ,.-?!'()]");
		for(int i = 0; i < stringArray.length;i++)
		{
			if(stringArray[i].length() >= 3)
			{
				if(isPalindrome(stringArray[i]))
					{
						count++;
					}
			}
		}
		return count;
	}
	
	private boolean isPalindrome(String text)
	{
		for(int i = 0; i < text.length()/2; i++)
		{
			if(text.charAt(i) != text.charAt(text.length()-i-1))
					{
						return false;
					}
		}
		return true;
	}
	
	/**
	 * This method finds the palindromes the text and return the list
	 * @return list of palindromes
	 */
	public String getListOfPalindromes()
	{
	    arrayOfPalindromes = new String();
		for(int i = 0; i < stringArray.length; i++)
		{
			if(stringArray[i].length() >= 3)
			{
				if(isPalindrome(stringArray[i]))
					{
						arrayOfPalindromes +=stringArray[i]+ " \n";
					}
			}
		}
		return arrayOfPalindromes;
	}
	
			 

}
