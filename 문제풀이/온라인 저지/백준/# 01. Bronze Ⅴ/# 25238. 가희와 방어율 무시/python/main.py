# a : 몬스터의 방어율, b : 유저의 방무
a, b = map(int, input().split())
end_shield_rate = a - a * (b / 100)
print(0 if end_shield_rate >= 100 else 1)
