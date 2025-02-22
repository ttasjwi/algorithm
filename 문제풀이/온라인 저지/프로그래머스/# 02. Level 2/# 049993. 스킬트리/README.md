# 문제
- 플랫폼 : 프로그래머스
- 번호 : 049993
- 제목 : 스킬트리
- 난이도 : Level 2
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/49993" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 문자열 처리

---

# 풀이
```python
def solution(skill, skill_trees):
    skill_set = set(skill) # skill 에 주어진 스킬들을 해싱
    possible_skill_trees = set(skill[0:i+1] for i in range(len(skill))) # 가능한 skill 조합

    answer = 0
    for tree in skill_trees:
        tree = convert(tree, skill_set)

        # tree 가 비어 있거나, tree 가 possible_skill_trees 에 없을 경우
        if (not tree) or (tree in possible_skill_trees):
            answer += 1
    return answer

# tree 에서 skill_set 에 없는 skill 들을 제거한 문자열 반환
def convert(tree, skill_set):
    result = []
    for s in tree:
        if s in skill_set:
            result.append(s)
    return ''.join(result)
```
- skill_set : skill 에 주어진 모든 스킬들을 해싱
- possible_skill_trees : skill 을 기반으로, 가능한 연속 스킬 획득 목록
- convert 함수
  - tree 가 주어졌을 때, tree 에서 skill_set 에 있는 스킬 문자열만 결합한 문자열 반환
- skill_trees 를 순회하면서
  - tree 를 convert 를 통해 변환한다.
  - 이렇게 변환한 결과물이 비어있거나, possible_skill_trees 에 있을 경우 answer 를 증가시킨다.
- answer 반환

