package edu.wmich.cs1120.LA6;

/**
 * Project converts an input text file into an encode binary file then decodes the newly encode file and prints the results. 
 * Encoding is done on a RandomAccessFile by writing the next input character from the text followed by a random integer n between 1 to 20 
 * then random bytes taking n spaces.
 * 
 * @author Austin W, Chris R
 *
 */
public class Main {
	public static void main(String[] args) {
		IEncoder encoder = new Encoder();
		IDecoder decoder = new Decoder();
		String inputFileName = "input.txt";
		String encodedFileName = inputFileName+".encode";
		encoder.encode(inputFileName,encodedFileName);
		decoder.decode(encodedFileName);
	}
}

 
