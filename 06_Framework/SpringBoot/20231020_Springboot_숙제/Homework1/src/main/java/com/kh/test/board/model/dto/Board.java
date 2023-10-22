package com.kh.test.board.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String boardPw;
	private String writeDate;
	private String boardDelFl;
}
