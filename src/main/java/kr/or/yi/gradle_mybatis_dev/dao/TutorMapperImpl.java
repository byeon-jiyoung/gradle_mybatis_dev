package kr.or.yi.gradle_mybatis_dev.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Tutor;
import kr.or.yi.gradle_mybatis_dev.jdbc.MybatisSqlSessionFactory;

public class TutorMapperImpl implements TutorMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.TutorMapper.";
	
	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + "selectTutorByTutorId", tutor);
		}
	}

}
