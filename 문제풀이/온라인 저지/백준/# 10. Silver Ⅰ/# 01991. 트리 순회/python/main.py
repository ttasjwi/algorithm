import sys

print = sys.stdout.write


def main():
    input = sys.stdin.readline
    nodes = {}
    for i in range(int(input())):
        v, l, r = input().split()
        nodes[v] = (l if l != '.' else None, r if r != '.' else None)
    pre_order_dfs(nodes, 'A')
    print('\n')
    in_order_dfs(nodes, 'A')
    print('\n')
    post_order_dfs(nodes, 'A')


def pre_order_dfs(nodes, node):
    if not node:
        return
    print(node)
    pre_order_dfs(nodes, nodes[node][0])
    pre_order_dfs(nodes, nodes[node][1])


def in_order_dfs(nodes, node):
    if not node:
        return
    in_order_dfs(nodes, nodes[node][0])
    print(node)
    in_order_dfs(nodes, nodes[node][1])


def post_order_dfs(nodes, node):
    if not node:
        return
    post_order_dfs(nodes, nodes[node][0])
    post_order_dfs(nodes, nodes[node][1])
    print(node)


main()
