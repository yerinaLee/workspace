package edu.kh.project.board.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardImg {
	
	   private int imgNo;
	   private String imgPath;
	   private String imgRename;
	   private String imgOriginalName;
	   private int imgOrder;
	   private int boardNo;
	   
	   private MultipartFile uploadFile;

}
