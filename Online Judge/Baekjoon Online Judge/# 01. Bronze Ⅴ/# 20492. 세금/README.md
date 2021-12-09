# \[BOJ 20492] 세금

- 난이도 : Bronze5
- 정해진 상금에 대한 실수령액 
- 문제 : <a href="https://www.acmicpc.net/problem/20492" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 전체 상금 `price`을 입력 받음.
- int `price1` : 상금에 대해 22%를 납부해야함.
  - 실 수령액은 `price`의 전체에 대하여 (1-0.22)만큼을 곱한값이 됨. 물론 이는 double이 되므로 int로 형변환 해야한다. price는 1000의 배수이므로 int로 형변환 해도 값손실이 일어나지 않는다.
- int `price2` : 상금에 대해 80%는 실제 수령받고, 나머지 20%의 상금에 대해서 22%를 납부해야함.
  - 실 수령액은 `price` * 0.8 + `price` * 0.2 * (1-0.22)을 int로 형변환 합과 같다.

---

# Review
- 그냥 아무 생각 없이 푸는 산수 문제

---
