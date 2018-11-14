package edu.wmich.cs1120.LA6;

public interface IDecoder {
	// Given the file path of the binary file, the decoder will read the file, decode the message and 
	// print it to the console.
	// Include code to handle the IOException.
	public void decode(String filePath);
}
