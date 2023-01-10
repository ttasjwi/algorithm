Prepare > Algorithms > Warmup > Time Conversion
## Time Conversion

---

Difficulty : Easy  
Problem : <a href="https://www.hackerrank.com/challenges/time-conversion/problem" target="_blank">link</a>

---

- Solution1 : DateTimeFormatter 를 통해 주어진 문자열을 파싱하고, 다시 재 포맷해서 해결  
- Solution2 : 주어진 문자열을 split(":|AM|PM") 메서드를 이용하여 배열로 쪼갠뒤, AMPM여부에 따라 시간값을 24시간값으로 변환 후 String.join 메서드를 이용하여 문자열을 합쳐 해결.