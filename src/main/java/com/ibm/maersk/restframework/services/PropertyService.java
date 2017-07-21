package com.ibm.maersk.restframework.services;

import com.ibm.maersk.restframework.domain.Property;

public interface PropertyService {
	Iterable<Property> listAllProperties();

	Property getPropertyById(Integer id);

	Property saveProperty(Property product);

	void deleteProperty(Integer id);
}
