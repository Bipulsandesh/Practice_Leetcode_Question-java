# Write your MySQL query statement below
SELECT DISTINCT 
l1.num as ConsecutiveNums
FROM Logs l1
INNER JOIN Logs l2 on l1.id = l2.id - 1 AND l1.num = l2.num
INNER JOIN Logs l3 on l2.id = l3.id - 1 AND l2.num = l3.num
