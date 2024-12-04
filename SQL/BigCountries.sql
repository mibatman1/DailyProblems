-- https://leetcode.com/problems/big-countries/description/?envType=study-plan-v2&envId=top-sql-50
select name, population p, area a from world where 
p>=25000000 or a>=3000000;