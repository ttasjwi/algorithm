
# \[BOJ 15787\] 기차가 어둠을 해치고 은하수를

= 난이도 : Silver2
- 은하수를 건널 수 있는 기차의 갯수 구하기
- 문제: <a href="https://www.acmicpc.net/problem/15787" target="_blank"> [링크]</a>
- 소스 코드
    - 내 풀이 : <a href="src/Main.java" target="_blank">Main</a>

---

## 문제 읽기

탄다 : true
비어있다 : false

- 1명령 : 열차의 특정 칸의 값을 true로 변경... 리스트인가?
- 2명령 : 열차의 특정 칸의 값을 false로 변경하는 상황이군...!
- 3명령 : 오른쪽으로 밀어버린다... Queue인가?
- 4명령 : 왼쪽으로 밀어버린다... Deque 인가?

- 같은 자리 배치구조이면 은하수를 건널 수 없다. -- 중복을 허용하지 않는다!

---

## 생각

탄다, 비어있다는 것은 처음 생각한대로 이분적인 문제인 것 같아서 그대로 사용하기로 했습니다.
근데 제가 아는 내에서 특정 인덱스의 값을 변경할 수 있으면서 Deque의 성격을 가진 자료구조는 없었습니다.
자바에서 LinkedList는 이들을 구현한 것이라서 이렇게 풀수는 있을 것 같긴 했는데 이는 자바의 특정 라이브러리에 종속된 풀이라서 이렇게 풀면 안 될겠다는 생각이 들었습니다.

---

## 힌트 읽기

![image](https://user-images.githubusercontent.com/88282356/157349555-e72eda88-2b4a-4673-8a59-f40b94eb1908.png)

- 비트마스킹... 그러고보면 CS때 다른 고수분들이 비트연산자를 이용해 정수값을 조작하는 것이 생각났습니다.
- 결국은 true, false라는 이분적인 상황을 다루는 것이라는 점에서... 딱 이 키워드 읽고 무릎을 딱 쳤습니다. 아아...!
- 근데 제가 비트를 다루는 기법에는 익숙하지 않아서 일단 자바의 정석, 인터넷을 검색하면서 비트연산자에 대해 찾아보았습니다.

---

## 필요 개념

- `&` : And(둘다 1이면 1)
- `|` : or (적어도 하나가 1이면 1)
- `^` : XOR (비트가 다르면 1)
- `~` : Not (모든 비트 뒤집기)
- `<<` : 비트들을 왼쪽으로 밀기
- `>>` : 비트들을 오른쪽으로 밀기 (맨앞 비트는 부호인데 이 부호는 유지하면서 밀기)
- `>>>` : 비트들을 오른쪽으로 밀기(맨앞 비트는 부호인데 이 비트를 유지하지 않음)
- int는 4바이트, 즉 32비트
- 0은 000000...0이다.
- 1은 00000...1이다.
- Interge.MIN_VALUE는 100000..... 이다.

---

## 코드로 작성하기

### 변수할당
```java
    private static final int RESET_BIT = 0b1111_1111_1111_1111_1111_0000_0000_0000;
```
- RESET_BIT : 리셋할 비트입니다. 좌석은 20칸 제한인데 int는 32비트다보니 좌석을 조작하다보면 20번째 자리 이후의 값은 다시 0으로 돌려야하기 때문에 추후 서술할 로직을 위해서 RESET_BIT의 정의가 필요했습니다.

```java
        int N = readInt();
        int M = readInt();

        int[] trains = new int[N];

        int command, trainIndex, sitIndex;
```
- N : 기차 수
- M : 명령의 횟수
- 비트를 조작하는 것이기 때문에 복잡하게 컬렉션을 쓰지 않고 자리배치는 int와 비트조작만으로 할 수 있겠더라구요. 그래서 심플하게 배열을 쓰기로 했습니다. int 배열은 처음 생성시 초깃값이 0인데 이것의 비트배치는 0000...000입니다. 0은 자리가 없다로 생각하면 되니 별도로 초기값을 바꿀 필요는 없습니다.
- command : 명령
- traianIndex : 기차의 인덱스(0~19)
- sitIndex : 좌석의 인덱스(0~19)

### 명령 로직
```java
        for (int i = 0; i < M; i++) {
            command = readInt();
            if (command == 1) {
                trainIndex = readInt() - 1;
                sitIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] | prepareSitBit(sitIndex);
            } else if (command == 2) {
                trainIndex = readInt() - 1;
                sitIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] & (~prepareSitBit(sitIndex));
            } else if (command == 3) {
                trainIndex = readInt() - 1;
                trains[trainIndex] = removeAbove20(trains[trainIndex] >>> 1);
            } else {
                trainIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] << 1;
            }
        }
```
- 처음 입력받는 값은 명령, 두번쨰 입력값은 열차번호, 세번째 입력값은 자리 인덱스입니다.
- command가 1일때 : 열차의 특정칸을 사람이 있는 상태로 만들어야합니다. prepareSitBit 메서드는 0...000의 앞에서부터 i번째 칸을 1로 한 정수를 반환하는 메서드로 제가 정의했는데, 이렇게 해놓고 | 연산을 쓰면 or연산에 의해 해당 칸의 비트는 무조건 1이 됩니다.
- command가 2일때 : 열차의 특정칸을 사람이 없는 상태로 만들어야합니다. prepareSitBit 메서드에 not 연산을 붙이면 111...11 의 앞에서부터 i번째 칸을 0으로 한 정수가 됩니다. 이렇게 해놓고 & 연산을 쓰면 0인 나머지 칸은 상태를 유지하고, 부분은 무조건 0이 되버립니다.
- commanad가 3일 때 : 비트를 오른쪽으로 밀어야합니다. `>>` 연산은 부호가 있으니 이걸 쓰면 맨 앞 비트 상태가 유지된니 `>>>`을 써야합니다. 대신 여기서 주의할 것은 20번째 이후의 비트들이 있어서 `>>>`로 밀어도 그 뒤의 값이 사라지지 않습니다. 그래서 RESET_BIT와 removeAbove20(...) 메서드를 만들었습니다. 이렇게 하면 20번째 이후의 비트를 0으로 만들 수 있습니다.
- command가 4일때 : 비트를 오른쪽으로 밀기만 하면 됩니다.

---

## 은하수 건널 수 있는 열차 갯수 처리

```java
        Set<Integer> trainSet = new HashSet<>();
        for (int train : trains) {
            trainSet.add(train);
        }
        System.out.print(trainSet.size());
```
- 은하수를 건널 수 있다 = 중복되지 않는다 = Set으로 처리했습니다.

---

## 분리 메서드 1 : prepareSitBit
```java

```
    // 좌석에 해당하는 자리에 1(비트)을 둔다.
    private static int prepareSitBit(int sitIndex) {
        int sitBit = Integer.MIN_VALUE;
        for (int i = 0; i < sitIndex; i++) {
            sitBit = sitBit >>> 1;
        }
        return sitBit;
    }
---
- Integer.MIN_VALUE는 10000.....0 입니다.
- sitIndex만큼 오른쪽으로 밀어주면 됩니다.
- `>>>`으로 밀어야합니다. `>>`으로 밀면 맨 왼쪽 값이 유지됩니다.

## 분리메서드 2 : removeAbove20
```java
    private static final int RESET_BIT = 0b1111_1111_1111_1111_1111_0000_0000_0000;
```
- 20번째 이후 값을 0으로 뒀습니다.
```java
 private static int removeAbove20(int trainBit) {
        return trainBit & RESET_BIT;
    }
```
- RESET비트와 And연산을 하면 20번쨰 이후 값을 무조건 0으로 만들 수 있습니다.

---
## 결과

![image](https://user-images.githubusercontent.com/88282356/157351811-2af35035-aa44-4840-8bd6-8bd46ca610e3.png)
192ms

---

## 소감

비트 연산이 정말 재미있는 개념이네요.
이렇게 본격적으로 문제 푸는데 사용해본건 처음인데 좋은 경험을 했던 것 같습니다.

---