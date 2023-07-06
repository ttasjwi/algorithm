# n : 리스트에 있는 점수들의 갯수 (0<= n <= p)
# s : 태수의 새로운 점수
# p : 랭킹 리스트에 올라갈 수 있는 점수의 갯수(10<=p<=50)
n, my_score, p = map(int, input().split())

# n이 0인 경우 무조건 1등
if n == 0:
    print(1)
    exit(0)

scores = [2_000_000_001] + list(map(int, input().split()))

# 0 <= n <= p 에서, n == p이고, my_score가 꼴등보다 더 작거나 같은 경우, 등수를 매길 수 없음
if n == p and scores[-1] >= my_score:
    print(-1)
    exit(0)

rank = n + 1  # 꼴등으로 초기화
for idx in range(1, n + 1):
    # 나와 동점이거나 내가 더 크면 그 위치가 바로 내 등수
    if scores[idx] <= my_score:
        rank = idx
        break
print(rank)
