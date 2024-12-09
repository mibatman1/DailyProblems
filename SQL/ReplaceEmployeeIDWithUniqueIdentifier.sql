-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/?envType=study-plan-v2&envId=top-sql-50
select e.name, u.id from employee as e left join employeeuni u on u.id=e.id;