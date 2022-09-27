
# 이것이 취업을 위한 코딩테스트다
## Chapter 03.3 그리디

### 예제 3-1. 거스름돈

문제 : p.87에 수록

---

## 내 풀이
- <a href="MySolution.java" target="_blank"> MySolution.java </a>

## 나동빈 님 풀이
- <a href="Answer.java" target="_blank"> Answer.java </a>
- gitHub 링크 : <a href="https://github.com/ndb796/python-for-coding-test/tree/master/3" target="_blank"> gitHub </a>
---

## 소요시간

![Time.png](Time.png)
- `System.currentTimeMillis()`으로 시작, 종료시점의 값을 구한뒤 차를 구하여 시간 계산

---
## 해석
- 그리디 : 매 순간, 가장 큰 단위의 화폐로, 최대한 거슬러줄 수 있을 만큼 거슬러준다.
- 입력된 금액에 무관하게 화폐의 종류의 갯수만큼 반복을 수행해야함. 화폐의 종류의 갯수를 K라고 할 때 시간복잡도는 O(K)가 된다.

---