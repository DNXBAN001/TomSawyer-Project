package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{

	private static Vowels vowelsObj = new Vowels();
	private static Consonants consonantObj = new Consonants();
	private static OtherCharacters otherCharObj = new OtherCharacters();
	private static String text = vowelsObj.readTextFromFile("TomSawyer.txt");
	private static String[] wordsArray = text.split("[ ,.-_+=#@!$%^{}*?!'()]");
	
	
	public static void main(String[] args)
	{
		launch(args);
		
		try
		{
			//create file named Order.txt and put characters and their counts in it
			PrintWriter output = new PrintWriter(new File("Order.txt"));
			output.println(vowelsObj.getVowelsAndCount());
			output.println(consonantObj.getConsonantsAndCount());
			output.println(otherCharObj.getOtherCharsAndCount());
			output.close();
		}
		catch(IOException ex)
		{
			System.out.println("File not found...");
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		primaryStage.setScene(new ControllerClass());
		primaryStage.setTitle("Tom Sawyer Assignment");
		primaryStage.show();
	}
	
	
	
	
	
	
	
	public static String getListOfAnagrams()
	{
		String anagrams = new String();
		for(int i = 0; i < wordsArray.length; i++)
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
	
	public static boolean isAnagram(String str1, String str2)
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
