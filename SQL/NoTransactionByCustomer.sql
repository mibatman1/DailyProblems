-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/?envType=study-plan-v2&envId=top-sql-50

select v.customer_id, count(visit_id) as count_no_trans from visits v where v.visit_id not in
(select visit_id from transactions) group by v.customer_id;