Prepare > Algorithms > Implementation > Save the Prisoner!
## Save the Prisoner!

---

Difficulty : Easy  
Problem : <a href="https://www.hackerrank.com/challenges/save-the-prisoner/problem" target="_blank"> link </a>

---

## 풀이

1. 주기성 계산을 고려하지 않고, m개의 사탕을 순차적으로 분배할 때, 마지막으로 받게 되는 사람의 자리는 (s+m-1)이다.
2. 원탁을 n명이 둘러 앉아있으므로 주기성을 고려해야한다. n으로 나눴을 때의 나머지값을 sit라고 하자.
3. sit가 0이면 n을 반환하고, 아닌 경우 sit값을 반환하면 된다.

---
