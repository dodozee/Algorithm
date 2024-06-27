first_lst = []
second_lst = []

for _ in range(3):
    P, Y, S = input().split()
    first_lst.append(int(Y))
    second_lst.append([int(P), S])

first_lst.sort()

second_lst.sort(reverse=True)

first_team = ""
second_team = ""


for i in range(3):
    first_team += str(first_lst[i] % 100)
    second_team += second_lst[i][1][0]

    
print(first_team)
print(second_team)