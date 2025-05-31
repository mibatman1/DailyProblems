-- Write your MySQL query statement below
-- https://leetcode.com/problems/number-of-unique-subjects-taught-by-each-teacher/?envType=study-plan-v2&envId=top-sql-50
select teacher_id, count(subject_id) as cnt from Teacher;