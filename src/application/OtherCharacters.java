package application;

public class OtherCharacters 
{

	private static Vowels vowelsObject = new Vowels();
	private static String text = vowelsObject.readTextFromFile("TomSawyer.txt");
	
	
	
	public OtherCharacters()
	{
		
	}
	
	
	/**
	 * This method generate a list of consonants
	 * @return consonant
	 */
	private static String getListOfConsonants()
	{
		String otherChars = "";//new String();
		char[] charArray = text.toCharArray();//text.split("[ ]");
		for(int i = 0; i < charArray.length;i++)
		{
			{
				if(!((charArray[i]>=65&&charArray[i]<=90)||(charArray[i]>=97&&charArray[i]<=122)))
					{
					otherChars += charArray[i] + " \n";
					}
			}
		}
		return otherChars;
	}
	
	/**
	 * @param count
	 */
	public static String getOtherCharsAndCount() 
	{
	    int[] count = new int[256];
	    String characterAndCount = "";
	    getFrequency(count);
	    for(int i = 0; i < count.length; i++)
	    {
	    	if(!((count[i]>=65&&count[i]<=90)||(count[i]>=97&&count[i]<=122)))
	    	{
		        if(count[i] > 0)
		        {
		        	characterAndCount += (char)i+" : "+count[i]+ " times\n";
		        }
	    	}
	    }
	    return "List Of Other Characters And Their Respective Counts\n"+characterAndCount;
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
