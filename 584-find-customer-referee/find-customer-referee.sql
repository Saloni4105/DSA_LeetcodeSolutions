# Write your MySQL query statement below
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id is NULL;

-- WHERE IFNULL(referee_id, 0) != 2 
-- its the 2nd option in this if referee id is null mak eit 0 then check is this is != 2 then return