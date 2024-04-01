package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.common.exception.CustomPersistenceException;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOTest extends AbstractRootContextTest{

	@Inject
	MemberDAO dao;
	MemberVO inputData;
	
	@BeforeEach
	void setUp() {
		inputData = new MemberVO();
		inputData.setMemId("a001");
	}

	@Test
	void testSelectMemberForAuth() {
		MemberVO saved = dao.selectMemberForAuth("a001");
		assertNotNull(saved);
	}
	
	@Test
	void testSelectMember() {
		MemberVO a001 = dao.selectMember("a001");
		log.info("a001 의 구매기록 : {}", a001.getCartList());
		log.info("a001 의 탈퇴 여부 : {}", a001.isMemDelete());
		MemberVO d001 = dao.selectMember("d001");
		log.info("d001 의 탈퇴 여부 : {}", d001.isMemDelete());
	}

	@Test
	void testInsertMember() {
		MemberVO newMem = new MemberVO();
		assertThrows(CustomPersistenceException.class, ()->{
			dao.insertMember(newMem);
		});
	}
}





















