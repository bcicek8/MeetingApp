## MeetingApp

#### Initial SQL Statement
```sql
create database if not exists db01;
use db01;

create table department(
    id int(5) auto_increment primary key,
    name varchar(30),
    description varchar(30)); 

create table employee(
    id int(5) auto_increment primary key,
    name varchar(30),
    department_id int(5),
    foreign key (department_id) references department(id));
```
#### Running
The command to start the server
```
$ mvn spring-boot:run
```
