# \[BOJ10818] 최소, 최대

- 난이도 : Bronze3
- 숫자의 갯수가 주어지고, 숫자들이 주어질 때 최대 최소 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/10818" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>
- 블로그 정리 : <a href="https://ttasjwi.tistory.com/30" target="_blank">[백준] 10818번: 최소, 최대 - Java</a>

---  

## Main.java : 백준 제출 답안

### 1) main 메서드
- 숫자의 갯수 입력 받기
- 숫자의 갯수만큼 반복을 돌려서 숫자를 입력받고, 최대 최소를 누적 계산을 통해 구한다.
  - 최댓값보다 값이 크면 최댓값 갱신
  - 최솟값보다 값이 작으면 최솟값 갱신
- 위의 과정을 모두 거쳤을 때 최대 최소를 StringBuilder로 문자열 결합하여 `System.out.pringln`문으로 출력


### 2) readInt 메서드
```
    private static int readInt() throws IOException {
        boolean isNegative = false; // 음수니?
        int value = 0;
        while (true) {
            // 입력 문자의 ASCII코드 값.
            // 가령 '0'이 들어왔으면 숫자 0이 아니라 '0'의 ASCII 코드값인 48이다.
            int input = System.in.read(); 
            if (input == ' '||input=='\n') { // 개행문자거나 공백이면 연산을 끊음
                return (isNegative)
                        ? -1 * value // 음수면 - 붙여서 반환
                        : value; // 양수면 그냥 반환
            } else  if (input == '-') { // 문자를 읽었는데 -가 붙어있으면 이 값은 음수임
                isNegative = true;
            } else {
                value = value * 10 + (input - 48); // 기존 값을 10배하고 입력된 추가값을 파싱하여 더함
            }
        }
    }
```
- 내부적으로 boolean `isNegative` 값이 존재함 : 음수이면 true, 양수이면 false
- int `value` : 최종반환할 값을 이 값에 누적함
- `System.in.read()` 메서드 활용
  - 사용자로부터 입력받은 문자를 바로 입력 문자의 ASCI 코드에 대응되는 int의 형태로 반환함.
    - 예> '0' -> 48, '1' -> 49, ...
- 사용자 입력에 대해 다음과 같이 처리
  1. ' ' 또는 '\n' : 개행문자이거나 공백일 때
     - `isNegative`가 false이면 value값을 그대로 반환 (양수)
     - `isNegative`가 true이면 value 값에 -1을 곱하여 반환 (음수)
  2. '-' : isNegative의 저장값을 true로 함
  3. 그 외(숫자) : value값에 10을 곱하고 입력 값을 숫자로 파싱하여 저장.
     - 예 : 기존에 1이 저장되어있고, '5'를 입력받으면 1에 10을 곱하고, '5'에서 '0'(48)을 빼서, 15가 value에 저장됨
  
---

## Review
- 한줄로 라인을 입력받아보니 속도가 느려짐.
- 맨처음엔 숫자의 갯수를 왜 따로 입력받나 싶었는데,  
  숫자값의 갯수를 쪼개주고 readInt로 공백문자, 개행문자 기점으로 값들을 쪼개주니 문자열의 길이가 짧아지니 소요 메모리가 더 줄어들고 속도가 빨라짐.
- 브론즈3 짜리 문제지만, 상위권 사람들이 이 문제를 풀 때 왜 메서드를 따로 정의해줬나 코드를 곱씹어보니 배울게 많았다.

---