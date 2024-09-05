## Types of index in SQL
### 1. Clusterd Index
- It store recored physiclly in Acending order by Primary key.
- Your table has primary key as ID, when you insert data into table in any order it will maintain recored in acending order.
- This type of index is only one per table

### 2. Non-Clusterd Index
- In database storage this type of index is stored at one place and table is stored in another place.
- we can create multiple index per table.
- **Example :**
	- 1. textBook
	- 2. Apartment flat no list at entry gate

## Stored Procedure
- A stored procedure in MySQL is a set of SQL statements that can be stored in the database and executed as a single unit. Stored procedures can accept parameters, perform complex operations, and return results. They are useful for encapsulating repetitive or complex operations, improving performance, and ensuring code reuse.
1. Encapsulate complex logic into a single callable unit.
2. Code can be reused across multiple applications or different parts of an application.
3. Reduce network traffic by sending only the call to the procedure rather than multiple SQL statements.
4. Restrict direct access to the data by providing controlled access via stored procedures.
```sql
DELIMITER $$
CREATE PROCEDURE sp_insert_book
(
IN pBookId INT,
IN pSubjectName VARCHAR(256),
IN pBookName VARCHAR(256),
IN pAuthorName VARCHAR(256),
IN pPrice FLOAT
)
BEGIN
INSERT INTO BookTable
VALUES (pBookId, pSubjectName, pBookName, pAuthorName, pPrice);
END $$
DELIMITER ;
```
```sql
DROP PROCEDURE procedureName;
DELIMITER $$
CREATE PROCEDURE procedureName(para1 varchar(12))
BEGIN
    SELECT * FROM EMP WHERE job=para1;
END $$
DELIMITER ;
```
```sql
DELIMITER $$
CREATE PROCEDURE sp_select_book( )
BEGIN
SELECT * FROM BookTable;
END $$
DELIMITER ;
```
## Functions
In MySQL, functions are subroutines that return a single value. They can be built-in (provided by MySQL) or user-defined (created by the user). Functions are used to encapsulate repetitive logic, perform calculations, manipulate data, and return results. Functions differ from stored procedures in that they return a value and can be used in SQL expressions, whereas procedures do not return a value directly and are typically used to perform actions.
#### Types of Functions in MySQL
- **Built-in Functions** : Provided by MySQL, covering a wide range of tasks like string manipulation, mathematical calculations, date/time processing, and aggregate operations.
Examples : `CONCAT('Hello', ' ', 'World')`,`SUBSTRING('Hello World', 1, 5)`,`NOW()`,`SUM()`,`COUNT`.
- **User-defined Functions (UDFs)** : Created by users to encapsulate custom logic. These are written using SQL and can be used in SQL statements.

Examples: 
```SQL
DROP FUNCTION IF EXISTS F1;
DELIMITER $$
CREATE FUNCTION F1() RETURNS varchar(100)
BEGIN
    DECLARE x varchar(100) default 'Hello World';
    SELECT "Hello World";
     call p1(x);
     return x;
END $$
DELIMITER ;
```
```sql
DROP FUNCTION functionName;
DELIMITER $$
CREATE FUNCTION functionName() RETURNS int
BEGIN
    DECLARE x int;
    SET x = 1001;
    RETURN (x);
END $$
DELIMITER ;
```
```SQl
DROP FUNCTION IF EXISTS functionName;
DELIMITER $$
CREATE FUNCTION functionName(no int) RETURNS varchar(20)
BEGIN
   DECLARE x varchar(20);
   SELECT DISTINCT 'Number present' INTO x FROM t1 WHERE c1 = no;
  IF x IS NOT NULL THEN
	RETURN(x);
  ELSE
	RETURN (no);
  END IF;
END $$
DELIMITER ;
```
## Triggers In SQl
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREATE TRIGGER triggerName AFTER INSERT ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (new.deptno, new.dname, new.loc, new.pwd);
END $$
DELIMITER ;
```
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREATE TRIGGER triggerName AFTER UPDATE ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (old.dname, new.dname);
END $
DELIMITER ;
```
```SQl
DROP TRIGGER IF EXISTS triggerName;
DELIMITER $$
CREAsTE trigger triggerName AFTER DELETE ON dept for each ROW
BEGIN
	INSERT INTO d1 VALUES (old.deptno, old.dname, old.loc, old.pwd, NOW(), user());
END $
DELIMITER ;
```
### Transaction in SQL
- A transaction is an atomic unit of database operations against the data in one or more databases. The effects of all the SQL statements in a transaction can be either all committed to the database or all rolled back.
```sql
SET autocommit = 0 / 1;
-- or
SET autocommit = OFF / ON;

-- Example
	
-- 1. start a new transaction
START TRANSACTION;
 
-- 2. insert a new order for customer 145
INSERT INTO orders(orderNumber,orderDate, requiredDate, shippedDate, status, customerNumber)
VALUES( 1, '2005-05-31', '2005-06-10','2005-06-11','In Process', 145);
        
-- 3. Insert order line items
INSERT INTO orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber)
VALUES( 1,'S18_1749', 30, '136', 1), ( 1,'S18_2248', 50, '55.09', 2);
      
-- 4. commit / rollback changes    
COMMIT / ROLLBACK;
```
## What is mysql database engine?
- Storage engines are MySQL components that handle the SQL operations for different table types.
- InnoDB is the default and most general-purpose storage engine, and Oracle	recommends using it for tables except for specialized use cases.

## Types of joins : 
* Inner join
* Left outer join
* Right outer join
* Cross join

## MySQL Problem

To find the second highest salary from an `Employee` table, you can use the `ORDER BY` clause with `LIMIT` or `OFFSET`. Here’s a straightforward SQL query to achieve this:

### Query using `ORDER BY` and `LIMIT`:

```sql
SELECT DISTINCT salary
FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1;
```
### Explanation:

- **`SELECT DISTINCT salary`**: Selects distinct salary values from the `Employee` table to avoid duplicates.
- **`ORDER BY salary DESC`**: Sorts the salaries in descending order, so the highest salaries come first.
- **`LIMIT 1 OFFSET 1`**: Skips the first (highest) salary and selects the second row, which is the second highest salary.

### Alternative Query using Subquery:

Another approach using a subquery to achieve the same result:

```sql
SELECT MAX(salary)
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
```

### Explanation:

- The subquery `(SELECT MAX(salary) FROM Employee)` finds the highest salary.
- The main query then selects the maximum salary that is less than the highest salary, effectively giving the second highest salary.

Both queries will give you the second highest salary from the `Employee` table.

### Next problem
To return the employees who have the second highest salary, especially when multiple employees share the same second highest salary, you can use a subquery to find the second highest salary first, and then use that value to filter the employees.

Here’s the SQL query to achieve that:

```sql
SELECT *
FROM Employee
WHERE salary = (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
);
```

```sql
-- Create EMPLOYEE table
CREATE TABLE EMPLOYEE (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100)
);

-- Create ADDRESS table
CREATE TABLE ADDRESS (
    addr_id INT PRIMARY KEY,
    emp_id INT,
    city VARCHAR(100),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id)
);

-- Create SALARY table
CREATE TABLE SALARY (
    salary_id INT PRIMARY KEY,
    emp_id INT,
    amount DECIMAL(10, 2),
    FOREIGN KEY (emp_id) REFERENCES EMPLOYEE(emp_id)
);

-- Insert data into EMPLOYEE table
INSERT INTO EMPLOYEE (emp_id, name) VALUES (1, 'John Doe');
INSERT INTO EMPLOYEE (emp_id, name) VALUES (2, 'Jane Smith');
INSERT INTO EMPLOYEE (emp_id, name) VALUES (3, 'Alice Johnson');

-- Insert data into ADDRESS table
INSERT INTO ADDRESS (addr_id, emp_id, city) VALUES (1, 1, 'Pune');
INSERT INTO ADDRESS (addr_id, emp_id, city) VALUES (2, 2, 'Mumbai');
INSERT INTO ADDRESS (addr_id, emp_id, city) VALUES (3, 3, 'Pune');

-- Insert data into SALARY table
INSERT INTO SALARY (salary_id, emp_id, amount) VALUES (1, 1, 120000);
INSERT INTO SALARY (salary_id, emp_id, amount) VALUES (2, 2, 95000);
INSERT INTO SALARY (salary_id, emp_id, amount) VALUES (3, 3, 130000);

-- View contents of EMPLOYEE table
SELECT * FROM EMPLOYEE;

-- View contents of ADDRESS table
SELECT * FROM ADDRESS;

-- View contents of SALARY table
SELECT * FROM SALARY;
```

## EMPLOYEE Table
|		**emp_id**             |			**name**		               |
|------------------------------|-------------------------------------------|
| 1                            |            John Doe                       |
| 2                            |            Jane Smith                     |
| 3                            |            Alice Johnson                  |

## ADDRESS Table
|		**addr_id**    |    **emp_id**      |       **city**                |
|----------------------|--------------------|-------------------------------|
| 1                    |   1         |          Pune                 |
| 2                    |   2       |          Mumbai               |
| 3                    |   3    |           Pune                |

## SALARY Table
|		**salary_id**  |    **emp_id**      |      **amount**               |
|----------------------|--------------------|-------------------------------|
| 1                    |   1                |          120000               |
| 2                    |   2                |          95000                |
| 3                    |   3                |           130000              |


### get the employee names with a salary greater than 100,000 and who live in Pune:

```sql
-- INNER JOIN query
SELECT e.name
FROM EMPLOYEE e
JOIN ADDRESS a ON e.emp_id = a.emp_id
JOIN SALARY s ON e.emp_id = s.emp_id
WHERE s.amount > 100000
AND a.city = 'Pune';
```

### find the employee whose salary is the second highest
```sql
select * from employee where salary=(select Max(salary) from employee);

select *from employee group by salary order by  salary desc limit 1,1;
```

To show which customer has which transactions, you can use a `JOIN` operation between the `Customer` and `Transaction` tables on the `CustId` column, which is common to both tables.

Here's the SQL query to achieve this:

```sql
SELECT c.CustId, c.name AS customerName, t.txnId, t.txnDate, t.txnAmount
FROM Customer c
JOIN Transaction t ON c.CustId = t.CustId
ORDER BY c.CustId;
```

### Explanation:

- **`JOIN Transaction t ON c.CustId = t.CustId`**: Joins the `Customer` table (`c`) with the `Transaction` table (`t`) on the `CustId` field, linking each customer with their transactions.
- **`SELECT c.CustId, c.name AS customerName, t.txnId, t.txnDate, t.txnAmount`**: Selects the customer ID, customer name, transaction ID, transaction date, and transaction amount to display which transactions belong to which customers.
- **`ORDER BY c.CustId`**: Orders the results by `CustId` to group the transactions under each customer.

### Example:

Given the following sample data:

**Customer Table:**

| CustId | Name     |
|--------|----------|
| 1      | John     |
| 2      | Alice    |
| 3      | Bob      |

**Transaction Table:**

| txnId | CustId | txnDate    | txnAmount |
|-------|--------|------------|-----------|
| 101   | 1      | 2024-08-01 | 200.00    |
| 102   | 1      | 2024-08-03 | 300.00    |
| 103   | 2      | 2024-08-02 | 400.00    |
| 104   | 3      | 2024-08-04 | 150.00    |

### Output:

| CustId | customerName | txnId | txnDate    | txnAmount |
|--------|--------------|-------|------------|-----------|
| 1      | John         | 101   | 2024-08-01 | 200.00    |
| 1      | John         | 102   | 2024-08-03 | 300.00    |
| 2      | Alice        | 103   | 2024-08-02 | 400.00    |
| 3      | Bob          | 104   | 2024-08-04 | 150.00    |

This output clearly shows which transactions belong to which customers, sorted by the `CustId`.

In MySQL (and relational databases in general), **keys** are crucial components of database tables that help define relationships, enforce data integrity, and optimize data retrieval. Here are the different types of keys commonly used in MySQL database tables and their purposes:

### 1. **Primary Key**

- **Definition**: A primary key is a unique identifier for each record in a table.
- **Characteristics**:
  - Must contain unique values; no two rows can have the same primary key value.
  - Cannot contain `NULL` values.
  - There can only be one primary key per table, but it can consist of multiple columns (composite key).
- **Purpose**:
  - Ensures each record in the table is unique.
  - Provides a way to uniquely identify each record in the table.
  - Used for indexing and improving query performance.

**Example:**

```sql
CREATE TABLE Customer (
    CustId INT AUTO_INCREMENT,
    Name VARCHAR(100),
    Email VARCHAR(100),
    PRIMARY KEY (CustId)  -- CustId is the primary key
);
```

### 2. **Foreign Key**

- **Definition**: A foreign key is a column or set of columns in one table that refers to the primary key of another table.
- **Characteristics**:
  - Creates a link between two tables.
  - Ensures referential integrity: the value of a foreign key must match an existing value in the referenced table's primary key or be `NULL`.
- **Purpose**:
  - Establishes and enforces relationships between tables.
  - Prevents actions that would destroy links between tables.
  - Helps maintain data consistency.

**Example:**

```sql
CREATE TABLE Orders (
    OrderId INT AUTO_INCREMENT,
    OrderDate DATE,
    CustId INT,
    PRIMARY KEY (OrderId),
    FOREIGN KEY (CustId) REFERENCES Customer(CustId) -- CustId is a foreign key referencing the Customer table
);
```

### 3. **Unique Key**

- **Definition**: A unique key is a constraint that ensures all values in a column (or group of columns) are unique across the table.
- **Characteristics**:
  - Allows `NULL` values (but only one per column, if the column is defined as `NULLABLE`).
  - Multiple unique keys can be defined in a table.
- **Purpose**:
  - Ensures data uniqueness for a column or a combination of columns.
  - Useful for columns that need unique values but are not the primary identifier of the table.

**Example:**

```sql
CREATE TABLE Employees (
    EmpId INT AUTO_INCREMENT,
    Email VARCHAR(100),
    PRIMARY KEY (EmpId),
    UNIQUE (Email) -- Email must be unique
);
```

### 4. **Composite Key**

- **Definition**: A composite key is a key made up of two or more columns that together uniquely identify a record in a table.
- **Characteristics**:
  - Used when a single column is not sufficient to uniquely identify a record.
  - All columns in a composite key must be unique in combination but can individually contain duplicate values.
- **Purpose**:
  - Provides a way to uniquely identify a record based on a combination of multiple columns.
  - Commonly used in junction tables for many-to-many relationships.

**Example:**

```sql
CREATE TABLE Enrollments (
    StudentId INT,
    CourseId INT,
    EnrollmentDate DATE,
    PRIMARY KEY (StudentId, CourseId) -- Composite key
);
```

### 5. **Candidate Key**

- **Definition**: A candidate key is any column or combination of columns that can qualify as a unique key in a table.
- **Characteristics**:
  - A table can have multiple candidate keys, but one of them will be chosen as the primary key.
  - Candidate keys can be used to enforce uniqueness in a table.
- **Purpose**:
  - Provides a set of columns that could potentially serve as a unique identifier for the table's records.

### 6. **Alternate Key**

- **Definition**: An alternate key is any candidate key that is not chosen as the primary key.
- **Characteristics**:
  - Alternate keys are also unique and could serve as the primary key, but they are not designated as such.
- **Purpose**:
  - Enforces uniqueness of records based on columns other than the primary key.
  - Provides additional ways to uniquely identify a record if necessary.

### 7. **Super Key**

- **Definition**: A super key is a set of one or more columns that, when taken together, can uniquely identify a record in a table.
- **Characteristics**:
  - Every super key includes the primary key, but not every super key is a candidate key.
  - It may contain extra columns that do not contribute to its uniqueness.
- **Purpose**:
  - Provides a way to uniquely identify a record, although it might not be minimal like a candidate key.

### Summary of Key Uses

| Key Type        | Purpose                                                                 |
|-----------------|-------------------------------------------------------------------------|
| **Primary Key** | Uniquely identifies each record in a table.                              |
| **Foreign Key** | Establishes relationships between tables and enforces referential integrity.|
| **Unique Key**  | Ensures that all values in a column or set of columns are unique.        |
| **Composite Key** | Uniquely identifies records using a combination of columns.           |
| **Candidate Key** | Any key that can serve as a unique identifier for records.            |
| **Alternate Key** | Candidate key that is not chosen as the primary key.                  |
| **Super Key**   | A set of columns that can uniquely identify records, may contain extra columns.|

### Conclusion

Keys are essential for maintaining the integrity, consistency, and efficiency of data in relational databases like MySQL. They help enforce rules and constraints, ensure data uniqueness, establish relationships between tables, and optimize search and retrieval operations.

To find duplicate rows in a MySQL table, you can use the `GROUP BY` clause along with the `HAVING` clause. The idea is to group the rows based on the columns that you suspect may have duplicates and then filter out groups that have more than one record.

### General SQL Query to Find Duplicate Rows

Here's the general SQL syntax to find duplicate rows based on specific columns:

```sql
SELECT column1, column2, ..., COUNT(*) as count
FROM table_name
GROUP BY column1, column2, ...
HAVING count > 1;
```

- **`column1, column2, ...`**: The columns you want to check for duplicates.
- **`COUNT(*)`**: Counts the number of occurrences of each group.
- **`HAVING count > 1`**: Filters groups that have more than one occurrence, indicating duplicates.

### Example: Finding Duplicate Rows in a Table

Let's consider a table named `Employees` with the following structure:

| EmpId | Name    | Email             |
|-------|---------|-------------------|
| 1     | Alice   | alice@example.com |
| 2     | Bob     | bob@example.com   |
| 3     | Alice   | alice@example.com |
| 4     | Charlie | charlie@example.com |
| 5     | Alice   | alice@example.com |

In this example, we want to find duplicates based on the `Name` and `Email` columns.

#### SQL Query to Find Duplicates:

```sql
SELECT Name, Email, COUNT(*) as count
FROM Employees
GROUP BY Name, Email
HAVING count > 1;
```

#### Explanation:

1. **`GROUP BY Name, Email`**: Groups rows that have the same `Name` and `Email`.
2. **`COUNT(*) as count`**: Counts how many times each combination of `Name` and `Email` appears in the table.
3. **`HAVING count > 1`**: Filters out only those groups where the count is greater than 1, meaning there are duplicates.

#### Output:

| Name  | Email             | count |
|-------|-------------------|-------|
| Alice | alice@example.com | 3     |

This output shows that there are 3 records with the `Name` "Alice" and `Email` "alice@example.com", indicating these are duplicate rows.

### Example of Finding Duplicates by All Columns

If you want to find duplicates across all columns of a table (i.e., rows that are completely identical), you can modify the query to include all columns:

```sql
SELECT EmpId, Name, Email, COUNT(*) as count
FROM Employees
GROUP BY EmpId, Name, Email
HAVING count > 1;
```

Replace `EmpId, Name, Email` with all the columns of your table if you need to check for complete duplicates.

### Additional Notes:

- **Removing Duplicates**: To delete duplicate rows, you can use the `DELETE` statement with a subquery that identifies duplicates, but be careful with this operation to ensure you're not deleting unintended data.
- **Checking Specific Columns**: Often, you'll only need to check for duplicates on certain columns (like `Name` and `Email`), so choose the appropriate columns based on your specific use case.

By using this approach, you can effectively identify and handle duplicate rows in your MySQL tables.

## ACID properties 
The ACID properties of a database are a set of principles that ensure reliable processing of database **transactions**. ACID stands for **Atomicity**, **Consistency**, **Isolation**, and **Durability**. Here’s a breakdown of each property:

- Atomicity:

    - **Definition**: Ensures that a series of database operations (a transaction) are either fully completed or not executed at all.
    - **Example**: In a banking system, if a transaction involves transferring money from Account A to Account B, atomicity ensures that both the debit from Account A and the credit to Account B occur together. If any part of the transaction fails, no part of it is applied.

- **Consistency**:

    - **Definition**: Guarantees that a transaction will bring the database from one valid state to another, maintaining database invariants.
    - **Example**: Suppose a database rule requires the total amount of money in both Account A and Account B to remain constant. Consistency ensures that after a transaction, this rule is still upheld, meaning the total amount of money before and after the transaction is the same.

- **Isolation**:

    - **Definition**: Ensures that concurrent execution of transactions results in a system state that would be obtained if transactions were executed sequentially.
    - **Example**: If two transactions are being executed simultaneously, one adding money to Account A and the other transferring money from Account A to Account B, isolation ensures that each transaction does not interfere with the other, and the final result is as if they were executed one after the other.

- **Durability**:

    - **Definition**: Ensures that once a transaction has been committed, it will remain so, even in the event of a system failure.
    - **Example**: After a transaction has been successfully executed and the changes committed, these changes are permanently recorded in the database. If the system crashes immediately afterward, the committed changes will still be present when the system is back online.

Together, these properties ensure that database transactions are processed reliably and predictably, which is crucial for the integrity and consistency of data in any system.