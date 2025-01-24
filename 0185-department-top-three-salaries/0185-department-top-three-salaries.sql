WITH sub AS (
  SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary,
    DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS rk
  FROM
    Employee e
  JOIN
    Department d ON e.departmentId = d.id
)
SELECT Department, Employee, Salary
FROM
  sub
WHERE
  rk <= 3;
