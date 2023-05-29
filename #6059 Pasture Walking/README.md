# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" class="solvedac-tier"> [Pasture Walking](https://www.acmicpc.net/problem/6059) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|61437156|jbin3031|맞았습니다!! |23988KB|244ms|Java 11|2315B|

## 문제
<p>The N cows (2 <= N <= 1,000) conveniently numbered 1..N are grazing among the N pastures also conveniently numbered 1..N. Most conveniently of all, cow i is grazing in pasture i.</p>

<p>Some pairs of pastures are connected by one of N-1 bidirectional walkways that the cows can traverse. Walkway i connects pastures A_i and B_i (1 <= A_i <= N; 1 <= B_i <= N) and has a length of L_i (1 <= L_i <= 10,000).</p>

<p>The walkways are set up in such a way that between any two distinct pastures, there is exactly one path of walkways that travels between them. Thus, the walkways form a tree.</p>

<p>The cows are very social and wish to visit each other often. Ever in a hurry, they want you to help them schedule their visits by computing the lengths of the paths between Q (1 <= Q <= 1,000) pairs of pastures (each pair given as a query p1,p2 (1 <= p1 <= N; 1 <= p2 <= N).</p>

## 입력
<ul>
	<li>Line 1: Two space-separated integers: N and Q</li>
	<li>Lines 2..N: Line i+1 contains three space-separated integers: A_i, B_i, and L_i</li>
	<li>Lines N+1..N+Q: Each line contains two space-separated integers representing two distinct pastures between which the cows wish to travel: p1 and p2</li>
</ul>

<p> </p>

## 출력
<ul>
	<li>Lines 1..Q: Line i contains the length of the path between the two pastures in query i.</li>
</ul>

<p> </p>

