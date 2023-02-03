import re

answer = int(re.sub(r'[^0-9]', '', input()))
print(answer, end='')
