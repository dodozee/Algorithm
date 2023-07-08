# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/7.svg" class="solvedac-tier"> [Project Teams](https://www.acmicpc.net/problem/20044) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|62162537|jbin3031|맞았습니다!! |30712KB|440ms|Java 11|826B|

## 문제
<p>코딩 프로젝트 수업을 가르치는 수찬이는 프로젝트 팀을 가능하면 공정하게 구성하려고 한다. 프로젝트 팀 하나는 두 명의 학생으로 구성되는데, 각 학생들의 코딩 역량은 모두 다르다. 각 학생은 한 팀의 팀원이어야 한다. 공정성을 높이기 위해 수찬이는 팀원 코딩 역량의 합을 최대한 일정하게 유지하려고 한다. 학생들이 코딩 역량이 주어졌을 때 수찬이가 팀을 구성하는데 도움이 되는 프로그램을 작성하라.</p>

<p>문제를 간단하게 하기 위해, 학생 수는 2<em>n</em>이라 가정하자 (<em>n</em>은 양의 정수). 각 학생 <em>s<sub>i</sub></em>의 코딩 역량은 양의 정수 <em>w</em>(<em>s<sub>i</sub></em>)로 나타내면 한 <em>i</em>번째 팀 <em>G<sub>i</sub></em>의 코딩 역량은 <em>w</em>(<em>G<sub>i</sub></em>) = ∑<sub><em>s</em>∈<em>G<sub>i</sub></em></sub><em>w</em>(<em>s</em>)로 나타낼 수 있다. 작성할 프로그램 목적은 <em>S<sub>m</sub></em> = min{<em>w</em>(<em>G<sub>i</sub></em>) | 1 ≤ <em>i</em> ≤ <em>n</em>}이 최대화되도록 <em>n</em>개의 팀 <em>G</em><sub>1</sub>, <em>G</em><sub>2</sub>, …, <em>G<sub>n</sub></em> 을 구성하고 이때 <em>S<sub>m</sub></em>을 출력하는 것이다.</p>

<p>예를 들어, 학생들의 코딩 역량이 {1, 7, 5, 8}로 주어졌다면 (8, 1), (7, 5)로 2개의 조를 짤 수 있으며 프로그램은 9를 출력해야 한다.</p>

## 입력
<p>입력은 표준입력을 사용한다. 입력의 첫 번째 행에는 팀 수를 나타내는 양의 정수 <em>n</em>(1 ≤ <em>n</em> ≤ 5,000)이 주어진다. 그 다음 행에 학생 <em>s<sub>i</sub></em> 의 코딩 역량 <em>w</em>(<em>s<sub>i</sub></em>)를 나타내는 2<em>n</em>개의 양의 정수가 공백으로 분리되어 주어진다 (1 ≤ <em>w</em>(<em>s<sub>i</sub></em>) ≤ 100,000). 학생들의 코딩 역량은 모두 다르다. 즉, <em>i</em> ≠ <em>j</em>이면 <em>w</em>(<em>s<sub>i</sub></em>) ≠ <em>w</em>(<em>s<sub>j</sub></em>)이다.</p>

## 출력
<p>출력은 표준출력을 사용한다. 표준출력 한 행에 <em>S<sub>m</sub></em>을 출력한다.</p>
