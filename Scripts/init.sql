DROP DATABASE IF EXISTS MYBATIS_DEV;

CREATE DATABASE MYBATIS_DEV;

CREATE TABLE MYBATIS_DEV.ADDRESSES ( -- MYBATIS_DEV. �̰� �Ⱥ��̸� mysql�� ���̺��� ����. �׷��� �����ͺ��̽����� �տ� �ٿ����.
  ADDR_ID INT(11) NOT NULL AUTO_INCREMENT,
  STREET VARCHAR(50) NOT NULL,
  CITY VARCHAR(50) NOT NULL,
  STATE VARCHAR(50) NOT NULL,
  ZIP VARCHAR(10) DEFAULT NULL,
  COUNTRY VARCHAR(50) NOT NULL,
  PRIMARY KEY (ADDR_ID)
);

CREATE TABLE MYBATIS_DEV.STUDENTS (
  STUD_ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  PHONE VARCHAR(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  BIO LONGTEXT DEFAULT NULL,
  PIC BLOB DEFAULT NULL,
  ADDR_ID INT(11) DEFAULT NULL,  
  PRIMARY KEY (STUD_ID),
  CONSTRAINT FK_STUDENTS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES MYBATIS_DEV.ADDRESSES (ADDR_ID)
);

CREATE TABLE MYBATIS_DEV.TUTORS (
  TUTOR_ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(50) NOT NULL,
  PHONE VARCHAR(15) DEFAULT NULL,  
  DOB DATE DEFAULT NULL,
  BIO LONGTEXT DEFAULT NULL,
  PIC BLOB DEFAULT NULL,
  ADDR_ID INT(11) DEFAULT NULL,
  PRIMARY KEY (TUTOR_ID),
  CONSTRAINT FK_TUTORS_ADDR FOREIGN KEY (ADDR_ID) REFERENCES MYBATIS_DEV.ADDRESSES (ADDR_ID)  
);

CREATE TABLE MYBATIS_DEV.COURSES (
  COURSE_ID INT(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(100) NOT NULL,
  DESCRIPTION VARCHAR(512) DEFAULT NULL,
  START_DATE DATE DEFAULT NULL,
  END_DATE DATE DEFAULT NULL,
  TUTOR_ID INT(11) NOT NULL,
  PRIMARY KEY (COURSE_ID),
  CONSTRAINT FK_COURSE_TUTOR FOREIGN KEY (TUTOR_ID)  REFERENCES MYBATIS_DEV.TUTORS (TUTOR_ID)
);

CREATE TABLE MYBATIS_DEV.COURSE_ENROLLMENT(
  COURSE_ID INT(11) NOT NULL,
  STUD_ID INT(11) NOT NULL,
  PRIMARY KEY (COURSE_ID,STUD_ID),
  CONSTRAINT FK_ENROLLMENT_STUD FOREIGN KEY (STUD_ID) REFERENCES MYBATIS_DEV.STUDENTS (STUD_ID),
  CONSTRAINT FK_ENROLLMENT_COURSE FOREIGN KEY (COURSE_ID) REFERENCES MYBATIS_DEV.COURSES (COURSE_ID)
);


-- 계정과 권한부여
grant all privileges 
on mybatis_dev.* 
to 'user_mybatis_dev'@'localhost' 
identified by 'rootroot';


alter table students add gender tinyint unsigned;