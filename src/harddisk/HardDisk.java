package harddisk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HardDisk {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Moi ban nhap duong dan: ");
		String ad = input.nextLine();
		System.out.println("Moi ban nhap tu muon tim: ");
		String keyw = input.nextLine();
		File currentDir = new File(ad);
		displayDirectoryContents(currentDir, keyw);

	}
	
	public static void displayDirectoryContents(File dir, String key) {
		try {
			File[] files = dir.listFiles();
			FileInputStream fis;
			Scanner scanner;
			
			for (File file : files) {
				if (file.isDirectory()) {
					displayDirectoryContents(file,key);
				} else {
					fis = new FileInputStream(file.getCanonicalPath());
					scanner = new Scanner(fis);

					String str;

					while (scanner.hasNextLine()) {
						
						str = scanner.nextLine();
						if(str.indexOf(key)==-1) {
							continue;
						}
						else {
							System.out.println(file.getCanonicalPath());
							break;
						}
					}
					scanner.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


