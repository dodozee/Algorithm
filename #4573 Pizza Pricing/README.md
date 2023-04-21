# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/5.svg" class="solvedac-tier"> [Pizza Pricing](https://www.acmicpc.net/problem/4573) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|59714727|jbin3031|맞았습니다!! |17900KB|228ms|Java 11|942B|

## 문제
<p>Pizza has always been a staple on college campuses. After the downturn in the economy, it is more important than ever to get the best deal, namely the lowest cost per square inch. Consider, for example, the following menu for a store selling circular pizzas of varying diameter and price:</p>

<table class="table table-bordered" style="width:30%">
	<tbody>
		<tr>
			<th colspan="2">Menu</th>
		</tr>
		<tr>
			<th>Diameter</th>
			<th>Price</th>
		</tr>
		<tr>
			<td>5 inch</td>
			<td>\$2</td>
		</tr>
		<tr>
			<td>10 inch</td>
			<td>\$6</td>
		</tr>
		<tr>
			<td>12 inch</td>
			<td>\$8</td>
		</tr>
	</tbody>
</table>

<p>One could actually compute the costs per square inch, which would be approximately 10.2¢, 7.6¢, and 7.1¢ respectively, so the 12-inch pizza is the best value. However, if the 10-inch had been sold for \$5, it would have been the best value, at approximately 6.4¢ per square inch.</p>

<p>Your task is to analyze a menu and to report the <em>diameter</em> of the pizza that is the best value. Note that no two pizzas on a menu will have the same diameter or the same inherent cost per square inch.</p>

## 입력
<p>The input contains a series of one or more menus. Each menu starts with the number of options <var>N</var>, 1 ≤ <var>N</var> ≤ 10, followed by <var>N</var> lines, each containing two integers respectively designating a pizza's diameter <var>D</var> (in inches) and price <var>P</var> (in dollars), with 1 ≤ <var>D</var> ≤ 36 and 1 ≤ <var>P</var> ≤ 100. The end of the input will be designated with a line containing the number 0.</p>

## 출력
<p>For each menu, print a line identifying the menu number and the diameter <var>D</var> of the pizza with the best value, using the format shown below.</p>

