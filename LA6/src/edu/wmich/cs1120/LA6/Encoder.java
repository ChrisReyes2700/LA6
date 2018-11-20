package edu.wmich.cs1120.LA6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Encoder implements IEncoder{

	@Override
	public void encode(String inputFileName, String outputFilePath) {
		//initializes file, random, and scan
		File file = new File(inputFileName);
		Random rng = new Random();
		Scanner scan;
		
		try {
			//scans file and puts into a string
			scan = new Scanner(file);
			String contents = scan.next();
			while (scan.hasNextLine()) {
				contents = contents.concat(scan.nextLine()+"\n");
			}
			
			//creates the random access file
			RandomAccessFile raf = new RandomAccessFile(outputFilePath, "rw");
			
			//in a for loop, loops for every char in the string except the last one:
			//writes the char in the string input at the index i
			//writes a random int between 1-20
			//writes random bytes equal to the int above
			int last = contents.length() - 1;
			for (int i = 0; i < last; i++) {
				char c = contents.charAt(i);
				int n = rng.nextInt(20) + 1;

				raf.writeChar(c);
				raf.writeInt(n);
				for (int j = 0; j < n; j++) {
					raf.writeByte(rng.nextInt());
				}
			//for the last char in the string:	
			//writes the last char then -1 for the int
			raf.writeChar(contents.charAt(last));
			raf.writeInt(-1);
			}
			
			//closes both the random access file and the scanner
			raf.close();
			scan.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
