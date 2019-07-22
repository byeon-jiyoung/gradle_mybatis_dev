package kr.or.yi.gradle_mybatis_dev.dao;

import static org.junit.Assert.*;

import java.io.ObjectOutputStream.PutField;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.Course;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest {
	private static CourseMapper courseDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseDao = new CourseMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseDao = null;
	}

	@Test
	public void test01SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//조건이 하나도 만족하지 않을 경우
		List<Course> list = courseDao.selectCourseByCondition(paramMap); //아무런 조건이 들어가지 않은 상태
		
		//courseId 조건만 참인 경우
		paramMap.put("courseId", 1);
		list = courseDao.selectCourseByCondition(paramMap);
		
		//courseName 조건만 참인 경우
		paramMap.clear();
		paramMap.put("courseName", "%java%");
		list = courseDao.selectCourseByCondition(paramMap);
		
		//courseName & startDate 조건이 참인 경우
		GregorianCalendar cal = new GregorianCalendar(2013,3,1); //2013-04-01이후부터 시작되는게 출력된다.
		paramMap.put("startDate", cal.getTime());
		
		
		Assert.assertNotNull(list);
	}

	@Test
	public void test02SelectCourseByChoose() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//조건이 하나도 만족하지 않을 경우 => 오늘 날짜 이후 시작되는 과정 검색
		List<Course> list = courseDao.selectCourseByChoose(paramMap); //아무런 조건이 들어가지 않은 상태
		
		paramMap.put("searchBy", "Tutor");
		paramMap.put("tutorId", 1);
		list = courseDao.selectCourseByChoose(paramMap);
		
		paramMap.clear();
		paramMap.put("searchBy", "CourseName");
		paramMap.put("courseName", "%java%");
		list = courseDao.selectCourseByChoose(paramMap);
		
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03SelectCourseByTrim() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<Course> list = courseDao.selectCourseByTrim(paramMap);
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03aSelectCourseByTrim() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("tutorId", 1);
		List<Course> list = courseDao.selectCourseByTrim(paramMap);
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test03bSelectCourseByTrim() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tutorId", 1);
		paramMap.put("courseName", "%java%");
		List<Course> list = courseDao.selectCourseByTrim(paramMap);
		Assert.assertNotNull(list);
	}
}
