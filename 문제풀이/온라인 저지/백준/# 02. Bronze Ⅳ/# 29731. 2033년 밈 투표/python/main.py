import sys

input = sys.stdin.readline
memes = {
    "Never gonna give you up",
    "Never gonna let you down",
    "Never gonna run around and desert you",
    "Never gonna make you cry",
    "Never gonna say goodbye",
    "Never gonna tell a lie and hurt you",
    "Never gonna stop"
}

flag = False
for i in range(int(input())):
    line = input().rstrip()
    if line not in memes:
        flag = True
        break
print('Yes' if flag else 'No')
