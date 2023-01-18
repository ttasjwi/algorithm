# 문제
- 번호 : 120876
- 제목 : 겹치는 선분의 길이
- 난이도 : Level 0
- 두 개 이상의 선분이 겹치는 부분의 길이를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120876)

---

# 필요 알고리즘
- 방문 배열

---

# 풀이
```java
public class Solution {

    int[] check = new int[200];
    // 0 : 아직 아무 것도 겹치지 않았다
    // 1 : 한번 체크됨
    // 2 : 중복됨, 중복이 계산 됨.

    public int solution(int[][] lines) {
        int start;
        int end;

        int duplicateLength = 0;

        for (int[] line : lines) {
            start = line[0] + 100;
            end = line[1] + 100;

            for (int i=start; i<end; i++) {
                if (check[i] == 0) {
                    check[i]++;
                } else if (check[i] == 1){
                    check[i]++;
                    duplicateLength ++;
                }
            }
        }
        return duplicateLength;
    }

}
```
- 체크 배열을 생성한다. a,b의 범위는 -100 이상 100 미만이므로 200칸짜리 배열을 만들어주면 된다.
  - 0 : 아무 것도 겹치지 않은 상태.
  - 1 : 하나라도 선분이 있는 상태
  - 2 : 중복된 선분이 있는 상태
- 라인을 읽어와서, 시작 인덱스를 start, 종점 인덱스를 end라고 하자.
  - 각 인덱스는 좌표에서 100을 더하면 된다.
- start부터 end까지 순서대로 체크 배열의 해당 인덱스를 순회하면서 해당 인덱스의 값과 비교한다.
  - 0이면 아직 아무 선분이 겹치지 않은 상태다. 일단 방문처리한다.
  - 1이면 어떤 선분이 하나라도 존재한 상태이다. 중복 여부를 한 번 체크하고, 해당 인덱스의 값을 2로 갱신한다.
  그리고 dulicateLength를 증가시킨다.
  - 2이면 이미 중복 여부가 한 번 체크된 상태이다. 아무 것도 하지 않는다.
- 마지막에 duplicateLength를 반환하면 된다.

---
