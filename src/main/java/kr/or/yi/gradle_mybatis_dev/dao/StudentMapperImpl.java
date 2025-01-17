package kr.or.yi.gradle_mybatis_dev.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
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

	@Override
	public Student selectStudentByNoResultMapExtends(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectStudentByNoResultMapExtends", student);
		}
	}

	@Override
	public int insertStudentEnum(Student student) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + "insertStudentEnum", student);
			sqlSession.commit(); //이거 안하면 DB에 안들어간다
			return res;
		}
	}

	@Override
	public Student selectStudentByMap(Map<String, String> map) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectStudentByMap", map);
								//한개밖에 없다는 가정하에 selectOne. 만약에 여러개있으면 selectList로 해야함!!
		}
	}

	@Override
	public Map<Integer, String> selectStudentForMap() {
		//리스트로 온 애를 map으로 저장해서 하나씩 불러오는거
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student std = resultContext.getResultObject(); //리스트 중 한개를 먼저 가지고 와서
				map.put(std.getStudId(), std.getName()); //map에 담는다
				
			}
		};
		
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			sqlSession.selectList(namespace + "selectStudentForMap", resultHandler);
			return map;
		}
	}

}
