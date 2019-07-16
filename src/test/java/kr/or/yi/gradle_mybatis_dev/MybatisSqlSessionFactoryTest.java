package kr.or.yi.gradle_mybatis_dev;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_dev.jdbc.MybatisSqlSessionFactory;

public class MybatisSqlSessionFactoryTest extends AbstractTest {
	
	@Test
	public void testOpenSession() {
		log.debug("testOpenSession");
		SqlSession session = MybatisSqlSessionFactory.openSession();
		log.debug("session " + session);
		Assert.assertNotNull(session);
	}

}
