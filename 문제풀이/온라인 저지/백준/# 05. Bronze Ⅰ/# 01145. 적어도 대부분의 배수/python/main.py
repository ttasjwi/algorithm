nums = list(map(int, input().split()))
def gcd(a,b):
    if a < b:
        a, b = b, a
    r = a % b
    return b if r == 0 else gcd(b, r)

def lcm(a,b):
    return a * b // gcd(a,b)

answer = 1000000
for x in range(3):
    for y in range(x+1, 5):
        for z in range(y+1, 5):
            answer = min(answer, lcm(lcm(nums[x], nums[y]), nums[z]))
print(answer, end ='')
