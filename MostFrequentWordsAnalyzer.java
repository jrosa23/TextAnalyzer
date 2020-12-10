package textAnalysis;

import java.util.Arrays;
import java.util.Collections;

public class MostFrequentWordsAnalyzer implements TextAnalyzer
{
	 private static final int DEFAULT_SIZE = 100;
	 private int currentIndex;
	 private WordCount[] wordCounts;
	 private int topNumber = 20;

	 //constructor for most frequest word
	 public MostFrequentWordsAnalyzer()
	 {
	    wordCounts = new WordCount[DEFAULT_SIZE];
	    currentIndex = 0;
	 }
	 
	 //method to analyze the data in the text
	 public void analyzeData(String[] textData)
	 {
	     for(String line : textData)
	      analyzeLine(line);
	 }

	 //method to analyze the lines of the text
	 private void analyzeLine(String line)
	 {
	     String token; int len;
	     String[] tokens = line.split("[,.;:?!() ]");
	     for(int i=0;i<tokens.length;i++)
	     {
	         token = tokens[i];
	         len = token.length();
	         if (len > 4)
	         {
	             String curWord = stopWord(token);
	             WordCount wc = getWordCount(curWord);
	             if(wc != null)
	             {
	                    wc.incCount();
	             } else
	             	{
	                    WordCount newWC = new WordCount(curWord);
	                    addToArray(newWC);
	                }
	          }
	      }
	   }

	   //method to get word count
	   private WordCount getWordCount(String targetWord)
	   {
	       WordCount tarWord = null;
	       WordCount[] wordsOnly = getArrayWordsOnly();
	       for (int i = 0; i < wordsOnly.length; i++)
	       {
	           if (wordsOnly[i].containsWord(targetWord))
	           {
	                tarWord = wordsOnly[i];
	           }
	       }
	        return tarWord;
	    }

	    //method to add words to the array
	    private void addToArray(WordCount wc)
	    {
	        if (isFull() == true)
	        {
	            expand();
	        }
	        if (wordCounts[currentIndex] == null)
	        {
	            wordCounts[currentIndex] = wc;
	        } else
	        	{
	            	for (WordCount i : wordCounts)
	            	{
	            		if (i == null)
	            		{
	            			i = wc;
	            			break;
	            		}
	            	}
	        	}
	        currentIndex++;
	     }

	     private String stopWord(String word)
	     {
	        String newWord = word;
	        if (word.charAt(word.length() - 1) == 's' || word.charAt(word.length() - 1) == 'S')
	        {
	            newWord = word.substring(0, word.length() - 1);
	        }
	        return newWord;
	     }

	    private void expand()
	    {
	        WordCount[] expandedList = new WordCount[2 * wordCounts.length];
	        for (int i = 0; i < wordCounts.length; i++)
	        {
	            expandedList[i] = wordCounts[i];
	        }
	        wordCounts = expandedList;
	    }

	    private boolean isFull()
	    {
	        if (currentIndex == wordCounts.length)
	        {
	            return true;
	        } else
	        	{
	            	return false;
	        	}
	    }

	    private WordCount[] getArrayWordsOnly()
	    {
	        int index = 0;
	        for (WordCount i : wordCounts)
	        {
	            if (i != null)
	            {
	                index++;
	            }
	        }
	        
	        int n = 0;
	        WordCount[] wordsList = new WordCount[index];
	        for (WordCount j : wordCounts)
	        {
	            if (j != null)
	            {
	                wordsList[n] = j;
	                n++;
	            }
	        }
	        return wordsList;
	    }

	    //method to get report of the top 20 most common words
	    public String getReportString()
	    {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Top "+ topNumber +" most common words.").append(System.getProperty("line.separator"));
	        WordCount[] wordsOnly = getArrayWordsOnly();
	        Arrays.sort(wordsOnly, Collections.reverseOrder());
	        for(int i = 0; i < topNumber; i++)
	        {
	            sb.append(wordsOnly[i].toString());
	            sb.append(System.getProperty("line.separator"));
	        }
	        return sb.toString();
	    }
}
