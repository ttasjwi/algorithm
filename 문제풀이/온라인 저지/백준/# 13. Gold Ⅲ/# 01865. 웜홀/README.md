# 문제
![boj1865.jpg](imgs/boj1865.jpg)

- 플랫폼 : 백준
- 번호 : 01865
- 제목 : 웜홀
- 난이도 : Gold 3
- 만약에 시간이 줄어들면서 출발 위치로 돌아오는 것이 가능하면 YES, 불가능하면 NO를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1865" target="_blank">링크</a>

---

# 필요 지식, 해석
## 벨먼-포드 알고리즘
- 출발 정점에서 어떤 정점에 도착하기까지 기껏 많아봐야 N-1번의 간선을 순회하게 된다.
- 따라서 n-1번 모든 간선을 탐색하면서 이동비용을 최적화시키면 비용이 완전히 최적화된다.
- 그런데, 음의 사이클이 발생한다면 여기서 한 번 더 간선을 탐색했을 때 비용이 더 줄어드는 지점이 발생한다. 음의 가중치를 간선이 포함됐을 때
음의 사이클 발생여부 감지는 이 방식을 통해 수행하면 된다.
- 벨먼 포드 알고리즘의 시간복잡도는 O(NE)이다.

## 문제의 특수성
- 이 문제는 시작점이 주어지지 않았다. 각 지점마다 최단 거리를 구해야 했다면 음의 사이클이 포함된 상황에서도 최단 거리를 구할 수 있는 플로이드-워셜
알고리즘을 사용해야 했겠지만, 이 문제에서는 정말 순수하게 '음의 사이클 발생여부'만 확인하면 된다.
- 일반적인 최단거리를 구하는 벨먼포드 알고리즘에서는, 출발지의 비용이 무한인 곳(즉 연결되어 있지 않은 정점) 대해서는 갱신을 수행하지 않는다.
하지만, 이 문제에서는 임의의 지점에서 출발했을 때 처음 지점으로 돌아왔을 때 음의 비용이 발생하는 지 여부를 판단해야하므로, 출발지 비용가 무한 비용일 경우
필터링 시켜선 안 된다. 이를 필터링하게 될 경우 해당 케이스를 놓치게되서 오답이 된다.

---

# 풀이

## 풀이1
```python
import io, os, sys


def main():
    answer = []
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
    print = sys.stdout.write

    inf = 25_000_000

    def bf():
        for i in range(n):
            for s, e, t in edges:
                alt = dis[s] + t # 출발지의 비용이 무한인지 여부를 필터링 할 필요가 없다.
                if dis[e] > alt: 
                    if i == n - 1:
                        return 1
                    dis[e] = alt
        return 0

    for _ in range(int(input())):
        n, m, w = map(int, input().split())
        edges = []
        dis = [inf] * (n + 1)
        for _ in range(m):
            s, e, t = map(int, input().split())
            edges.append((s, e, t))
            edges.append((e, s, t))

        for _ in range(w):
            s, e, t = map(int, input().split())
            edges.append((s, e, -t))
        if bf():
            answer.append('YES')
        else:
            answer.append('NO')
    print('\n'.join(answer))


if __name__ == '__main__':
    main()
```
- 이 문제에서는 모든 지점에서 적어도 한 출발지에 대해 음의 사이클 발생 여부를 판단하면 된다.
- 따라서 출발지를 정하지 않고 모든 지점에 대해 비용 갱신을 시키면서 갱신 여부를 판단하면 된다.
- n-1번 갱신후, 마지막에 n번째에서도 갱신이 발생하면 음의 사이클이 발생된 것으로 간주한다.(문제의 상황에 따르면, 시작 지점으로 돌아올 때 음의
비용으로 돌아올 수 있다.)


## 풀이2
```python
# 생략
    def bf():
        for i in range(n):
            updated = False
            for s, e, t in edges:
                alt = dis[s] + t
                if dis[e] > alt:
                    if i == n - 1:
                        return 1
                    updated = True
                    dis[e] = alt
            if not updated:
                return 0
# 생략
```
- 위와 기본 근간은 같은데 더 최적화시킨 풀이이다.
- 음의 사이클 검출 관점에서 놓고 보면 계속 간선을 n-1번까지 순회하고, n번째에서 또 갱신되는지 판단하여 음의 사이클 존재 여부를 검출하면 된다.
- 그런데 잘 생각해보면 우리는 최단 거리를 구할 필요가 없으므로 도중에 갱신이 발생하지 않는 시점이 오면 거기서 바로 반복을 중단해도 된다.
- 매번 간선을 전부 순회하는 행위를 반복하면서, 한 번이라도 갱신이 발생된걸 감지했다면 계속 반복하고, 갱신이 한번도 안 일어나는 시점이 올 경우
거기서 그냥 반복을 중단시켜버린다.
- n번째 시점까지 계속 갱신이 일어났다면 음의 사이클이 존재하는 것이다.

---

# 결과

![boj1865-result1](imgs/boj1865-result1.png)

![boj1865-result2](imgs/boj1865-result2.png)

- 1번 풀이는 순수하게 n-1번 계속 갱신하고, n번째에서 갱신 여부를 판단하기 때문에 892ms 정도 소요된다.
- 반면 도중에 한번이라도 갱신되지 않으면 그냥 반복을 중단시키는 풀이의 경우 376ms 정도 소요된다.

---
