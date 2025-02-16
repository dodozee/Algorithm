# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/2.svg" class="solvedac-tier"> [Celebrity jeopardy](https://www.acmicpc.net/problem/3765) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|90157242|jbin3031|맞았습니다!! |14080KB|92ms|Java 11|497B|

## 문제
<p>It’s hard to construct a problem that’s so easy that everyone will get it, yet still difficult enough to be worthy of some respect. Usually, we err on one side or the other. How simple can a problem really be?</p>

<p>Here, as in Celebrity Jepoardy, questions and answers are a bit confused, and, because the participants are celebrities, there’s a real need to make the challenges simple. Your program needs to prepare a question to be solved --- an equation to be solved --- given the answer. Specifically, you have to write a program which finds the simplest possible equation to be solved given the answer, considering all possible equations using the standard mathematical symbols in the usual manner. In this context, simplest can be defined unambiguously several different ways leading to the same path of resolution. For now, find the equation whose transformation into the desired answer requires the least effort.</p>

<p>For example, given the answer X = 2, you might create the equation 9 – X = 7. Alternately, you could build the system X > 0; X^2 = 4. These may not be the simplest possible equations. Solving these mind-scratchers might be hard for a celebrity.</p>

## 입력
<p>Each input line contains a solution in the form =</p>

## 출력
<p>For each input line, print the simplest system of equations which would to lead to the provided solution, respecting the use of space exactly as in the input.</p>

