package kr.or.ddit.property.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.vo.PropertyVO;

class PropertyDAOTest extends AbstractRootContextTest{
	
	@Inject
	PropertyDAO dao;

	@Test
	void testInsertProperty() {
		PropertyVO newProp = new PropertyVO();
		newProp.setPropertyName("dummyName");
		newProp.setPropertyValue("dummyValue");
		newProp.setDescription("dummyDesc");
		
		int rowcnt = dao.insertProperty(newProp);
		assertEquals(1, rowcnt);
	}

	@Test
	void testSelectProperties() {
		List<PropertyVO> propList = dao.selectProperties();
//		assertion
		assert propList != null;
		assertNotNull(propList);
		assertNotEquals(0, propList.size());
	}

	@Test
	void testSelectProperty() {
		for(int i=1; i<=2000; i++) {
			PropertyVO vo = dao.selectProperty("GLOBAL_DB_NAME");
			assertNotNull(vo);
		}
	}

	@Test
	void testUpdateProperty() {
		PropertyVO modifyProp = new PropertyVO();
		modifyProp.setPropertyName("NLS_ISO_CURRENCY");
		modifyProp.setPropertyValue("modified value");
		int rowcnt = dao.updateProperty(modifyProp);
		assertEquals(1, rowcnt);
		
		modifyProp.setPropertyName("afsdasdf");
		modifyProp.setPropertyValue("modified value");
		rowcnt = dao.updateProperty(modifyProp);
		assertEquals(0, rowcnt);
	}

	@Test
	void testDeleteProperty() {
		int rowcnt = dao.deleteProperty("NLS_ISO_CURRENCY");
		assertEquals(1, rowcnt);
	}

}








