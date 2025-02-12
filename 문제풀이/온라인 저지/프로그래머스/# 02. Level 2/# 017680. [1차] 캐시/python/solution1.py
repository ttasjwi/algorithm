from collections import deque

def solution(cacheSize, cities):
    cache = deque()

    time = 0
    for city in cities:
        city = city.lower()
        if city in cache:
            time += 1
            cache.remove(city)
            cache.append(city)
        else:
            time += 5
            if cacheSize:
                if len(cache) == cacheSize:
                    cache.popleft()
                cache.append(city)
    return time
