# 문제
- 플랫폼 : 백준
- 번호 : 04690
- 제목 : 완전 세제곱
- 난이도 : Bronze 3
- a3 = b3 + c3 + d3을 만족하는 1보다 큰 자연수들을 모두 출력. 같은 a3을 구할 수 있다면 b가 작은 것을 우선 출력(a <= 100, a,b,c,d > 1, b<c<d<a)
- 문제 : <a href="https://www.acmicpc.net/problem/1247" target="_blank">링크</a>

---

# 필요 지식
- 구현

---

# 풀이
## 풀이1: 4중 for문
```kotlin
fun main() {
    for (a in 5..100) {
        for (b in 2..a - 3) {
            for (c in b + 1..a - 2) {
                for (d in c + 1..a - 1) {
                    if (a * a * a == b * b * b + c * c * c + d * d * d) {
                        writeStr("Cube = ")
                        writeInt(a)
                        writeStr(", Triple = (")
                        writeInt(b)
                        writeChar(',')
                        writeInt(c)
                        writeChar(',')
                        writeInt(d)
                        writeChar(')')
                        writeByte(ASCII_n)
                    }
                }
            }
        }
    }
    flushBuffer()
}
```
- 4중 for문을 돌면서 구하는 방식
- 이게 가장 기본적인 풀이 방식이긴 하다.
- 약간 최적화를 더 해보면, 우변의 합이 더 커지는 순간 몇 군데 스킵하기?

## 풀이2
```kotlin
fun main() {
    writeStr("""Cube = 6, Triple = (3,4,5)
Cube = 12, Triple = (6,8,10)
Cube = 18, Triple = (2,12,16)
Cube = 18, Triple = (9,12,15)
Cube = 19, Triple = (3,10,18)
Cube = 20, Triple = (7,14,17)
Cube = 24, Triple = (12,16,20)
Cube = 25, Triple = (4,17,22)
Cube = 27, Triple = (3,18,24)
Cube = 28, Triple = (18,19,21)
Cube = 29, Triple = (11,15,27)
Cube = 30, Triple = (15,20,25)
Cube = 36, Triple = (4,24,32)
Cube = 36, Triple = (18,24,30)
Cube = 38, Triple = (6,20,36)
Cube = 40, Triple = (14,28,34)
Cube = 41, Triple = (2,17,40)
Cube = 41, Triple = (6,32,33)
Cube = 42, Triple = (21,28,35)
Cube = 44, Triple = (16,23,41)
Cube = 45, Triple = (5,30,40)
Cube = 46, Triple = (3,36,37)
Cube = 46, Triple = (27,30,37)
Cube = 48, Triple = (24,32,40)
Cube = 50, Triple = (8,34,44)
Cube = 53, Triple = (29,34,44)
Cube = 54, Triple = (6,36,48)
Cube = 54, Triple = (12,19,53)
Cube = 54, Triple = (27,36,45)
Cube = 56, Triple = (36,38,42)
Cube = 57, Triple = (9,30,54)
Cube = 58, Triple = (15,42,49)
Cube = 58, Triple = (22,30,54)
Cube = 60, Triple = (21,42,51)
Cube = 60, Triple = (30,40,50)
Cube = 63, Triple = (7,42,56)
Cube = 66, Triple = (33,44,55)
Cube = 67, Triple = (22,51,54)
Cube = 69, Triple = (36,38,61)
Cube = 70, Triple = (7,54,57)
Cube = 71, Triple = (14,23,70)
Cube = 72, Triple = (8,48,64)
Cube = 72, Triple = (34,39,65)
Cube = 72, Triple = (36,48,60)
Cube = 75, Triple = (12,51,66)
Cube = 75, Triple = (38,43,66)
Cube = 76, Triple = (12,40,72)
Cube = 76, Triple = (31,33,72)
Cube = 78, Triple = (39,52,65)
Cube = 80, Triple = (28,56,68)
Cube = 81, Triple = (9,54,72)
Cube = 81, Triple = (25,48,74)
Cube = 82, Triple = (4,34,80)
Cube = 82, Triple = (12,64,66)
Cube = 82, Triple = (19,60,69)
Cube = 84, Triple = (28,53,75)
Cube = 84, Triple = (42,56,70)
Cube = 84, Triple = (54,57,63)
Cube = 85, Triple = (50,61,64)
Cube = 87, Triple = (20,54,79)
Cube = 87, Triple = (26,55,78)
Cube = 87, Triple = (33,45,81)
Cube = 87, Triple = (38,48,79)
Cube = 88, Triple = (21,43,84)
Cube = 88, Triple = (25,31,86)
Cube = 88, Triple = (32,46,82)
Cube = 89, Triple = (17,40,86)
Cube = 90, Triple = (10,60,80)
Cube = 90, Triple = (25,38,87)
Cube = 90, Triple = (45,60,75)
Cube = 90, Triple = (58,59,69)
Cube = 92, Triple = (6,72,74)
Cube = 92, Triple = (54,60,74)
Cube = 93, Triple = (32,54,85)
Cube = 95, Triple = (15,50,90)
Cube = 96, Triple = (19,53,90)
Cube = 96, Triple = (48,64,80)
Cube = 97, Triple = (45,69,79)
Cube = 99, Triple = (11,66,88)
Cube = 100, Triple = (16,68,88)
Cube = 100, Triple = (35,70,85)"""
    )
    flushBuffer()
}
```
- 출력문이 몇 개 안 되고, 위의 방식으로 구한 것들을 그냥 다 생짜로 출력하면 된다.
- 이게 제일 빠를 수밖에 없다.

---
