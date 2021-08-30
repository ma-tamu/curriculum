SELECT dep.dept_name, COUNT(em.gender)
FROM
    dept_emp AS depem
        LEFT OUTER JOIN
    departments AS dep ON depem.dept_no = dep.dept_no
        LEFT OUTER JOIN
    employees AS em ON depem.emp_no = em.emp_no
        LEFT OUTER JOIN
    salaries AS sa ON sa.emp_no = em.emp_no
where sa.salary >= (select AVG(sa.salary) 
from     
	dept_emp AS depem
        LEFT OUTER JOIN
    departments AS dep ON dep.dept_no = depem.dept_no
        LEFT OUTER JOIN
    salaries AS sa ON sa.emp_no = depem.emp_no
   )
    group by dep.dept_name, em.gender;