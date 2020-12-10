package textAnalysis;

public class TextFileReaderWriter extends FileAccessor
{
	 private String[] linesArray;
	 private int currentIndex;
	 private static final int DEFAULT_SIZE = 25;
	 public TextFileReaderWriter()
	 {
	     linesArray = new String[DEFAULT_SIZE];
	     currentIndex = 0;
	 }

	 public void processLine(String line)
	 {
	     if (isFull() == true)
	     {
	       expand();
	     }
	     
	     if (linesArray[currentIndex] == null)
	     {
	         linesArray[currentIndex] = line;
	     } else
	     		{
	            	for (String i : linesArray)
	            	{
	            		if (i == null)
	            		{
	            			i = line;
	            			break;
	            		}
	            	}
	     		}	   
	     currentIndex++;
	   }

	   public String[] getLines()
	   {
	        return getLinesCopy();
	   }

	   private boolean isFull()
	   {
		   if (currentIndex >= linesArray.length - 1)
		   {
	            return true;
	       } else 
	       		{
	            	return false;
	       		}
	   }

	   private void expand()
	   {
	        String[] expandedArr = new String[2 * linesArray.length];
	        for (int i = 0; i < linesArray.length; i++)
	        {
	            expandedArr[i] = linesArray[i];
	        }
	        linesArray = expandedArr;
	   }

	   private String[] getLinesCopy()
	   {
	        int count = 0;
	        for (int i = 0; i < linesArray.length; i++)
	        {
	            if (linesArray[i] != null)
	            {
	                count++;
	            }
	        }

	        int n = 0;
	        String[] linesList = new String[count];
	        for (int i = 0; i < linesArray.length; i++)
	        {
	            if (linesArray[i] != null)
	            {
	                linesList[n] = linesArray[i];
	                n++;
	            }
	        }
	        return linesList;
	    }
}

