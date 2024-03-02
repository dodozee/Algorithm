# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/1.svg" class="solvedac-tier"> [Rats](https://www.acmicpc.net/problem/18301) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|74308312|jbin3031|맞았습니다!! |17564KB|204ms|Java 11|285B|

## 문제
<p>To celebrate the Lunar New Year of the Rat, Douglas decides to count the number of rats living in his area. It is impossible for him to find all rats, as they tend to be well hidden. However, on the first day of the new year, Douglas manages to capture n<sub>1</sub> rats, and marks each of them with an ear tag before releasing them. On the second day of the new year, Douglas captures n<sub>2</sub> rats, and observes that n<sub>12</sub> of them had been marked during the first day.</p>

<p>Douglas is asking for your help to estimate the total number of rats in his area. Looking up in your statistics textbook, you propose using the Chapman estimator N, given by:</p>

<p style="text-align: center;">N := ⌊(n<sub>1</sub> + 1)(n<sub>2</sub> + 1)/(n<sub>12</sub> + 1) - 1⌋</p>

<p>where ⌊x⌋ is the floor of a real number x, i.e., the closest integer less than or equal to x.</p>

## 입력
<p>The input consists of a single line, with three space-separated integers: n<sub>1</sub>, n<sub>2</sub>, n<sub>12</sub>, in that order.</p>

## 출력
<p>The output should contain a single line with the single integer N.</p>

