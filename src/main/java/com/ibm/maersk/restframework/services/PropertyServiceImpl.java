package com.ibm.maersk.restframework.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.maersk.restframework.domain.Property;
import com.ibm.maersk.restframework.repositories.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private PropertyRepository propertyRepository;

	@Autowired
	public void setPropertyRepository(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	public Iterable<Property> listAllProperties() {
		logger.debug("listAllProperties called");
		return propertyRepository.findAll();
	}

	public Property getPropertyById(Integer id) {
		logger.debug("getPropertyById called");
		return propertyRepository.findOne(id);
	}

	public Property saveProperty(Property property) {
		logger.debug("saveProperty called");
		return propertyRepository.save(property);
	}

	public void deleteProperty(Integer id) {
		logger.debug("deleteProperty called");
		propertyRepository.delete(id);
	}
}
