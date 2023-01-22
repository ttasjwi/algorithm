from typing import List


def solution(sizes: List[int]):

    max_width, max_height = -1, -1
    for size in sizes:
        width, height = (size[0], size[1]) if size[0] >= size[1] else (size[1], size[0])

        if width > max_width:
            max_width = width
        if height > max_height:
            max_height = height

    return max_width * max_height
