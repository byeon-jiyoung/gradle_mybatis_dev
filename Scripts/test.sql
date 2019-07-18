select user(), database();

select * from addresses;
select * from course_enrollment;
select * from courses;
select * from students;
select * from tutors;

select stud_id, name, email, dob, phone from students where stud_id = 1;
-- mybatis-config.xml에서 카멜 지정안해주면 stud_id as studId로 여기서 바꿔줘야 된다.

select stud_id, name, email, dob, substring(phone,1,3) as f, substring(phone,5,3) as m, substring(phone,9,4) as l from students where stud_id = 1;

select stud_id, name, email, phone, dob from students;

delete from students where `STUD_ID` = 7;

desc students;

set foreign_key_checks = 0;
truncate table students;

set foreign_key_checks = 1;

delete from students where `STUD_ID`=5;

INSERT INTO STUDENTS (NAME,EMAIL,PHONE,DOB,BIO,PIC,ADDR_ID) VALUES 
 ('김우빈','kim@gmail.com','123-123-1234','1988-04-25',NULL,NULL,3),
 ('김재욱','kim2@gmail.com','789-456-1234','1990-08-15',NULL,NULL,4);

alter table students auto_increment=100;

set @cnt = 0;
update students set students.stud_id = @cnt:=@cnt+1;

