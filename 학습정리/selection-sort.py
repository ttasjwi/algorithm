def selection_sort(array):
    for idx in range(len(array) - 1):
        min_idx = idx
        for j in range(idx + 1, len(array)):
            if array[j] < array[min_idx]:
                min_idx = j
        array[idx], array[min_idx] = array[min_idx], array[idx]
    return array


array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
print(selection_sort(array))

