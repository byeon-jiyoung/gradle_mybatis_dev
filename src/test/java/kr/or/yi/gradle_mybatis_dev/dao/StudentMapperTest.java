package kr.or.yi.gradle_mybatis_dev.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.Gender;
import kr.or.yi.gradle_mybatis_dev.dto.PhoneNumber;
import kr.or.yi.gradle_mybatis_dev.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void test01SelectStudentByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student std = new Student();
		
		std.setStudId(1);
		
		Student selectStd = stdDao.selectStudentByNo(std);
		log.debug(selectStd.toString());
		Assert.assertEquals(std.getStudId(), selectStd.getStudId());
	}
	
	@Test
	public void test03SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = stdDao.selectStudentByAll();
		log.debug(lists.toString());
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test04InsertStudent() {
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
		
		test03SelectStudentByAll();
	}
	
	@Test
	public void test05InsertStudentAutoInc() {
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
		
		test03SelectStudentByAll();
	}
	
	@Test
	public void test06UpdateStudent() {
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
	public void test07DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		int dStu = stdDao.deleteStudent(3);
		Assert.assertSame(1, dStu);
	}
	
	@Test
	public void test08SelectStudentMapByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		List<Map<String, Object>> list = stdDao.selectStudentMapByAll();
		Assert.assertNotNull(list);
		
		for(Map<String, Object> e : list) {
//			log.debug(e.toString()); 이거는 value값만 출력됨
			for(Entry<String, Object> ee:  e.entrySet()) {
				log.debug(String.format("key(%s) -> value(%s)", ee.getKey(), ee.getValue()));
			}
		}
	}
	
	@Test
	public void test09SelectStudentByNoResultMapExtends() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Student student = new Student();
		student.setStudId(1);
		
		Student searchStd = stdDao.selectStudentByNoResultMapExtends(student);
		Assert.assertNotNull(searchStd);
		
		log.debug(searchStd.toString());
	}
	
	@Test
	public void test10InsertStudentEnum() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student stu = new Student();
		stu.setStudId(3);
		stu.setName("홍길동");
		stu.setEmail("test@test.co.kr");
		stu.setPhone(new PhoneNumber("010-1234-1234"));
		stu.setDob(newDate.getTime());
		stu.setGender(Gender.FEMALE);
		
		int res = stdDao.insertStudentEnum(stu);
		Assert.assertEquals(1, res);
		
		Student selStd = stdDao.selectStudentByNo(stu);
		log.debug(selStd.toString());
		
		stu.setStudId(5);
		stu.setName("홍길순");
		stu.setGender(Gender.MALE);
		stdDao.insertStudentEnum(stu);
		
		selStd = stdDao.selectStudentByNo(stu);
		log.debug(selStd.toString());
		
		stdDao.deleteStudent(3);
		stdDao.deleteStudent(5);
	}
	
	@Test
	public void test11SelectStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Timothy");
		map.put("email", "timothy@gmail.com");
		
		Student std = stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		map.remove("email");
		std = stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		map.clear(); //clear는 다 삭제
		map.put("email", "timothy@gmail.com");
		std = stdDao.selectStudentByMap(map);
		log.debug(std.toString());
		
		Assert.assertNotNull(std);
	}
	
	@Test
	public void test12SelectStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<Integer, String> result = new HashMap<Integer, String>();
		Assert.assertNotNull(result);
		
		for(Entry<Integer, String> e : result.entrySet()) {
												//key, value값 동시에 검색 가능
			log.debug(String.format("%d -> %s", e.getKey(), e.getValue()));
		}
	}
}
