package Serverside;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


class GetSongs {
	
	public static String songs_id(String item){
			String songs = null;
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
						songs = split[4];
						System.out.println("Songs :"+songs);
					} 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return songs;
		}
}


