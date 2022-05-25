CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m int;
set m = N - 1;
RETURN (
    # Write your MySQL query statement below
        select ifnull(
            (
                select distinct salary from employee order by salary desc limit 1 offset m
            ),
            null
        )
    );
END


CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
RETURN (
        # Write your MySQL query statement below.
      SELECT
            salary
      FROM
            employee
      GROUP BY
            salary
      ORDER BY
            salary DESC
      LIMIT N, 1
    );
END
