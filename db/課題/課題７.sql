SELECT 
    d.dept_name, AVG(salary)
FROM
    sample.dept_emp AS o
        LEFT OUTER JOIN
    sample.departments AS d ON o.dept_no = d.dept_no
        LEFT OUTER JOIN
    sample.salaries AS p ON o.emp_no = p.emp_no
GROUP BY d.dept_name;