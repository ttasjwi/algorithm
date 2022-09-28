import collections
import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = [word
                 for word in re.sub(r'\W', ' ', paragraph).lower().split()
                 if word not in banned]
        counts = collections.defaultdict(int)
        for word in words:
            counts[word] += 1
        return max(counts, key=counts.get)

