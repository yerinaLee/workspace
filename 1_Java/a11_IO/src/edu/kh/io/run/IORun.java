package edu.kh.io.run;

import edu.kh.io.model.service.IOService;
	
public class IORun {
	
	
	public static void main(String[] args) {
		
		IOService service = new IOService();
		
//		service.byteOutput();
//		service.charOutput();
//		service.byteInput();
		service.charInput();
		
	
	}
	
	
}
