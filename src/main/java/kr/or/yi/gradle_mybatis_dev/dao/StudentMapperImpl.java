package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Student;
import kr.or.yi.gradle_mybatis_dev.jdbc.MybatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.StudentMapper.";
	
	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectStudentByNo", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectStudentByNoWithResultMap", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertStudent", student);
			sqlSession.commit(); //이거 안하면 DB에 안들어간다
			return res;
		}
	}

	@Override
	public int insertStudentAutoInc(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertStudentAutoInc", student);
			sqlSession.commit(); //이거 안하면 DB에 안들어간다
			return res;
		}
	}

	@Override
	public int updateStudent(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.update(namespace + "updateStudent", student);
			sqlSession.commit(); //이거 안하면 DB에 안들어간다
			return res;
		}
	}

	@Override
	public int deleteStudent(int id) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.delete(namespace + "deleteStudent", id);
			sqlSession.commit(); //이거 안하면 DB에 안들어간다
			return res;
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentMapByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + "selectStudentMapByAll");
		}
	}

}
