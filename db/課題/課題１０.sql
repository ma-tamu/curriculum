use sample;
CREATE VIEW V1 AS
    SELECT 
        o.dept_name, d.emp_no, p.title
    FROM
        sample.departments AS o
            LEFT OUTER JOIN
        sample.dept_emp AS d ON o.dept_no = d.dept_no
            LEFT OUTER JOIN
        sample.titles AS p ON d.emp_no = p.emp_no;

SELECT * FROM V1;