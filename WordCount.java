/* 
   Jeremy A. Rosario
   SDLC Text Analyzer assignment
   due 10/25/2020
*/

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;


public class WordCount
{
	public static void main(String args[])
	{
		Map<String, Integer> wordMap = buildWordMap("C:/Users/jrosa/Documents/theRaven.txt");
		List<Entry<String, Integer>>list = sortByValueDecreasingOrder(wordMap);
		System.out.println("Top 20 Repeated Words");
		
		for(Map.Entry<String, Integer>entry : list)
		{
			if(entry.getValue() > 1)
			{
				System.out.println(entry.getKey() + " - " + entry.getValue());
			}
		}
	}
	
	public static Map<String, Integer> buildWordMap(String fileName)
	{
		Map<String, Integer> wordMap = new HashMap<>();
		try(FileInputStream fileInputS = new FileInputStream(fileName);
				DataInputStream dataInputS = new DataInputStream(fileInputS);
				BufferedReader bufferedR = new BufferedReader(new InputStreamReader(dataInputS)))
					{
						Pattern pattern = new Pattern.compile("\s+");
						String line = null;
						while((line = br.readLine())!= null) {
							line = line.toLowerCase();
							String[] words = pattern.split(line);
							for(String word : words) 
							{
								if(wordMap.containsKey(word)) {
									wordMap.put(word, (wordMap.get(word) + 1));
								}else {
									wordMap.put(word,  1);
								}
							}
						}
					}catch(IOException ioex) {
						ioex.printStackTrace();
					}
		return wordMap;
	}
	
	public static List<Entry<String, Integer>>sortByValueIncreasingOrder(Map<String, Integer>wordMap)
	{
		Set<Entry<String, Integer>>entries = wordMap.entrySet();
		List<Entry<String, Integer>>list = new ArrayList<>(entries);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>o2)
		{
			@Override
			public int compare(Map.Entry<String, Integer>o1, Map.Entry<String, Integer>o2)
			{
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		return list;
	}
	
}


