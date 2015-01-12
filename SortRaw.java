import java.io.File;
import java.io.*;
import java.util.Scanner;

public class SortRaw
{
	public static void main(String[] args) throws Exception
	{
		File raw = new File("./linkPairList.txt");	
		Scanner rawScan = new Scanner(raw);

		while(rawScan.hasNextLine())
		{

			String currentLine = rawScan.nextLine();
			String firstChar = currentLine.substring(1,2);
			if(firstChar.matches("[A-Z]"))
			{
				makeFileIfDNE(firstChar);
				writeRawToFile(currentLine,firstChar);
			}		
			else
			{
				makeFileIfDNE("other");
				writeRawToFile(currentLine,"other");
			}
		}	
		rawScan.close();
	}

	public static void makeFileIfDNE(String firstChar) throws IOException
	{
		File checkFile = new File("./sortedOutPut/"+firstChar);
		if(!checkFile.exists())
		{
			if(checkFile.createNewFile())
			{
				System.out.println("Created new file "+firstChar);
			}	
			else
			{
				System.out.println("Failed to make new file");
			}
		}
	}

	public static void writeRawToFile(String inputLine,String fileName)
	{

		//http://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
		try
		{
			FileWriter out = new FileWriter("./sortedOutPut/"+fileName,true);
			out.write(inputLine+"\n");
			out.close();
		}
		catch(IOException e)
		{
			//r.i.p.
		}
	}

} 
