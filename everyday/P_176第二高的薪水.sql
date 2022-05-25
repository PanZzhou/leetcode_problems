select distinct Salary as SecondHighestSalary  from Employee order by Salary desc limit 1 offset 1;

select (select distinct Salary from Employee order by Salary desc limit 1 offset 1) as SecondHighestSalary;

select ifnull((select distinct Salary from Employee order by Salary desc limit 1 offset 1), null) as SecondHighestSalary;
