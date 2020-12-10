package textAnalysis;

import java.io.IOException;
import java.util.Scanner;

public class TextAnalysisMain
{
	 public static void main(String[] args) throws IOException
	 {
		 	
	        //initialize Textfilereadwriter class
	        TextFileReaderWriter tfproc = new TextFileReaderWriter();
	        TextAnalyzer[] analyzers = getAnalyzers();
	        String inputFileName;
	        String[] textData = null;
	        String reportString;
	        Scanner inputFileName1 = new Scanner(System.in);
	        
	        //prompt user to enter the text file name
	        System.out.println("Enter a text file name to analyze:");
	        inputFileName = inputFileName1.nextLine();
	        try{
	            tfproc.processFile("C:/Users/jrosa/Documents/theRaven.txt");
	            textData = tfproc.getLines();
	        }
	        catch(IOException ioex)
	        {
	            //print if error occures while accesing the file
	            System.out.println("Error accessing file: "+inputFileName);
	            System.out.println(ioex);
	        }
	        catch(Exception ex)
	        {
	            System.out.println(ex);
	        }
	        if(textData!=null)
	        {
	            for(int i=0;i<analyzers.length;i++)
	            {
	                analyzers[i].analyzeData(textData);
	            }	        
	            	//print analyzed text
	            	System.out.println("Analyzed text: " + inputFileName);
	            	reportString = getReportStr(analyzers);
	            	System.out.println(reportString);
	            	
	        }
	  }
	 
	  //method to get text analysis
	  private static TextAnalyzer[] getAnalyzers()
	  {
	        int numAnalyzers = 1;
	        TextAnalyzer[] analyzers = new TextAnalyzer[numAnalyzers];
	        analyzers[0] = new MostFrequentWordsAnalyzer();
	        return analyzers;
	  }

	  //method to collect the report
	  private static String getReportStr(TextAnalyzer[] analyzers)
	  {
	        StringBuilder sb = new StringBuilder();
	        for(TextAnalyzer a: analyzers)
	        {
	            sb.append(a.getReportString()).append(System.getProperty("line.separator"));
	        }
	        return sb.toString();
	  }	  
}
