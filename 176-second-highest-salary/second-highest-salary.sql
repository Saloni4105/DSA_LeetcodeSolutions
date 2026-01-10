# Write your MySQL query statement below

SELECT MAX(e1.salary) AS SecondHighestSalary
FROM Employee e1
WHERE 1 =
    (
    SELECT COUNT(DISTINCT e1.salary)
    FROM Employee e2
    WHERE e2.salary > e1.salary
);
