import java.io.File;
import java.util.Scanner;

class FirstLinkFinder
{
	public static void main(String[] args) throws Exception
	{
		File fileNameInput = new File("./wikiFileNamesPythonOutput.txt");
		Scanner fileNamesGetter = new Scanner(fileNameInput);
		while(fileNamesGetter.hasNextLine())
		{
			String currentFileName = fileNamesGetter.nextLine();
			File currentFile = new File(currentFileName);
			FirstLinkReader infoGetter = new FirstLinkReader(currentFile);

			infoGetter.search();
		}
	}


} 
