# 문제
- 번호 : 120875
- 제목 : 평행
- 난이도 : Level 0
- 주어진 네 개의 점을 두 개씩 이었을 때, 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120875)

---

# 필요 알고리즘
- 기울기

---

# 풀이
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[][] dots) {
        boolean[][] checked = new boolean[4][4];
        for (int i = 0; i < checked.length; i++) {
            checked[i][i] = true;
        }
        
        Set<Double> gradients = new HashSet<>();
        boolean hasInfinity = false;
        
        double xDiff;
        double yDiff;
        double gradient;
        
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if (!checked[i][j]) {
                    checked[i][j] = checked[j][i] = true;

                    xDiff = dots[i][0] - dots[j][0];

                    if (xDiff == 0) {
                        if (hasInfinity) {
                            return 1;
                        }
                        hasInfinity = true;
                        continue;
                    }

                    yDiff = dots[i][1] - dots[j][1];
                    gradient = yDiff / xDiff;

                    if (gradients.contains(gradient)) {
                        return 1;
                    }
                    gradients.add(gradient);
                }
            }
        }
        return 0;
    }

}
```
- checked : 방문 배열
- gradients : 기울기 집합
- hasInfinity : y축에 평행한 직선이 있을 경우 체크
- 두 점들간의 기울기를 계산하고 그 결과를 gradients에 담는다.
  - 이 때 기울기가 무한인 경우, 즉 x 좌표 차가 0인 경우는 hasInfinity 를 true로 갱신한다. 이 후 기울기가 무한인 다른 선분이
  또 등장하면 이떄는 1을 리턴한다.
- gradients에 이미 포함된 기울기가 등장하면 1을 리턴한다.
- 모두 순회하여도 중복되는 기울기가 없다면 0을 리턴한다.

---
