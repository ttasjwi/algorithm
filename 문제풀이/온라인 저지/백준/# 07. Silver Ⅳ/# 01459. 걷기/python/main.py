def get_cost(x, y, w, s):
    if 2 * w <= s:  # 대각선으로 가는 것보다, 가로-세로로 이동하는게 더 빠를 경우
        return (x + y) * w
    else:  # 대각선 위로 갈 때 대각선이 더 빠를 경우
        big, small = (x, y) if x >= y else (y, x)
        cost = small * s  # 둘 중 작은 길이 만큼 대각선 이동

        remainder = big - small  # 남은 이동해야하는 양

        # 대각선으로 한칸 이동하는 비용과 직선 한칸 이동하는 비용을 비교
        if w > s:  # 대각선 이동이 더 저렴할 경우
            if remainder % 2 == 0:  # 남은 모든 횟수를 대각선 위 아래로 이동
                cost += remainder * s
            else:  # 남은 모든 횟수 중 한번 빼고 모두 대각선 위아래 이동
                cost += (remainder - 1) * s + w
        else:  # 모든 횟수를 직선으로 이동
            cost += remainder * w
        return cost


print(get_cost(*map(int, input().split())))
