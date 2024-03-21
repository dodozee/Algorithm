# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/8.svg" class="solvedac-tier"> [queuestack](https://www.acmicpc.net/problem/24511) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|75384614|jbin3031|맞았습니다!! |57788KB|648ms|Java 11|1524B|

## 문제
<p>한가롭게 방학에 놀고 있던 도현이는 갑자기 재밌는 자료구조를 생각해냈다. 그 자료구조의 이름은 queuestack이다.</p>

<p>queuestack의 구조는 다음과 같다. $1$번, $2$번, ... , $N$번의 자료구조(queue 혹은 stack)가 나열되어있으며, 각각의 자료구조에는 한 개의 원소가 들어있다.</p>

<p>queuestack의 작동은 다음과 같다.</p>

<ul>
	<li>$x_0$을 입력받는다.</li>
	<li>$x_0$을 $1$번 자료구조에 삽입한 뒤 $1$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 $x_1$이라 한다.</li>
	<li>$x_1$을 $2$번 자료구조에 삽입한 뒤 $2$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 $x_2$이라 한다.</li>
	<li>...</li>
	<li>$x_{N-1}$을 $N$번 자료구조에 삽입한 뒤 $N$번 자료구조에서 원소를 pop한다. 그때 pop된 원소를 $x_N$이라 한다.</li>
	<li>$x_N$을 리턴한다.</li>
</ul>

<p>도현이는 길이 $M$의 수열 $C$를 가져와서 수열의 원소를 앞에서부터 차례대로 queuestack에 삽입할 것이다. 이전에 삽입한 결과는 남아 있다. (예제 $1$ 참고)</p>

<p>queuestack에 넣을 원소들이 주어졌을 때, 해당 원소를 넣은 리턴값을 출력하는 프로그램을 작성해보자.</p>

## 입력
<p>첫째 줄에 queuestack을 구성하는 자료구조의 개수 $N$이 주어진다. ($1 \leq N \leq 100\,000$)</p>

<p>둘째 줄에 길이 $N$의 수열 $A$가 주어진다. $i$번 자료구조가 큐라면 $A_i = 0$, 스택이라면 $A_i = 1$이다.</p>

<p>셋째 줄에 길이 $N$의 수열 $B$가 주어진다. $B_i$는 $i$번 자료구조에 들어 있는 원소이다. ($1 \leq B_i \leq 1\,000\,000\,000$)</p>

<p>넷째 줄에 삽입할 수열의 길이 $M$이 주어진다. ($1 \leq M \leq 100\,000$)</p>

<p>다섯째 줄에 queuestack에 삽입할 원소를 담고 있는 길이 $M$의 수열 $C$가 주어진다. ($1 \leq C_i \leq 1\,000\,000\,000$)</p>

<p>입력으로 주어지는 모든 수는 정수이다.</p>

## 출력
<p>수열 $C$의 원소를 차례대로 queuestack에 삽입했을 때의 리턴값을 공백으로 구분하여 출력한다.</p>
