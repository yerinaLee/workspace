package edu.kh.jdbc.model.dto;

public class CBoard {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String bCreateDate;
	private int readCount;
	private int likeCount;
	private String boardDelFl;
	private int memberNo;
	
	// 기본 생성자
	public CBoard() {}

	// 매개변수 생성자
	public CBoard(int boardNo, String boardTitle, String boardContent, String bCreateDate, int readCount, int likeCount,
			String boardDelFl, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.bCreateDate = bCreateDate;
		this.readCount = readCount;
		this.likeCount = likeCount;
		this.boardDelFl = boardDelFl;
		this.memberNo = memberNo;
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

	public String getbCreateDate() {
		return bCreateDate;
	}

	public void setbCreateDate(String bCreateDate) {
		this.bCreateDate = bCreateDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
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

	@Override
	public String toString() {
		return "CBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", bCreateDate=" + bCreateDate + ", readCount=" + readCount + ", likeCount=" + likeCount
				+ ", boardDelFl=" + boardDelFl + ", memberNo=" + memberNo + "]";
	}
	
	
	
	
	
	
	
	

}
