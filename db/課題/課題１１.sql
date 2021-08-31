SELECT 
    dep.dept_name, em.gender, COUNT(gender) as gender_count
FROM
    dept_emp AS depem
        LEFT OUTER JOIN
    departments AS dep ON depem.dept_no = dep.dept_no
        LEFT OUTER JOIN
    employees AS em ON depem.emp_no = em.emp_no
        LEFT OUTER JOIN
    salaries AS sa ON sa.emp_no = em.emp_no
WHERE
    EXISTS( SELECT 
            dep_avg.dept_name, AVG(sa_avg.salary) as avg_salary
        FROM
            dept_emp AS depem_avg
                LEFT OUTER JOIN
            departments AS dep_avg ON depem_avg.dept_no = dep_avg.dept_no
                LEFT OUTER JOIN
            employees AS em_avg ON depem_avg.emp_no = em_avg.emp_no
                LEFT OUTER JOIN
            salaries AS sa_avg ON em_avg.emp_no = sa_avg.emp_no
        GROUP BY dep_avg.dept_name
        HAVING dep_avg.dept_name = dep.dept_name
            AND avg_salary <= sa.salary)
GROUP BY dep.dept_name , em.gender;