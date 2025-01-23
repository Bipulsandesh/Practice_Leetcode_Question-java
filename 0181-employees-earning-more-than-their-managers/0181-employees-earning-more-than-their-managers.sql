# Write your MySQL query statement below
select E1.name as Employee from Employee E1 Join Employee E2 on E1.managerId = E2.Id
where E1.salary > E2.salary
