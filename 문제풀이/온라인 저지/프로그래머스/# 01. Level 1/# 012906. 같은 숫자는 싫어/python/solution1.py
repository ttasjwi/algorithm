def solution(arr):
    return [value for idx, value in enumerate(arr) if idx == 0 or value != arr[idx-1]]
