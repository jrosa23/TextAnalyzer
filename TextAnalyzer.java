package textAnalysis;

public interface TextAnalyzer
{
	//array of lines from the input file
    public void analyzeData(String[] textData);

    // Return String representation of the analysis
    public String getReportString();
}
