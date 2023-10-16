package edu.kh.project.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자
@Getter
@Setter
@ToString
public class Member {
	
	   private int memberNo;
	   private String memberEmail;
	   private String memberPw;
	   private String memberNickname;
	   private String memberTel;
	   private String memberAddress;
	   private String profileImg;
	   private String enrollDate;
	   private String memberDelFl;
	   private int authority; 

}
