import collections
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = collections.defaultdict(list) # 디폴트 딕셔너리

        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
        return list(anagrams.values())
