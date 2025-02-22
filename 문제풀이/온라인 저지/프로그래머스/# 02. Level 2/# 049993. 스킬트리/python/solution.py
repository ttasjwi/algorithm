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
