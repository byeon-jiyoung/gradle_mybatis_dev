package kr.or.yi.gradle_mybatis_dev.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

public class StudentMapperTest extends AbstractTest {
	private static StudentMapper stdDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stdDao = new StudentMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		stdDao = null;
	}

	@Test
	public void testSelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void testSelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = stdDao.selectStudentByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void testInsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student stu = new Student();
		stu.setStudId(3);
		stu.setName("홍길동");
		stu.setEmail("test@test.co.kr");
		stu.setPhone(new PhoneNumber("010-1234-1234"));
		stu.setDob(newDate.getTime());
		
		int res = stdDao.insertStudent(stu);
		Assert.assertEquals(1, res);
		
		testSelectStudentByAll();
	}
	
	@Test
	public void testInsertStudentAutoInc() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student stu = new Student();
		stu.setName("홍길동2");
		stu.setEmail("test2@test.co.kr");
		stu.setPhone(new PhoneNumber("010-1234-1234"));
		stu.setDob(newDate.getTime());
		
		int res = stdDao.insertStudent(stu);
		Assert.assertEquals(1, res);
		
		testSelectStudentByAll();
	}
	
	@Test
	public void testUpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");

		Student stu = new Student();
		stu.setStudId(1);
		stu.setName("Timothy");
		stu.setEmail("testtest@test.co.kr");
		stu.setPhone(new PhoneNumber("987-654-3211"));
		stu.setDob(new Date());
		
		int result = stdDao.updateStudent(stu);
		Assert.assertSame(1, result);
		
		stu.setEmail("timothy@gmail.com");
		stu.setPhone(new PhoneNumber("123-123-1234"));
		stu.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		result = stdDao.updateStudent(stu);
		Assert.assertSame(1, result);
	}
	
	@Test
	public void testDeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		int dStu = stdDao.deleteStudent(3);
		Assert.assertSame(1, dStu);
	}
}
