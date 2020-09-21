/* Jeremy A. Rosario
  SDLC Text Analyzer assignment
  due 9/20/2020
*/

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

public class WordCount
{ 
	
	static void wordCounter(String fileName, Map<String, Integer> words) throws FileNotFoundException 
	{ 
		//in this I will convert the file into a String 
		Scanner file = new Scanner(new File(fileName)); 
		while (file.hasNext()) 
		{ String word = file.next(); Integer count = words.get(word); 
		//this is where I will create a counter for the words by their appearance 
		if(count != null) count++; 
		else count = 1; 
		words.put(word, count); 
		} file.close(); 
	} 

	public static void main(String[] args) throws FileNotFoundException 
	{ 
	// create a hash map to store value pairs of the words and their count 
	Map<String, Integer> words = new HashMap<String, Integer>(); 
	wordCounter("C:\\Users\\jrosa\\Documents\\theRaven.txt", words); 
	System.out.println(words); 
	}
}



