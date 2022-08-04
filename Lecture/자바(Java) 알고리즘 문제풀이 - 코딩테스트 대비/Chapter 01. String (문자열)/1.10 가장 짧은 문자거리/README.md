# 1.10 가장 짧은 문자거리

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.10)

---

## 풀이1: (내 삽질) 왼쪽, 오른쪽 최소거리 비교
```java
   private static String solution(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            String leftString = word.substring(0,i);
            String rightString = word.substring(i);

            int minDistance = Math.min(getLeftDistance(ch, leftString), getRightDistance(ch, rightString));
            sb.append(minDistance).append(' ');
        }
        return sb.toString();
    }
```
- 왼쪽, 오른쪽(현재 인덱스 포함) 문자열을 쪼갠 뒤
  - 왼쪽 문자열은 오른쪽 끝으로부터 찾는 문자의 거리를 계산(없으면 Integer.MAX_VALUE)
  - 오른쪽 문자열은 왼쪽 끝으로부터 찾는 문자의 거리를 계산(없으면 Integer.MAX_VALUE)
- 뒤 거리를 비교하여 최솟값을 계산하고 StringBuilder로 붙인다.

### 왼쪽 거리 계산
```java
    private static int getLeftDistance(char ch, String leftString) {
        int leftDistance = Integer.MAX_VALUE;
        for (int j = 0; j< leftString.length(); j++) {
            int currentIndex = leftString.length() - 1 - j;

            if (leftString.charAt(currentIndex) == ch) {
                leftDistance = j+1;
                break;
            }
        }
        return leftDistance;
    }
```
### 오른쪽 거리 계산
```java
    private static int getRightDistance(char ch, String rightString) {
        int rightIndex = rightString.indexOf(ch);
        return (rightIndex == -1) ? Integer.MAX_VALUE : rightIndex;
    }
```

---

## 풀이2. 왼쪽거리, 오른쪽 거리 비교

### 시간복잡도
- 문자열 길이만큼 두번 왼쪽 오른쪽을 한번씩 탐색함
- 시간복잡도는 O(N)

### 흐름
```java
    private static String solution(String word, char ch) {
        int[] distances = calculateLeftDistances(word, ch);
        updateMinDistances(word, ch, distances);
        return buildAnswerString(distances);
    }
```
- 왼쪽 문자로부터 떨어진 최소 거리를 계속 갱신
- 오른쪽 문자로부터 떨어진 거리, 위에서 계산한 왼쪽 거리를 비교하면서 최소 거리를 계속 갱신.
- 배열을 기반으로 결과 생성

### 왼쪽 거리 계산
```java
   private static int[] calculateLeftDistances(String word, char ch) {
        int[] distances = new int[word.length()];
        int leftDistance = 1000; // 왼쪽으로부터 떨어진 거리

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                leftDistance = 0; // 같은 문자이면 떨어진 거리를 0으로 갱신
            }
            distances[i] = leftDistance;
            leftDistance++;
        }
        return distances;
    }

```
- 왼쪽의 문자로부터 떨어진 거리를 1000정도로 잡는다.
- 오른쪽으로 이동하면서, 같은 문자이면 왼쪽 거리를 0으로 갱신한다.
- 현재 왼쪽거리를 배열에 주입한다.

### 오른쪽 거리 비교, 배열 갱신
```java
    private static void updateMinDistances(String word, char ch, int[] distances) {
        int rightDistance = 1000;

        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == ch) {
                rightDistance = 0;
            }
            distances[i] = Math.min(distances[i], rightDistance);
            rightDistance++;
        }
    }
```
- 오른쪽으로부터 떨어진 거리를 1000으로 잡는다.
- 왼쪽으로 가면서 위와 같은 방식으로 오른쪽 거리를 계산한다.
- 앞에서 계산해둔 왼쪽거리와 오른쪽 거리를 비교하여 더 작은 값으로 배열을 갱신한다.

### 결과 문자열 생성
```java
    private static String buildAnswerString(int[] distances) {
        StringBuilder sb = new StringBuilder();
        for (int distance : distances) {
            sb.append(distance).append(' ');
        }
        return sb.toString();
    }

```
- StringBuilder를 활용하여 결과 문자열을 생성한다.

---
