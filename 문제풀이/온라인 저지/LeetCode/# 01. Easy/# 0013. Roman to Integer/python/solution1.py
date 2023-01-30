class Solution:
    def romanToInt(self, s: str) -> int:
        dict = {'I': 1, 'A': 4, 'V': 5, 'B': 9, 'X': 10, 'E': 40, 'L': 50, 'F': 90, 'C': 100, 'G': 400, 'D': 500,
                'H': 900, 'M': 1000}
        s = s.replace('IV', 'A') \
            .replace('IX', 'B') \
            .replace('XL', 'E') \
            .replace('XC', 'F') \
            .replace('CD', 'G') \
            .replace('CM', 'H')

        return sum([dict[ch] for ch in s])
