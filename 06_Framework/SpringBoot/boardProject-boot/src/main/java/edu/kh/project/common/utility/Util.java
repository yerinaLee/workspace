package edu.kh.project.common.utility;

import java.text.SimpleDateFormat;

public class Util {
	
	   public static int seqNum = 1;
	   
	   /** 파일명 변경 메소드(날짜+seqNum.확장자)
	    * @param originFileName
	    * @return
	    */
	   public static String fileRename(String originFileName) {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	      String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

	      String str = "_" + String.format("%05d", seqNum++);

	      String ext = originFileName.substring(originFileName.lastIndexOf("."));

	      return date + str + ext;
	   }
	   

}
