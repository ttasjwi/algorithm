# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042586
- 제목 : 기능개발
- 난이도 : Level 2
- 각 배포마다 몇 개의 기능이 배포되는지를 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42586" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue = LinkedList<Work>()

        for (i in 0 until progresses.size) {
            queue.offer(Work(progresses[i], speeds[i]))
        }
        var size: Int
        var cur: Work
        var isFirst: Boolean
        val deploy = ArrayList<Int>()
        var toDayDeploy: Int
        while(!queue.isEmpty()) {
            size = queue.size
            isFirst = true
            toDayDeploy = 0
            while (size-- > 0) {
                cur = queue.pop()
                cur.progress()
                if (isFirst && cur.isFinished()) toDayDeploy ++
                else {
                    isFirst = false
                    queue.offer(cur)
                }
            }
            if (toDayDeploy > 0) {
                deploy.add(toDayDeploy)
            }
        }
        return deploy.toIntArray()
    }
}

class Work(private var progress:Int, private var speed: Int) {
    fun progress() {
        if (!isFinished()) this.progress += speed
    }
    fun isFinished() = progress >= 100
}
```
- Work : 일의 진척상황 및 속도
- 큐에 작업들을 모두 순서대로 삽입한다.
- 큐가 빌 때까지 다음을 반복한다.
  - 큐의 사이즈를 size 변수에 할당한다.(그날의 일의 수)
  - 그날 일의 수만큼 다음을 반복한다.
  - 작업을 진척시킨다.
  - 첫 작업이면서 완료된 작업이면 배포 작업 수를 1 증가시킨다.
  - 그렇지 않을 경우 isFirst를 false로 변경하고 큐에 다시 작업을 삽입한다.
  - 그날 배포 작업이 0개보다 크면 배열에 작업수 삽입
- 배열 반환

---
