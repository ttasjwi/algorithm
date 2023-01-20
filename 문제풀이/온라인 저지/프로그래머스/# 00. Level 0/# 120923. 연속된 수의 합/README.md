# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120923
- 제목 : 연속된 수의 합
- 난이도 : Level 0
- 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/120923" target="_blank">링크</a>

---

# 필요 알고리즘
- 풀이1) 슬라이싱 윈도우
- 풀이2) 

---

## 풀이1 : 슬라이싱 윈도우
```python
def solution(num, total):
    lt = 0
    rt = num - 1
    current_sum = sum(i for i in range(lt, rt+1))

    while True:
        if current_sum == total:
            break

        elif current_sum > total:
            current_sum -= rt
            rt -= 1
            lt -= 1
            current_sum += lt

        else:
            current_sum -= lt
            lt += 1
            rt += 1
            current_sum += rt

    return [i for i in range(lt, rt + 1)]
```

- 슬라이싱 윈도우를 사용한다.
- 시작점을 일단 0, 끝점을 num-1로 잡고 이들의 합을 모두 더한다.
- 윈도우를 밀어가면서(lt, rt를 조절) 합을 계산하고, 조건에 부합하면 결과를 반환한다.

## 풀이2: 등차수열의 성질 이용
```python
def solution(num, total):
    average = total//num
    lt = average - (num-1)//2
    rt = average + num//2
    return [i for i in range(lt, rt+1)]
```
```java
public class Solution {

    public int[] solution(int num, int total) {
        int average = total / num;
        int lt = average - (num - 1) / 2;

        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = i + lt;
        }
        return answer;
    }

}

```
- 연속된 수들이므로 가운데 값을 기준으로 증감이 대칭된다.
- 우선 가운데에 위치한 정수를 구한다. total을 num으로 나눈 몫이 기준점이다.
  - 홀수일 때는 딱 나누어 떨어지므로 왼쪽-오른쪽의 갯수가 같다.
  - 짝수일 때는 왼쪽이 하나 적고 오른쪽이 더 많다.
- 홀,짝 케이스 분류를 해야하는데, 위와 같은 식을 사용하면 홀짝 구분없이 양끝을 구할 수 있다.
- 양끝을 기준으로 리스트를 생성해 반환한다.
- 이 풀이가 가장 빠르다.

---
