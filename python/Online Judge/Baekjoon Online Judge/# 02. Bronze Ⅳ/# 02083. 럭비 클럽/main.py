import sys

input = lambda: sys.stdin.readline()

while True:
    name, age, weight = input().split()

    age, weight = int(age), int(weight)
    if name == '#' and age == weight == 0:
        break
    print(name, 'Senior' if age > 17 or weight >= 80 else 'Junior')
