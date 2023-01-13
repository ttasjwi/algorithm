# 문제
- 번호 : 120846
- 제목 : 합성수 찾기
- 난이도 : Level 0
- 자연수 n이 매개변수로 주어질 때 n이하의 합성수의 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120846)

---

# 필요 알고리즘

## 소수
- 1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수

## 합성수
- 1보다 큰 자연수 중에서 소수가 아닌 수
- 약수의 개수가 3개 이상인 수
- 둘 이상의 소수를 곱한 자연수

## 에라토스 테네스의 체
![sieve-of-eratosthenes](imgs/sieve-of-eratosthenes.gif)

특정 범위의 자연수들의 소수, 합성수 여부를 판단하는 가장 기본적인 알고리즘

- 1은 소수도 합성수도 아니다. (알고리즘 풀 때 이 부분을 놓치는 경우가 있어서 문제를 잘 읽고 이 부분을 문제에 맞게 잘 체크해야한다.)
- 2부터 시작한다. 2는 합성수로 체크되어 있지 않으므로 소수이다. 2보다 큰 2의 배수는 모두 합성수이므로 이들을 모두 합성수로 체크한다.
- 다음은 3이다. 3은 합성수로 체크되어 있지 않으므로 소수이다. 3보다 큰 3의 배수는 모두 합성수이므로 모두 합성수로 체크한다.
- 다음은 4이다. 4는 위의 과정을 통해 합성수로 체크되어 있으므로 아무 것도 하지 않는다.
- 다음은 5이다. 5는 합성수로 체크되어 있지 않으므로 소수이다. 5보다 큰 5의 배수는 모두 합성수이므로 이들을 모두 합성수로 체크한다.
- 이와 같은 방법으로 n까지 순서대로 체크하면, 합성수가 필터링되고, 필터링되지 않은 수들은 모두 소수이다.

---

# 풀이
```java
public class Solution {

    public int solution(int n) {
        boolean[] isCompositeNumber = new boolean[n+1];
        int answer = 0;
        
        for (int i = 2; i<= n; i++) {
            if (!isCompositeNumber[i]) {
                for (int j = 2*i; j<= n; j+=i) {
                    if (!isCompositeNumber[j]) {
                        isCompositeNumber[j] = true;
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }

}
```
- 합성수 체크배열인 isCompositeNumber를 생성한다.
- 2부터 시작하여, 에라토스테네스의 체 알고리즘을 적용한다.
- 합성수를 순서대로 체크하여, answer를 증가시킨다. (이 때, 이미 체크됐는지 여부를 한번씩 확인해야 중복을 방지할 수 있다.)

---
