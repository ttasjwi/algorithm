# boj_1676

난이도 : Silver4

입력받은 값의 계승(팩토리얼)을 구하고 뒤에서부터 0 세기 
문제 : <a href="https://www.acmicpc.net/problem/1676" target="_blank"> [링크]</a>
---  

## Answer : 백준 답안 제출용

- 소스 코드 : <a href="https://github.com/ttasjwi/BOJ/blob/master/src/boj_1676/Answer.java" target="_blank">gitHub</a>
- BufferedReader로 n값을 입력받는다.
- n!을 구한다.
- n!의 뒤에서부터 0을 세가다가, 0이 아닌 값이 나오면 계산을 중지한다.
- 세어진 0의 갯수를 출력

---

## Review
- 난 무작정 팩토리얼 값을 구해서 0을 셌음
- 다른 사람들 풀이를 보면 5이상의 계승값은 2^a * ... * 5^b  * ... 으로 표현 가능하며, a>=b가 보장됨. 이 때 b의 값과 뒤에서부터 센 0의 갯수가 같음을 이용하여 풀 수도 있다.