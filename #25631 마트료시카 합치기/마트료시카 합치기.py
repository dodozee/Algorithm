n = int(input())
lst = list(map(int,input().split()))

count = 0
while len(lst) > 0:
    temp = set(sorted(lst))
    
    for t in temp:
        del lst[lst.index(t)]
    count += 1

print(count)