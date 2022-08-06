// 문자열에 관한 대부분 함수!
// 정규표현식 공부하자

import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계 모든 대문자를 소문자로 치환
        answer = new_id.toLowerCase();
        
        
        // 2단계 소문자, 숫자, (-), (_), (.)를 제외한 모든 문자 제거
        
        // answer = answer.replaceAll("[^-_.a-z0-9]","");
        boolean chk = false;
        for (int i=0; i<answer.length(); i++){
            chk = false;
            if(answer.charAt(i) >='a' && answer.charAt(i) <= 'z') chk = true;
            if(answer.charAt(i) >='0' && answer.charAt(i) <= '9') chk = true;
            if(answer.charAt(i) == '-' || answer.charAt(i) == '_' || answer.charAt(i) == '.') chk=true;
            
            if(chk==false) answer = answer.replace(Character.toString(answer.charAt(i))," ");
        }
        answer = answer.replace(" ","");
        
        
        // 3단계 마침표 2번이상 연속으로 찍히면 한개로 치환
        
        //answer = answer.replaceAll("[.]{2,}",".");
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        
        
        // 4단계 마침표가 처음이나 끝에 위치하면 제거
        
        //answer = answer.replaceAll("^[.]|[.]$","");
        if(answer.charAt(0)=='.') answer= answer.substring(1,answer.length());
        if(answer.length()>0){
            if(answer.charAt(answer.length()-1)=='.') answer= answer.substring(0,answer.length()-1);
        }
        
        
        // 5단계 빈문자열이라면 "a" 대입
        
        //if(answer.equals("")) answer+="a";
        if(answer.length() == 0) answer="a";
        
        
        // 6단계 16자 이상이면 첫15개 문자 제외한 나머지 문자들은 모두 제거.  만약 제거후 끝에 마침표(.) 있으면 제거
        
        //if(answer.length() >=16){
        //    answer = answer.substring(0,15);
        //    answer = answer.replaceAll("^[.]|[.]$","");
        //}
        if(answer.length() > 15) answer = answer.substring(0,15);
        if(answer.length()>0){
            if(answer.charAt(answer.length()-1)=='.') answer= answer.substring(0,answer.length()-1);
        }
        
        // 7단계 길이가 2자 이하라면 마지막문자를 길이가 3될때까지 반복
        
        //if(answer.length()<=2)
        //    while(answer.length()<3)
        //        answer+=answer.charAt(temp.length()-1);
        
        if(answer.length() <= 2){
            for(int i=answer.length(); i<3; i++ ){
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        
        return answer;
    }
}
