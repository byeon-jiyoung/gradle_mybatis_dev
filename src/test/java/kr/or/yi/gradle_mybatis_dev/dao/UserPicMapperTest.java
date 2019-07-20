package kr.or.yi.gradle_mybatis_dev.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPIcMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@Test
	public void test01InsertUserPic() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("김우빈");
		String bio = "현재 싸이더스 HQ에 소속된 배우이며, 2008년 김서룡옴므쇼에서 모델로 데뷔하였다. \r\n" + 
				"\r\n" + 
				"그 이후 부산 프레타포르테 09 S/S 서은길, 서울패션위크 09 F/W 강동준, 김서룡, 이주영, 이영준, 박성철 등 잡지 맥심, W, 보그걸, 엘르걸, 맵스의 모델로 활약하면서 입지를 다져갔다. \r\n" + 
				"\r\n" + 
				"김우빈의 모델에 대한 열정은 고교생 때 어떤 대학교 게시판에 교수님께 쓴 글들이 이슈되면서 알려졌고 지금까지도 계속 회자되고 있다. \r\n" + 
				"\r\n" + 
				"연기자로써의 데뷔는 2011년 KBS 드라마 스페셜로 방영된 《화이트 크리스마스》에서 강미르 역을 맡으면서 브라운관에 얼굴을 처음으로 알렸는데 이때 새빨간 머리와 강한 캐릭터로 시청자들에게 눈도장을 찍었다. \r\n" + 
				"\r\n" + 
				"그 후 또 다른 KBS 드라마 스페셜 《큐피드 팩토리》에서는 이희준, 박수진과 MBN 시트콤 《뱀파이어 아이돌》에서 절친으로 알려진 이수혁, 홍종현 등과 함께 호흡을 맞추면서 비교적 많은 시청률을 이끌어내지는 못했지만 연기자로써의 입지를 다져간다. \r\n" + 
				"\r\n" + 
				"2012년 SBS 드라마 《신사의 품격》에서 주인공 서이수(배우 김하늘)를 짝사랑하는 제자 김동협 역을 맡으면서 이름을 알리기 시작했다. \r\n" + 
				"\r\n" + 
				"또 다른 SBS 드라마 《아름다운 그대에게》를 거쳐 같은 해인 2012년 KBS 드라마 《학교 2013》에서 박흥수 역할을 맡아 이종석과 브로맨스 호흡을 맞추면서 두터운 팬덤을 확보하기 시작한다. 이때부터 김우빈이 교복을 입으면 성공한다는 기분좋은 말도 생겨났다. \r\n" + 
				"\r\n" + 
				"《학교 2013》에서의 성공 이후 곽경택 감독의 《친구2》를 차기작으로 선택하며 스크린 데뷔한다. 전작 친구에서 주연이었던 니가 가라 하와이동수(배우 장동건)의 아들인 성훈 역할을 맡으면서 대선배인 배우 유오성, 주진모와 견주어도 뒤떨어지지 않는 연기력을 선보였다. \r\n" + 
				"\r\n" + 
				"2013년 SBS 드라마 《왕관을 쓰려는 자, 그 무게를 견뎌라 - 상속자들》에서 호텔 상속자이자 여주인공 차은상(배우 박신혜)을 짝사랑하는 최영도 역을 맡아 많은 여성의 팬심을 얻었다. 이 드라마에서 보여준 연기력을 통해 최고의 기대주로 인정받게 되는 계기가 되었다. \r\n" + 
				"\r\n" + 
				"이 인기를 이어 2013년 8월 15일부터 2014년 2월 13일까지 많은 신인배우들이 거쳐가는 MTV 《엠카운트다운》의 MC를 맡았다. 이때 남다른 어깨넓이와 188cm나 되는 키로 이슈화되었다. \r\n" + 
				"\r\n" + 
				"이 후 2014년 영화 《기술자들》에서 모든 방면에서 다재다능한 금고털이범 지혁 역을 맡으면서 또 다른 매력을 선보인다. 같은 해 또래 배우 강하늘과 2PM 멤버 준호와 영화 《스물》에서는 인기만 많은 치호 역을 맡으면서 스무살 청춘들의 동감을 얻으며 차차 배우로서의 연기 스펙트럼을 넓혀간다. \r\n" + 
				"\r\n" + 
				"2016년 KBS 드라마 《함부로 애틋하게》에서 주연 신준영 역할을 맡으면서 시한부 인생을 살게 된 톱스타의 감정선과 수지와의 로맨틱한 호흡으로 남자다운 매력을 보여준다. \r\n" + 
				"\r\n" + 
				"2016년 영화 《마스터》에서 박장군 역을 맡으면서 대선배인 이병헌과 강동원과의 호흡으로 사람들의 관심을 이끌어 낸다. \r\n" + 
				"\r\n" + 
				"이후 차기작 검토 중 2017년 5월 24일 비인두암 진단을 받고 투병 중이라고 보도되었다. 또한 2017년 말 혹은 다음해 초에 입대하려는 것도 항암치료로 인해 완전히 면제[4]되었다고.";
		userPic.setBio(bio);
		userPic.setPic(getPicFile());
		
		int result = picDao.insertUserPic(userPic);
		Assert.assertEquals(1, result);
	}

	private byte[] getPicFile() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\김우빈.jpg");
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			pic = new byte[bis.available()]; //공간을 한번에 만들었다
			bis.read(pic);
			return pic;
		}
	}

	@Test
	public void test02SelectUserPic() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic searchPic = picDao.selectUserPic(userPic);
		Assert.assertNotNull(searchPic);
		
		if(searchPic.getPic() != null) { //null이 아닐경우에만 이미지를 가져오면 되니까
			File file = getPicFile(searchPic);
			log.debug("file path = " + file.getAbsolutePath());
		}
	}

	private File getPicFile(UserPic userPic) throws FileNotFoundException, IOException {
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if(!pics.exists()) {
			pics.mkdir(); //폴더가 없으면 폴더를 만들어라
		}
		
		File pic = new File(pics, userPic.getName()+".jpg");
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pic))) {
			bos.write(userPic.getPic()); // try resoursce문으로 지정한 이 파일경로를 통해서 파일이 만들어 질거다
		}
		return pic;
		
	}
	
	@Test
	public void test03DeleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		int res = picDao.deleteUserPic(userPic);
		Assert.assertEquals(1, res);
		
		File pics = new File(System.getProperty("user.dir") + "\\pics");
		if(pics.exists()) {
			for(File file : pics.listFiles()) {
				file.delete();
			}
			
			//String[] list() : 디렉토리의 파일목록(디렉토리 포함)을 String배열로 반환한다.
			//String[] list(FilenameFilter filter) :  FilenameFilter인스턴스에 구현된 조건에 맞는 파일을 String배열로 반환한다.
			//File[] listFiles() :  디렉토리의 파일목록(디렉토리 포함)을 File배열로 반환한다.
		}
		pics.delete();
	}
}
