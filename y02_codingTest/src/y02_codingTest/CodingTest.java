package y02_codingTest;


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

//        int answer = 0;
//        int price = 580000;
//        
//        if(price >= 500000) answer = price-(int)(price*0.2);
//        else if(price >= 300000) answer = price-(int)(price*0.1);
//        else if(price >= 100000) answer = price-(int)(price*0.05);
//        else answer = price;

//			int n = 10;
//			
//	        int idx = 0;
//	        for(int i=0; i<n; i++){
//	            if((n-i)%2 != 0) idx++;
//	        }
//	        
//	        int[] answer = new int[idx];
//	        
//	        idx = 0;
//	        
//	        for(int i = 1; i<=n; i+=2) {
//	        	if(i <= n) answer[idx] = i; 
//	        	idx++;
//	        }
//	        
//	        for(int i : answer)   System.out.print(i);

//			String my_string = "nice to meet you";
//	        String answer = "";
//	        
//	        for(char c : my_string.toCharArray()){
//	           if(c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u') {
//	               answer += "";
//	           } else {
//	               answer += Character.toString(c);
//	           }
//	        }

//			int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
//			int n = 3;

//	        List<Integer> answerList = new ArrayList<Integer>();
//	        
//	        for(int i : numlist){
//	            if(i%n == 0) answerList.add(i);
//	        }
//	        
//	                
//	        int[] answer = new int[answerList.size()];
//	        for(int i=0; i<answerList.size(); i++){
//	            answer[i] = answerList.get(i).intValue();
//	        }

//	        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

//	        int[] answerArr = new int[numlist.length];
//
//	        int idx = 0;
//	        for(int i : numlist){
//	            if(i % n == 0) {
//	                answerArr[idx] = i;
//	                idx++;
//	            }
//	        }
//
//	        for(int i : answerArr)   System.out.print(i); // 6912000000
//	        
//	        int[] answer = new int[idx];
//	        
//	        idx = 0;
//
//	        for(int i : answerArr){
//	            if(i != 0){
//	                answer[idx] = i;
//	                idx++;
//	            }        
//	        }
//	        
//	        for(int i : answer)   System.out.print(i);

//			String my_string = "cccCCC";
//			
//			String answer="";
//			
//	        for(char c : my_string.toCharArray()) {
//	        	if((int)c < 97) {
//	        		c = Character.toLowerCase(c);
//	        		answer += c;
//	        	} else {
//	        		c = Character.toUpperCase(c);
//	        		answer += c;
//	        	}
//	        }

//	        String rsp = "205";
//	            String answer = "";
//	            
//	            for(int i=0; i<rsp.length(); i++){
//	                
//	                switch(rsp.charAt(i)){
//	                    case '2' : answer += "0"; break;
//	                    case '0' : answer += "5"; break;
//	                    case '5' : answer += "2"; break;
//	                }     
//	                
//	            }

//			String cipher="pfqallllabwaoclk"; int code=2;        
//	        String answer = "";
//	        
//	        for(int i=1; i*code <= cipher.length(); i++){
//	            answer += cipher.charAt(i*code-1);
//	        }
//		
//            System.out.println(answer);

//			int[] numbers = {10, 20, 30, 5, 5, 20, 5};

//			int answer = 0;
//			int num = 0;
//			
//			for(int i=0; i<numbers.length; i++) {
//				for(int j=i+1; j<numbers.length; j++) {
//					if(answer <= (numbers[i]*numbers[j])) {
//						answer = (numbers[i]*numbers[j]);
//						num++;
//					}
//				}
//			} // 이게맞는데 대체 왜 안되는 테스트가 있는지 모르겠다...^^
//			
//			System.out.println(answer);
//			System.out.println(num);

//			for(int i=0; i<numbers.length; i++) {
//				if(numbers[i] < 0) numbers[i] *= -1;
//			}
//			
//			for(int i=0; i<numbers.length; i++) {
//				for(int j=i+1; j<numbers.length; j++) {
//					if(numbers[i] < numbers[j]) {
//						int temp = numbers[i];
//						numbers[i] = numbers[j];
//						numbers[j] = temp;
//					}
//				}
//			}
//			
//			System.out.println(numbers[0]*numbers[1]);

//	        for(int i : numbers)   System.out.print(i);

//			String myString="aBcDeFg";
//		        String answer = "";
//		        
//		        for(char c : myString.toCharArray()){
//		            if(c=>97) {
//		            	c = Character.toUpperCase(c);
//		                answer += c;
//		            }else{
//		                answer += c;
//		            }
//		        }

//	        System.out.println(answer);

//			int n=0; String control="wsdawsdassw";
//			
//		        int answer = 0;
////		        for(char c : control.toCharArray()){
////		        	
////		            switch(c){
////		                case 'w' : answer += 1; break;
////		                case 's' : answer -= 1; break;
////		                case 'd' : answer += 10; break;
////		                case 'a' : answer -= 10; break;          
////		                    
////		            }
////		        }
//		        
//		        for(int i=0; i<control.length(); i++){
//		        	
//		            switch(control.charAt(i)){
//		                case 'w' : answer += 1; break;
//		                case 's' : answer -= 1; break;
//		                case 'd' : answer += 10; break;
//		                case 'a' : answer -= 10; break;                             
//		            }
//		        }

//		int[] array = {1, 8, 3};
//            
//	        int[] answer = new int[2];
//	        
//	        answer[0] = array[0];
//	        answer[1] = 0;
//	                
//	        for(int i=0; i<array.length; i++){
//	                if(answer[0] < array[i]) {
//	                    answer[0] = array[i];
//	                    answer[1] = i;
//	                }
//	        }

//	        for(int i:answer) System.out.print(i);

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//
//		for(int i=1; i<=n; i++) {
//			
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}

//		String my_string = "hello"; int num1=1; int num2=2;
//	        String answer = "";
//	        
//	        for(int i=0; i<my_string.length(); i++){
//	            if(i==num1) answer += my_string.charAt(num2);
//	            else if(i==num2) answer += my_string.charAt(num1);
//	            else answer += my_string.charAt(i);
//	        }
//	        

//		int[] num_list  = {2,1,6};
//	        int n = 3;
//	        String a =""; // 짝수
//	        String b =""; // 홀수
//	        
//	        for(int i:num_list){
//	            if(i%2==0) a+= i+"";
//	            else  b+= i+"";
//	        }
//	                        
//	        System.out.println(Integer.valueOf(a) + Integer.valueOf(b));

//	        int[] answer = Arrays.copyOfRange(num_list, n-1, num_list.length);

//	        for(int i: answer) System.out.println(i);

//		String my_string = "banana";
//		String is_prefix = 	"bananan";
//		
//		if(my_string.length() >= is_prefix.length()) {
//			my_string = my_string.substring(0, is_prefix.length());
//		}
//		
//		System.out.println(my_string);
//		
//		System.out.println(my_string.compareTo(is_prefix));

//		int n=10; int k=3;
//	        int[] answer = new int[n/k];
//	        
//	        for(int i=0; i<answer.length; i++){
//	            answer[i] = k * (i+1);
//	        }
//		
//	        for(int i: answer) System.out.println(i);
//

//		String str1 = "abc"; String str2="aabcc"	;
//		
//		System.out.println(str2.contains(str1));

//		String my_string="programmers";  String alp="p";
//		
//	        String answer = my_string.replaceAll(alp, alp.toUpperCase());
//	        
//	        System.out.println(answer);

//	        String my_string="ProgrammerS123"; int n=11;
//	            String answer = my_string.substring(my_string.length()-(n-1));
//	            
//	            System.out.println(answer);

//	            int[] num_list = {5, 2, 1, 7, 5}; int n=3;
//	            int[] answer = Arrays.copyOfRange(num_list, 0, n);

//		int[] arr = {1, 2, 3, 100, 99, 98};
//		int[] answer = new int[arr.length];
//        
//        for(int i=0; i<arr.length; i++){
//        	if(arr[i] > 50) {
//        		if(arr[i]%2==0) answer[i]=arr[i]/2;
//        		else answer[i]=arr[i];
//        		
//        	} else {
//        		if (arr[i] % 2 !=0) answer[i] = arr[i]*2;
//        		else answer[i]=arr[i];
//        	}
//        }
//        
//        for(int i: answer) System.out.println(i);

//		int[] num_list = {5, 2, 1, 7, 5};
//	            
//        int[] answer = new int[num_list.length+1];
//        
//        // 배열 복사        
//        System.arraycopy(num_list, 0, answer, 0, num_list.length);
//        
////        for(int i: answer) System.out.println(i);
//        
//        // 마지막 인덱스 체크
//        if(num_list[num_list.length-1] > num_list[num_list.length-2]) {
//            answer[answer.length-1] = num_list[num_list.length-1] - num_list[num_list.length-2];
//        } else{
//            answer[answer.length-1] = num_list[num_list.length-1] *2;
//        }
//	            
//        for(int i: answer) System.out.println(i);      

//		int[] num_list = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
//		
//		int[] answer = new int[num_list.length-5];
//		
//		Arrays.sort(num_list);
//		
//		for(int i=0; i<answer.length; i++) {
//			answer[i] = num_list[5+i];
//		}
//		
//		for(int i: answer) System.out.println(i);   

//		String my_string="banana"; String is_suffix="ana";
//		
//		System.out.println(my_string.endsWith(is_suffix));

//		String[] todo_list={"problemsolving", "practiceguitar", "swim", "studygraph"};
//		boolean[] finished= {true, false, true, false};
//		
////	        String[] answer = new String[Collections.frequency(finished, false)];
//	    
//		int num = 0;
//		for(int i=0; i < todo_list.length; i++){
//			if(!finished[i]) num++;
//        }
//		
//		String[] answer = new String[num];
//		
////		for(String i: answer) System.out.println(i);
//		
//		num = 0;
//		for(int i=0; i < todo_list.length; i++){
//			if(!finished[i]) {
//				answer[num] = todo_list[i];
//				num++;
//			}
//		}
//		
//		for(String i: answer) System.out.println(i); 
//		
//		
//		// 이거!!!!!
//		String str = "";
//        for(int i=0; i<finished.length; i++){
//            str = finished[i]==false ? str+todo_list[i]+"," : str;
//        }
//
//        str.split(",");

//		int[] num_list= {15, 98, 23, 2, 15}; int n = 20;
//	        
//	        for(int i : num_list){
//	            if(i==n) System.out.println("1");
//	            else System.out.println("0");
//	        }
//	        

//			char to int        
//	        int answer = 0;
//	        
//	        for(int i=0; i<num_str.length(); i++){
//	            answer += Character.getNumericValue(num_str.charAt(i));
//	        }

		// 배열->list 변환 후 삭제
//		int[] arr = { 293, 1000, 395, 678, 94 };
//		int[] delete_list = { 94, 777, 104, 1000, 1, 12 };
//
//		List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
//
//		for (int i : delete_list) {
//			
//			int index = answer.indexOf(i);
//			if(index != -1) {
//				answer.remove(index);
//			}
//		}
//		
//		// list to arr
//		int size = answer.size();
//		int[] answerArr = answer.stream().mapToInt(Integer::intValue).toArray(); 
//
//		System.out.println(answerArr);
		
//		int[] num_list = {2, 3, 4, 5};
//	        int answer = 0;
//	        
//	        if(num_list.length >= 11){
//	            for(int i : num_list) answer += i;
//	        } else if(num_list.length <= 10){
//	        	answer = 1;
//	            for(int i : num_list) {
//	                answer *= i;
//	            }
//	        }
		
		
//		System.arraycopy(복사할 배열, (복사할 배열에서) 복사를 시작할 인덱스, 
//		    붙여넣기 할 배열, 붙여넣기를 시작할 인덱스, (복사할 배열에서) 얼마나 복사해 붙여넣을지 길이를 지정)
		
//		int[] num_list= {5, 2, 1, 7, 5}; int n = 3;
////		int[] num_list= {2, 1, 6}; int n = 1;
//		
//	        int[] answer = new int[num_list.length];
//	        
////	        System.arraycopy(num_list, 0, answer, n+1, num_list.length-n-1);
////	        System.arraycopy(num_list, n, answer, 0, num_list.length-n);
//	        
//	        int index = 0;
//	        
//	        for(int i=n; i<num_list.length; i++) {
//	        	answer[index++] = num_list[i];
//	        }
//	        
//	        for(int i=0; i<n; i++) {
//	        	answer[index++] = num_list[i];
//	        }
//	        
//		for(int i : answer) System.out.println(i);
		
		
//		String myString = "PrOgRaMmErS";
//	        String answer = "";
//	        
//	        for(int i=0; i<myString.length(); i++){
//	            if(myString.charAt(i) == 'a') answer += "A";
//	            else if(myString.charAt(i) != 'A' && myString.charAt(i) < 97) answer += Character.toLowerCase(myString.charAt(i));
//	            else answer += myString.charAt(i);
//	        }
	        
	        
	        String n_str ="0010";
	        
	        String answer = "";
	        int idx = 0;
	        
	        for(int i=0; i<n_str.length(); i++) {
	        	if(n_str.charAt(i) == '0') answer += "";
	        	else {
	        		idx = i;
	        		break;
	        	} 
	        }
	        
	        for(int i = idx; i<n_str.length(); i++) {
	        	answer += n_str.charAt(i);
	        }
		
	        System.out.println(answer);
	        
	}


}
