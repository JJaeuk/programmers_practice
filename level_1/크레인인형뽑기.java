// 스택도 시간나면 공부하자...
// 스택 크기가 주어지지 않으면 답도없음

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int stk[] = new int[1000];      // 아직 자바 스택을 쓸 줄 몰라 배열로 스택합니다... 
        int cnt_stk = 0;                // 스택카운터
        int cnt_pung = 0;               // 터지는 인형 갯수(answer)
        
        for (int i=0; i<moves.length; i++){         // moves 갯수만큼 뺑뺑이 돌려야함
            for (int j=0; j<board.length; j++){     // board 높이만 알면 됨
                if(board[j][moves[i]-1] !=0){       // moves[i]-1 로 가로위치 잡고 0이 아닐때까지(인형나올때까지) 내려감
                    stk[cnt_stk] = board[j][moves[i]-1];    // 인형나오면 스택에 그인형 넣음
                    if (cnt_stk>0 && stk[cnt_stk-1] == stk[cnt_stk]){   // 스택이 한칸이상 차있었고, 새로들어온게 이전에 들어온거랑 똑같으면
                        stk[cnt_stk-1] = stk[cnt_stk] = 0;  // 이전칸과 방금 들어온칸 인형 없애줌
                        cnt_stk -= 2;                       // 인형 두개 터졌으니까 스택카운트 -2
                        cnt_pung += 2;                      // 인형 두개 터졌으니까 터진인형갯수(answer) +2
                    }
                    cnt_stk++;                      // 별일없으면 스택카운트 +1
                    board[j][moves[i]-1] = 0;       // 스택으로 옮긴 인형은 보드에서 지워줌
                    break;                          // 인형 잡혔는데 더내려가면 큰일남
                }
            }
        }
        
        answer = cnt_pung;
        
        return answer;
    }
}
