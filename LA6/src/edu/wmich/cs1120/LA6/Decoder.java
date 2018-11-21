package edu.wmich.cs1120.LA6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Decoder implements IDecoder {

	@Override
	public void decode(String filePath) {
		try {
			RandomAccessFile raf = new RandomAccessFile(filePath, "r");
			//Start pointer at beginning of file
			raf.seek(0);
			//Loop until end of file flag -1 is found
			while (raf.read() != -1) {
				//converts byte value to a char and prints it at current pointer
				System.out.print((char)raf.read());
				//moves pointer down 3 from current location
				raf.seek(raf.getFilePointer()+3);
				//reads number of blank values and adds to current pointer 
				//plus bytes taken up by useful data
				//lands on next character byte in file
				raf.seek((raf.read())+raf.getFilePointer()+6);
				}
			raf.close();
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
