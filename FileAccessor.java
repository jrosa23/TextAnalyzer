package textAnalysis;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class FileAccessor
{
	
	//method to process the file and read the file
    public void processFile(String inputFileName) throws IOException
    {
        Scanner scanner = new Scanner(new FileReader(inputFileName));
        while (scanner.hasNext())
        {
            processLine(scanner.nextLine());
        }
        scanner.close();
    }

    //abstract method to process each line of the file
    protected abstract void processLine(String line);
}
