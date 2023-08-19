  # 문제
- 플랫폼 : 백준
- 번호 : 24511
- 제목 : queuestack
- 난이도 : Silver 3
- 수열 C의 원소를 차례대로 queuestack에 삽입했을 때의 리턴값을 공백으로 구분하여 출력
- 문제 : <a href="https://www.acmicpc.net/problem/24511" target="_blank">링크</a>

---

# 필요 알고리즘
- 스택
- 큐

---

# 풀이
## 풀이1: 큐를 순서대로 통과시키기 (시간 초과)
```kotlin
fun main() {
    val n = i()

    val items = IntArray(n)
    for (i in 0 until n) {
        items[i] = i().let { if (it == 1) -1 else it }
    }

    var input: Int
    for (i in 0 until n) {
        input = i()
        if (items[i] == 0) items[i] = input
    }

    val m = i()
    var x: Int
    var tmp: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        for (j in 0 until n) {
            if (items[j] > 0) {
                tmp = items[j]
                items[j] = x
                x = tmp
            }
        }
        sb.append(x).append(' ')
    }
    print(sb)
}
```
- 자료구조가 스택일 경우 입력과 출력이 같으므로 사실상 무시해도 된다.
- 자료구조가 큐일 경우 들어오고 나갈 때 기존 값과 swap 된다.
- 이 점을 이용하여 일일이 모든 자료구조를 순회하면서 큐일 경우 swap을 시켰다.
- 시간초과가 났다. 자료구조 갯수가 `1_000_000_000` 개인데 이걸 모두 순회시키기엔 시간 비용이 너무 비쌌다

## 풀이2: 전체를 거대한 큐로 보기
```kotlin
fun main() {
    val n = i()

    val nums = IntArray(n)
    for (i in 0 until n) {
        nums[i] = if (i() == 1) -1 else 0
    }

    val q = LinkedList<Int>()
    for (i in 0 until n) {
        if (nums[i] < 0) {
            i()
        } else {
            nums[i] = i()
        }
    }

    for (i in n-1 downTo 0) {
        if (nums[i] > 0) {
            q.offer(nums[i])
        }
    }

    val m = i()
    var x: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        if (!q.isEmpty()) {
            q.offer(x)
            x = q.pop()
        }
        sb.append(x).append(' ')
    }
    print(sb)
}
```
- 잘 살펴보면 스택인 구간은 통과되고, 큐인 구간은 입력값이 기존 값을 대체한다.
- 제일 끝에 있는 요소가 밀려나고 나중에 들어온 요소는 나중에 나가게 된다.
- 전체 자료구조 중 큐에 속한 값들을 x1, x2, x3, x4, ..., xi라 하면 전체 qStack은
xi, ... x4, x3,x2,x1 순으로 들어온 큐와 같다.
- 이를 이용하면, 전체를 큰 큐로 보게 되고 편리하게 풀 수 있다.
- 이 문제 상황에서는 연결 리스트를 이용해서 큐를 구현했다. 구현하는 속도는 이 방식이 제일 빠를 것 같다.

## 풀이3: 원형 큐
```kotlin
fun main() {
    val n = i()

    val nums = IntArray(n)
    for (i in 0 until n) if (i() == 1) nums[i] = -1
    for (i in 0 until n) if (nums[i] < 0) i() else nums[i] = i()

    val c = 100_001
    val qStack = IntArray(c)
    var r = 0
    for (i in n-1 downTo 0) if (nums[i] > 0) qStack[++r] = nums[i]

    var f = 0
    val s = r-f

    val m = i()
    var x: Int
    val sb = StringBuilder()
    for (i in 0 until m) {
        x = i()
        if (s != 0) {
            r = (r+1+c)%c
            qStack[r] = x

            f = (f+1+c)%c
            x = qStack[f]
        }
        sb.append(x).append(' ')
    }
    print(sb)
}
```
- 풀이2 방식을 최적화해서, 원형 큐로 구현했다. 속도는 이게 더 잘 나온다.

---
