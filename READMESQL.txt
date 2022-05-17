SQL FILES
      
DATABASE NAME : BANK
  IT HAS TWO FILES
FILE1 NAME: CUSTOMER
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| ACCT_NO   | int         | NO   | PRI | NULL    |       |
| C_NAME    | varchar(30) | YES  | UNI | NULL    |       |
| BAL       | int         | YES  |     | 0       |       |
| PASS_CODE | char(20)    | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+

FILE2 NAME: BANK
+---------+-------------+------+-----+---------+-------+
| Field   | Type        | Null | Key | Default | Extra |
+---------+-------------+------+-----+---------+-------+
| ACCT_NO | int         | NO   | PRI | NULL    |       |
| emp_id  | char(20)    | YES  | UNI | NULL    |       |
| C_NAME  | varchar(30) | YES  | UNI | NULL    |       |
+---------+-------------+------+-----+---------+-------+