package com.ibm.maersk.restframework.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.ibm.maersk.restframework.domain.Property;
import com.ibm.maersk.restframework.repositories.PropertyRepository;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceImplSpyTest {
	@Spy
	private PropertyServiceImpl propertyServiceSpy;
	@Mock
	private PropertyRepository propertyRepository;
	@Mock
	private Property property;

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerException_whenGetProductByIdIsCalledWithoutContext()
			throws Exception {
		// Act
		Property retrievedProduct = propertyServiceSpy.getPropertyById(5);
		// Assert
		assertThat(retrievedProduct, is(equalTo(property)));
	}

	public void shouldThrowNullPointerException_whenSaveProductIsCalledWithoutContext()
			throws Exception {
		// Arrange
		Mockito.doReturn(property).when(propertyRepository).save(property);
		// Act
		Property savedProduct = propertyServiceSpy.saveProperty(property);
		// Assert
		assertThat(savedProduct, is(equalTo(property)));
	}

	@Test
	public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
		// Arrange
		Mockito.doReturn(property).when(propertyServiceSpy).getPropertyById(5);
		// Act
		Property retrievedProduct = propertyServiceSpy.getPropertyById(5);
		// Assert
		Mockito.verify(propertyServiceSpy).getPropertyById(5);
	}

	@Test
	public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
		// Arrange
		Mockito.doReturn(property).when(propertyServiceSpy).getPropertyById(5);
		// Act
		Property retrievedProduct = propertyServiceSpy.getPropertyById(5);
		// Assert
		Mockito.verify(propertyServiceSpy, never()).saveProperty(property);
	}
}