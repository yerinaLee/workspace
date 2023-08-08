package edu.kh.exception.model.dto;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketException;
import java.util.zip.DataFormatException;

public class Child extends Parent{

	
	
	@Override
//	public void method() throws IOException, DataFormatException {}
	public void method() throws EOFException, SocketException {}
	
	
	
	
}
