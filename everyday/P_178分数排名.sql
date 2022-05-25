select
    e1.score, count(distinct e2.score) as 'rank'
from
    scores e1 join scores e2 on e1.score <= e2.score
group by
    e1.score
