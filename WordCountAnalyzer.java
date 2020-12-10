package textAnalysis;

public class WordCountAnalyzer
{
	 private int numberOfWords = 0;
	 public void analyzeData(String[] textData)
	 {
		 for (String i : textData)
		 {
	       String words[] = i.split("[,.;:?!() ]");
	       for (String j : words)
	       {
	    	   if (j.length() >= 4)
	    	   {
	    		   numberOfWords++;
	    	   }
	       }
	     }
	  }
}
