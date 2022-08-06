// 빨리 해시맵하고 리스트 공부해야겠다...

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length]; // 제일 마지막에 신고한 숫자 담을거
        String[] list_rep = new String[id_list.length];  // 정지당한사람
        
        int cnt = 0; // 정지당한 사람 수
        int ccc = 0; // 중복수
        // 1. 정지당한사람(x)을 찾으려면 신고당한게 k개 이상이어야 하고 신고자 중복이 없어야함
        // 1-1. 먼저 sort해서 중복신고를 빼버리자
        Arrays.sort(report);
        String[] sorted_report = report.clone();
        
        for (int i=1; i<sorted_report.length; i++){
            if(sorted_report[i].equals(sorted_report[i-1])){
                sorted_report[i-1] = "\0 \0";     // 중복 신고 삭제 => 유효신고만 남음
                ccc++;
            }
        }
        
        Arrays.sort(sorted_report);
        report = sorted_report.clone();  // 마지막에 추가함.  중복값 다 빼줘야하나!
        
        for (int i=ccc; i<sorted_report.length; i++)
            sorted_report[i] = sorted_report[i].split(" ")[1];
        
      
        // 1-2. 신고당한게 k개 이상 이어야함
        for(int i=0; i<id_list.length; i++){
            if(Collections.frequency(Arrays.asList(sorted_report),id_list[i]) >= k){
                list_rep[cnt] = id_list[i]; // 정지당한사람 list_rep 에 넣음
                cnt++;
            }
        }
        
        // 2. 신고한사람 수 세기
        // 2-1. report에서 정지당한사람을 신고한사람만 추려냄
        boolean chk= false;
        
        if(cnt > 0){        // cnt==0일때는 정지당한사람이 없어서 결과값 answer=[0,0,0,..] 그대로
            for(int i=ccc; i<report.length; i++){
                for(int j=0; j<cnt; j++){
                    if(report[i].split(" ")[1].equals(list_rep[j])){     // 신고당한사람이 정지당한사람과 같으면
                        chk=true;                                          // chk=true
                        break;
                    }
                }
                if(chk==true){                                          // 신고당한사람이 정지 당했을때
                    report[i] = report[i].split(" ")[0];                // 신고한사람만 남겨둠
                    chk=false;
                }
                else                                                    // 신고당한사람이 정지 안당했을때
                    report[i] = "";                                     // 신고한사람 비워둠
            }
            
         // 2-2. 신고한사람 카운트   
            for(int i=0; i<id_list.length; i++){
                answer[i] = Collections.frequency(Arrays.asList(report),id_list[i]);
            }
        }
        
            
        return answer;
    }
}
