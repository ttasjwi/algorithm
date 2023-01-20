def solution(num, total):
    average = total//num
    lt = average - (num-1)//2
    rt = average + num//2
    return [i for i in range(lt, rt+1)]

