package edu.wmich.cs1120.LA6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Encoder implements IEncoder{

	/**
	 * Uses a scanner to read a file and place the file contents into a string then creates a random access file. 
	 * The random access file loop through every char but the last, for each loop, the char at that index i is written followed by
	 * a random int between 1 to 20, and a length of random bytes equal to the random int picked. The last char is only followed by a -1 int.
	 * Closes the random access file then the scanner. Method is in a try catch block to catch any FileNotFoundException or IOException.
	 * 
	 * @param inputFileName name of the input text file
	 * @param outputFilePath name of the encoded output binary file 
	 */
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
