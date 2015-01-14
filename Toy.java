import java.io.*;
import java.util.Scanner;

class Toy
{
	public static void main(String[] args)
	{
		System.out.println(link(args[0]));
	}

	public static String link(String article)
	{
		String firstChar = article.substring(0,1);
		File containingFile = locateArticleData(firstChar);	
		try
		{
			return getLinkFromLine(getLineWithArticle(containingFile,article));
		}catch(Exception e){}
		return ""; //Something went really wrong somewhere	
	}

	public static File locateArticleData(String firstChar)
	{
		if(firstChar.toUpperCase().matches("[A-Z]"))
		{
			return new File("./sortedOutPut/"+firstChar.toUpperCase());
		}
		else
		{
			return new File("./sortedOutPut/other");
		}
	}

	public static String getLineWithArticle(File containingFile, String article) throws IOException
	{
		System.out.println("Searching " + containingFile.toString() + "  ...");
		Scanner lineGetter = new Scanner(containingFile);
		while(lineGetter.hasNextLine())
		{
			String currentLine = lineGetter.nextLine();
			if(currentLine.toLowerCase().contains("{"+article.toLowerCase()+"}"))
			{	
				lineGetter.close();
				return currentLine.toLowerCase();
			}
		}

		lineGetter.close();
		System.out.println("Article not found");
		System.exit(1);
		return "";
	}

	public static String getLinkFromLine(String articleLine)
	{
		int start = articleLine.indexOf("[") + 1;
		int end = articleLine.indexOf("]");

		return articleLine.substring(start,end);
	}
}
