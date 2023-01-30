def bubble_sort(l):
    for i in range(len(l) - 1):
        for j in range(0, len(l) - 1):
            if l[j] > l[j + 1]:
                l[j], l[j + 1] = l[j + 1], l[j]
    return l


l = [5, 4, 3, 2, 1]
print(bubble_sort(l))
