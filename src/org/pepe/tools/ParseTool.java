package org.pepe.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseTool {
	
	public static String[] OutputArray;
	
	public static void ParseFile(String name) throws IOException 
	{
		String path = "maps/" + name;
		Scanner scanner = new Scanner(new File(path));
		String token;
		List<String> temps = new ArrayList<String>();
		
		while (scanner.hasNext())
		{
			token = scanner.nextLine();	
			temps.add(token);
		}
		
		scanner.close();
		
		OutputArray = temps.toArray(new String[0]);
		
	}
	
}
