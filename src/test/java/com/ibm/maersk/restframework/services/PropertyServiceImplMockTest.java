package com.ibm.maersk.restframework.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ibm.maersk.restframework.domain.Property;
import com.ibm.maersk.restframework.repositories.PropertyRepository;

public class PropertyServiceImplMockTest {

	private PropertyServiceImpl propertyServiceImpl;
	@Mock
	private PropertyRepository propertyRepository;
	@Mock
	private Property property;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		propertyServiceImpl = new PropertyServiceImpl();
		propertyServiceImpl.setPropertyRepository(propertyRepository);
	}

	@Test
	public void shouldReturnProperty_whenGetPropertyByIdIsCalled()
			throws Exception {
		// Arrange
		when(propertyRepository.findOne(5)).thenReturn(property);
		// Act
		Property retrievedProperty = propertyServiceImpl.getPropertyById(5);
		// Assert
		assertThat(retrievedProperty, is(equalTo(property)));

	}

	@Test
	public void shouldReturnProperty_whenSavePropertyIsCalled()
			throws Exception {
		// Arrange
		when(propertyRepository.save(property)).thenReturn(property);
		// Act
		Property savedProperty = propertyServiceImpl.saveProperty(property);
		// Assert
		assertThat(savedProperty, is(equalTo(property)));
	}

//	@Test
	public void shouldCallDeleteMethodOfPropertyRepository_whenDeletePropertyIsCalled()
			throws Exception {
		// Arrange
		doNothing().when(propertyRepository).delete(5);
		PropertyRepository my = Mockito.mock(PropertyRepository.class);
		// Act
		propertyServiceImpl.deleteProperty(5);
		// Assert
		verify(propertyServiceImpl, times(1)).deleteProperty(5);
	}
}