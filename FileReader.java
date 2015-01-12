import java.io.File;
import java.util.Scanner;

class FileReader
{
	File inputFile;
	Scanner fileScanner;
	String results;

	public FileReader(File inputFile) throws Exception
	{
		this.inputFile = inputFile;
		this.fileScanner = new Scanner(this.inputFile);
		results = "";
	}

	public void search()
	{
		
		boolean headerFound = false;
		
		while(fileScanner.hasNextLine())
		{
			String currentLine = fileScanner.nextLine();
			if(headerFound == false)
			{
			String header = checkLineForHeader(currentLine);

				if(!header.equals(""))
				{
					headerFound = true;
					results += header;
				}
			}
			else //Header has already been found
			{
			String link = checkLineForLink(currentLine);
				if(!link.equals(""))
				{
					headerFound = false;
					results += link;
				}
			}
				
		}

		System.out.print(results);
	}

	private String checkLineForLink(String line)
	{
		if(line.contains("</a>"))
		{
			return grabLink(line);	
		}
		else
		{
			return "";
		}
	}

	private String checkLineForHeader(String line)
	{
		if(line.contains("title="))
		{
			return grabHeader(line);	
		}
		else
		{
			return "";
		}
	}

	private String grabHeader(String line)
	{
		int startIndex = line.indexOf("title=")+7;
		int endIndex = line.indexOf("\"",startIndex);
		
		//System.out.println(line.substring(startIndex,endIndex));
		try
		{	
			return "{"+line.substring(startIndex,endIndex)+"}";
		}
		catch(Exception e)
		{
			return "[JAVA_ERROR]";
		}
	}

	private String grabLink(String line)
	{

		int startIndex = line.indexOf("href=")+6;
		int endIndex = line.indexOf("\"",startIndex);
		int oddBall = line.indexOf("#",startIndex);
		if(oddBall != -1 && oddBall < endIndex)
		{
			endIndex = oddBall;
		}

		//System.out.println(line.substring(startIndex,endIndex));
		try
		{
			return "["+line.substring(startIndex,endIndex)+"]";
		}
		catch(Exception e)
		{
			return "[JAVA_ERROR]";
		}
	}
}
