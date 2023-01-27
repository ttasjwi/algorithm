def solution(numbers):
    count = 0
    for i in range(len(numbers) - 2):
        for j in range(i + 1, len(numbers) - 1):
            for k in range(j+1, len(numbers)):
                if numbers[i] + numbers[j] + numbers[k] == 0:
                    count += 1
    return count

