package edu.kh.jdbc.model.dto;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardCreateDate;
	private int readCount;
	private String boardDelFl;
	private int memberNo;
	
	private String memberNickname;
	
	public Board() {}

	public Board(int boardNo, String boardTitle, String boardContent, String boardCreateDate, int readCount,
			int memberNo, String memberNickname) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDate = boardCreateDate;
		this.readCount = readCount;
		this.memberNo = memberNo;
		this.memberNickname = memberNickname;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(String boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getBoardDelFl() {
		return boardDelFl;
	}

	public void setBoardDelFl(String boardDelFl) {
		this.boardDelFl = boardDelFl;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardCreateDate=" + boardCreateDate + ", readCount=" + readCount + ", boardDelFl=" + boardDelFl
				+ ", memberNo=" + memberNo + ", memberNickname=" + memberNickname + "]";
	}
	
}
