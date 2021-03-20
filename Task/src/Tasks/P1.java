package Tasks;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P1 {

public static void main(String[] args)
{
	File f=new File("text123.txt");
	if(!f.getName().endsWith(".txt"))
		{
			System.out.println("File must be a text file");
		}
	else
	{
		try {
			if(!f.exists())
			{
				f.createNewFile();
			}
			FileWriter fw;
			BufferedWriter writer;
			fw = new FileWriter(f);
			writer=new BufferedWriter(fw);
			System.out.println("Enter the text");
			Scanner sc1=new Scanner(System.in);
			String text1=sc1.nextLine();
			Pattern p=Pattern.compile("[^A-Za-z0-9]");
			Matcher m=p.matcher(text1);
			if(text1.matches("\\s+"))
			{
				System.out.println("Blank characters are not allowed as input");
			}
			else if(text1.trim().isEmpty())
			{
				System.out.println("Blank line is not allowed as input");
			}
			else if(m.find())
			{
				System.out.println("Special characters are not allowed");
			}
			else
			{
			writer.write(text1);
			writer.newLine();
			writer.close();
			fw.close();
			sc1.close();
			System.out.println("Your input is saved");
			}
         }
		catch(NoSuchElementException e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}

	}
}
}

