-- https://leetcode.com/problems/invalid-tweets/description/?envType=study-plan-v2&envId=top-sql-50
select tweet_id from tweets where length(content)>15;