import sys
input = sys.stdin.readline

a, b = map(int, input().split())
if a % 2 and b % 2: 
    print(a * b - 1)
else:
    print(a * b)