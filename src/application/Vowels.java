package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Vowels 
{
	private static String text = readTextFromFile("TomSawyer.txt");
	
	public Vowels()
	{

	}
	
	
	
	/**
	 * This method reads text from the TomSawyer file
	 * @param tomSawyerBook
	 * @return text
	 * @throws Exception
	 */
	public static String readTextFromFile(String tomSawyerBook)
	{
		String text = "";
		try
		{
			Scanner input = new Scanner(new File(tomSawyerBook));
			while(input.hasNext()) 
			{
				text += input.next() + " ";
			}
		} catch(IOException ex)
		{
			System.out.println("File is not found");
		}
		return text;
	}
	
	
	
	public int getNumberOfVowels()
	{
		int count = 0;
		char[] characterArray = text.toCharArray();//convert to character array
		for(int i = 0; i < characterArray.length;i++)
		{
			{
				if(isVowel(characterArray[i]))
					{
						count++;
						//System.out.println(stringArray[i]);
					}
			}
		}
		return count;
	}
	
	/**
     * This function checks if the character is vowel (true)
     * @param character
     * @return
     */
	public static boolean isVowel(char character)
	{
		 
		switch(character) 
		{
    		case 'a':
    		case 'A':
    		case 'e':
    		case 'E':
    		case 'i':
    		case 'I':
    		case 'o':
    		case 'O':
    		case 'u':
    		case 'U':
    			return true; //true if vowel	
		}
	return false;
		
	}
	/**
	 * This method generate a list of vowels in the file
	 * @return
	 */
	public static String getListOfVowels()
	{
		String vowel = new String();
		char[] characterArray = text.toCharArray();//convert to character array
		for(int i = 0; i < characterArray.length;i++)
		{
			{
				if(isVowel(characterArray[i]))
					{
						vowel += characterArray[i] + "times\n";
					}
			}
		}
		return vowel;
	}	
	
//	public String listOfVowelsAndCounts()
//	{
//		char[] vowelList = getListOfVowels().toCharArray();
//		String vowelAndCount = "";
//		for(int i = 0; i < vowelList.length; i++)
//		{
//			int count = 0;
//			for(int j = 0; j < vowelList.length; j++)
//			{
//				if(vowelList[i]==vowelList[j])
//				{
//					count++;
//				}
//			}
//			result += vowelList[i] + " - "+ count + "\n";
//		}
//		return result;
//	}
	
	/**
	 * @param count
	 */
	public static String getVowelsAndCount() 
	{
	    int[] count = new int[256];
	    String vowelsAndCount = "";
	    getFrequency(count);
	    for(int i = 0; i < count.length; i++)
	    {
	        if(count[i] > 0)
	        {
	            vowelsAndCount += (char)i+" : "+count[i]+" times\n";
	        }
	    }
	    return "List Of Vowels And Their Respective Counts\n"+vowelsAndCount;
	}
	/**
	 * @param count
	 */
	private static void getFrequency(int[] count) 
	{
	    String characterSequence = getListOfVowels();
	    
	    for(int i = 0; i < characterSequence.length(); i++)
	    {
	        count[characterSequence.charAt(i)]++;
	    }
		//IntStream.range(0, occurrences.length())
		//.forEach(ascii -> count[occurrences.charAt(ascii)]++);
	}
	
	
	
}
