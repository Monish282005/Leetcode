SELECT *
FROM Products
WHERE binary REGEXP_like(description, '\\b[S][N][0-9]{4}-[0-9]{4}\\b', 'c')
ORDER BY product_id;