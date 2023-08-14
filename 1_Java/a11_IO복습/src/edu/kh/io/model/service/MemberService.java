package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.io.model.dto.Member;

public class MemberService {
	
	private List<Member> memberList = null;
	
	public MemberService() {
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream( new FileInputStream("object/memberList.txt"));
			memberList = (List<Member>)ois.readObject();
		
		} catch (FileNotFoundException e) {
			System.out.println("[[ memberList.txt 파일이 비어있습니다. ]]");
			memberList = new ArrayList<Member>();
		
		} catch (IOException e) {
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
	
	
	
	/**
	 * 자료저장 service
	 */
	public void saveObject() {
		
	ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object/memberList.txt"));
			oos.writeObject(memberList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null)
				oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	
	

	/** 회원목록 반환 service
	 * @return memberList
	 */
	public List<Member> selectAll() {
		return memberList;
	}
	
	

	/** 아이디 중복검사 service
	 * @return 중복시 true
	 */
	public boolean signUp1(String id) {
		
		for( Member mem : memberList) {
			if (mem.getId().equals(id))
				return true;
		}
		
		return false;
	}

	
	
	/** 회원가입 service
	 * @return 가입시 true 반환
	 */
	public boolean signUp2(String id, String pw, String name, int point) {
		
		memberList.add( new Member(id, pw, name, point));
		
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object/memberList.txt"));
			oos.writeObject(memberList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null)
				oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return true;
	}

	/** id,pw 일치 회원 반환 service
	 * @param id
	 * @param pw
	 * @return Member
	 */
	public Member selectOne(String id, String pw) {

		for(Member mem : memberList) {
			
			if(mem.getId().equals(id) && mem.getPw().equals(pw)) {
				return mem;
			}
		}
		return null;
	}

	/** 회원 비밀번호 변경
	 * @param mem
	 * @param id
	 * @param pw
	 * @return
	 */
	public void changePw(Member mem, String pw2) {
		
		mem.setPw(pw2);
		saveObject();
		
	}



	/** 회원탈퇴
	 * @param mem
	 */
	public void withdrawal(Member mem) {
		memberList.remove(mem);
		saveObject();
	}
	
	
	
		
	
		
	
	
			
	
	
	
	
	
	
	

}
