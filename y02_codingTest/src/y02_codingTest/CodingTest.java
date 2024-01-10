package y02_codingTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class CodingTest {
	
	public static void main(String[] args) {
		
		
//		String my_string = "Program29b8UYP";
//		String overwrite_string = "merS123";
//		int s = 7;
//		
//		String answer="";
//		char[] charArr = my_string.toCharArray();
//		
//		for(int i = 0; i < overwrite_string.length(); i++) {
//			charArr[s+i] = overwrite_string.toCharArray()[i];
//		}
//		
//		answer += new String(charArr);
//		
//		System.out.println(answer);
		
		
//		String str1 = "aaaaa";
//		String str2 = "bbbbb";
//		String answer = "";
//		
//		char[] str1Arr = str1.toCharArray();
//		char[] str2Arr = str2.toCharArray();
//		
//		for(int i = 0; i < str1Arr.length; i++) {
//			for(int j = i; j<=i; j++) {
//				answer += str1Arr[i];
//				answer += str2Arr[j];
//			}
//		}
//		
//		System.out.println(answer);
		
//		int a=3; int b=2;
//        int answer = 0;
        
//	        String ab = ""+a+b;
//	        String ba = ""+b+a;
//	        
//	        if(Integer.parseInt(ab) > Integer.parseInt(ba)) answer = Integer.parseInt(ab);
//	        else answer = Integer.parseInt(ba);
        
        
//	        int ab = Integer.parseInt(""+a+b);
//	        
//	        if(ab > (2*a*b) || ab == (2*a*b)){
//	            answer = ab;
//	        } else answer = (2*a*b);
        
//	        double answer1 = (double)b/a * 1000;
//	        System.out.println((int)answer1);
        
//        int[] numbers = {1, 2, 3, 4, 5};
//        
//        int answer = 0;
//        int tmp = 0;
//        
//        for(int i=0; i<numbers.length; i++) {
//        	for(int j=i+1; j<numbers.length; j++) {
//        		if(numbers[j] > numbers[i]) {
//        			tmp = numbers[j];
//        			numbers[j] = numbers[i];
//        			numbers[i] = tmp;
//        		}
//        	}
//        }
		
		
//		String[] s1 = {"a", "b", "c"}; String[] s2 = {"a", "b", "c"};
//
//		for(String s11 : s1){
//            for(String s22 : s2){
//                if(s11.equals(s22)) answer++;
//            }
//        }
        
//        int[] num_list = {1, 2, 3, 4, 5};
//        int[] answer = new int[num_list.length];
//        int idx = 0;
//        
//        for(int i=num_list.length-1; i>0; i--){
//            answer[idx] = num_list[i];
//            idx++;
//        }
		
		
		
		// int 를 int 배열로 바꾸기
//		int n = 930211;
//		int answer = 0;
//        int[] intArr = Stream.of(String.valueOf(n).split(""))
//                .mapToInt(Integer::parseInt).toArray();
//            
//            for(int i : intArr){
//                answer += i;
//            }
		
		
		
//		int[] numbers = {1, 3, 5};
//		int num1=1; int num2=2;
//		
//	        int[] answer = new int[(num2-num1)+1];
//	        
//	        int num=0;
//	        
//	        for(int i=num1; i<=num2; i++){
//	            answer[num] = numbers[num1];
//	            ++num; ++num1;
//	        }
//
//	        for(int a : answer) {
//	        	System.out.println(a);
//	        }
		
//		String my_string = "jaron";
//        char[] arr = new char[my_string.length()];
//        int idx=my_string.length()-1;
//        
//        for(char c : my_string.toCharArray()){
//            arr[idx] = c;
//            idx--;
//        }
        
//        String answer = new String(arr);
//		System.out.println(answer);
        
        
//		int[] num_list = {1, 2, 3, 4, 5};
//        int a = 0;
//        int b = 0;
//        
//        for(int i : num_list){
//            if(i%2==0) a++;
//            else b++;
//        }
//        
//        int[] answer = new int[2];
//        answer[0] = a;
//        answer[1] = b;
        
        
		
//		int[] array = {1, 2, 7, 10, 11};    
//	        
//		Arrays.sort(array);
//        System.out.println(array[array.length/2]);
        
        
        int answer = 0;
        int price = 580000;
        
        if(price >= 500000) answer = price-(int)(price*0.2);
        else if(price >= 300000) answer = price-(int)(price*0.1);
        else if(price >= 100000) answer = price-(int)(price*0.05);
        else answer = price;
		
		
	}

}
