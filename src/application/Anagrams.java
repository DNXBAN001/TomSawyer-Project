package application;

import java.util.Arrays;

public class Anagrams 
{

	private static Vowels vowelsObject = new Vowels();
	private static String text = vowelsObject.readTextFromFile("TomSawyer.txt");
	private String[] wordsArray = text.split("[ ,.-_+=#@!$%^{}*?!'()]");
	
	
	public Anagrams()
	{
		
	}
	
	public String getListOfAnagrams()
	{
		String anagrams = new String();
		int i;
		for(i = 0; i < wordsArray.length; i++)
		{
			int j = i+1;
			for(int x = j; x < wordsArray.length; x++)
			{
				if(isAnagram(wordsArray[i], wordsArray[x]))
				{
					anagrams += wordsArray[i] +" - "+ wordsArray[x] + "\n"; 
				}
			}
		}
		return anagrams;
	}
	
	public boolean isAnagram(String str1, String str2)
	{
		//replace all empty spaces with a nonspace/null character
//		String s1 = str1.replaceAll("\\s", "");
//		String s2 = str1.replaceAll("\\s", "");
		
		boolean status = true;
		if(str1.length()!=str2.length())
		{
			status = false;
		}
		else
		{
			char[] arrayS1 = str1.toLowerCase().toCharArray();
			char[] arrayS2 = str2.toLowerCase().toCharArray();
			Arrays.sort(arrayS1);
			Arrays.sort(arrayS2);
			status = Arrays.equals(arrayS1, arrayS1);
		}
		
		
		return status;
	}
}
