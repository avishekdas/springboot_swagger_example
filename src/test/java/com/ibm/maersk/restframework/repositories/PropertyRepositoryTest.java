package com.ibm.maersk.restframework.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ibm.maersk.restframework.configuration.RepositoryConfiguration;
import com.ibm.maersk.restframework.domain.Property;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class })
public class PropertyRepositoryTest {
	private PropertyRepository propertyRepository;

	@Autowired
	public void setPropertyRepository(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Test
	public void testSaveProperty() {
		// setup property
		Property property = new Property();
		property.setSrvcName("testPropSrvc");
		property.setKeyName("testPropKey");
		property.setKeyValue("testPropValue");
		property.setInUser("test");
		// save property, verify has ID value after save
		assertNull(property.getPropId()); // null before save
		propertyRepository.save(property);
		assertNotNull(property.getPropId()); // not null after save
		// fetch from DB
		Property fetchedProperty = propertyRepository.findOne(property
				.getPropId());
		// should not be null
		assertNotNull(fetchedProperty);
		// should equal
		assertEquals(property.getPropId(), fetchedProperty.getPropId());
		assertEquals(property.getKeyName(), fetchedProperty.getKeyName());
		// update description and save
		fetchedProperty.setKeyValue("New Value");
		propertyRepository.save(fetchedProperty);
		// get from DB, should be updated
		Property fetchedUpdatedProperty = propertyRepository
				.findOne(fetchedProperty.getPropId());
		assertEquals(fetchedProperty.getKeyValue(),
				fetchedUpdatedProperty.getKeyValue());
		// verify count of properties in DB
		long propertyCount = propertyRepository.count();
		assertEquals(propertyCount, 1);
		// get all properties, list should only have one
		Iterable<Property> properties = propertyRepository.findAll();
		int count = 0;
		for (Property p : properties) {
			count++;
		}
		assertEquals(count, 1);
	}
}
