package edu.kh.project.board.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// DTO (Data Transfer Object) : 데이터 전달용 객체
// - 클래스간의 이동(레이어 이동)시 필요한 데이터를 한 번에 담아서 전달하는 용도

// DTO 사용시 많이 하는 실수!!!
// - 이거 DB 테이블 컬럼이랑 똑같이 해야하는거 아닌가요?
// 아닙니당!!

// -> 담아야하는 데이터가 있으면 필요한 만큼 , 필요한 형태로 필드 작성!!!!!

@Getter
@Setter
@ToString
public class Board {
	
	// BOARD 테이블과 매핑되는 필드
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriteDate;
    private String boardUpdateDate;
    private int readCount;
    private String boardDelFl;
    private int memberNo;
    private int boardCode;
    
    
    // 목록 조회, 상세 조회 시 매핑되는 필드
    private int commentCount; // 댓글수
    private int likeCount; // 좋아요수
    private String memberNickname; // 작성자 닉네임
    private String thumbnail; // 썸네일 이미지 경로
    
    private String profileImg; // 게시글 작성자 프로필 이미지

    
    // 댓글 목록을 저장할 필드
    private List<Comment> commentList;
    
    // 게시글 이미지 목록
    private List<BoardImg> imageList;
    
}

