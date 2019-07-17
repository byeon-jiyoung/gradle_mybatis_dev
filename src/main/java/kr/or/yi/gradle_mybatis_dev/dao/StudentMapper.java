package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student); //typehanler이용
	Student selectStudentByNoWithResultMap(Student student); //resultmap이용
	
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
					//원래는 Student객체를 넣는게 맞지만, 이런 방법도 있다는걸 알려주려고 교재따라 한번 해봤음(235p)
}
