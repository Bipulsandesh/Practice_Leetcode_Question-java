DELETE
FROM Person 
WHERE (
    id IN (
        SELECT *
        FROM (
            SELECT p1.id
            FROM Person p1, Person p2
            WHERE p1.email = p2.email AND p1.id >p2.id
        ) AS rst
    )
)