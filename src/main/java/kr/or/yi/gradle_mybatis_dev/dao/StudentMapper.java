package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

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
	
	List<Map<String, Object>> selectStudentMapByAll();
	Student selectStudentByNoResultMapExtends(Student student);
	
	int insertStudentEnum(Student student);
	Student selectStudentByMap(Map<String, String> map); //매개변수를 해쉬맵으로 전달(여러개 입력파라미터전달방법이다!!!)
	
	//ResultSet처리방식의 재정의
	Map<Integer, String> selectStudentForMap();
}
