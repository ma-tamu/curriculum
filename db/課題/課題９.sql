SELECT 
    o.dept_name,count(p.emp_no)
FROM
    sample.departments AS o
        LEFT OUTER JOIN
    sample.dept_emp AS d ON o.dept_no = d.dept_no
        LEFT OUTER JOIN
    sample.employees AS p ON d.emp_no = p.emp_no
GROUP BY o.dept_name
having count(p.emp_no) >= 30000;