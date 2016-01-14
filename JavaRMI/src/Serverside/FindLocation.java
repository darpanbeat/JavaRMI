package Serverside;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class FindLocation{

	public static String artistlocation_id(String item){
		String artistlocation = null;
		try {
			FileInputStream fs = new FileInputStream("src/Serverside/Table2.in");
			@SuppressWarnings("resource")
			Scanner o = new Scanner(fs);
		
			while(o.hasNextLine()){
				String reader;
				reader = o.nextLine();
				String split[] = reader.split("<SEP>");
				if(split[2].equals(item))
				{
					artistlocation = split[3];
					System.out.println("inside artistlocation :"+artistlocation);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artistlocation;
		
		
	}
	

}
