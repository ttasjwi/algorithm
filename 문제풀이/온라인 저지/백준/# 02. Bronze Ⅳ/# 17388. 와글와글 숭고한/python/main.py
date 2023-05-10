s, k, h = map(int, input().split())
min_value = min(s, k, h)

if s+k+h >= 100:
    print("OK")
else:
    if s == min_value:
        print("Soongsil")
    elif k == min_value:
        print("Korea")
    else:
        print("Hanyang")
