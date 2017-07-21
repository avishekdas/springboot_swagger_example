package com.ibm.maersk.restframework.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.maersk.restframework.domain.Property;
import com.ibm.maersk.restframework.services.PropertyService;

@RestController
@RequestMapping("/property")
@Api(value = "gemsproperties", description = "Operations pertaining to properties in GEMS Application")
public class PropertyController {

	private PropertyService propertyService;

	@Autowired
	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@ApiOperation(value = "View a list of available properties", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Iterable<Property> list(Model model) {
		Iterable<Property> propertyList = propertyService.listAllProperties();
		return propertyList;
	}

	@ApiOperation(value = "Search a property with an ID", response = Property.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Property showProperty(@PathVariable Integer id, Model model) {
		Property property = propertyService.getPropertyById(id);
		return property;
	}

	@ApiOperation(value = "Add a property")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveProperty(@RequestBody Property property) {
		propertyService.saveProperty(property);
		return new ResponseEntity("Property saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a property")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateProperty(@PathVariable Integer id,
			@RequestBody Property property) {
		Property storedProperty = propertyService.getPropertyById(id);
		storedProperty.setInsTmst(property.getInsTmst());
		storedProperty.setInUser(property.getInUser());
		storedProperty.setKeyName(property.getKeyName());
		storedProperty.setKeyValue(property.getKeyValue());
		storedProperty.setSrvcName(property.getSrvcName());
		storedProperty.setUpdTmst(property.getUpdTmst());
		storedProperty.setUpdUser(property.getUpdUser());

		propertyService.saveProperty(storedProperty);
		return new ResponseEntity("Property updated successfully",
				HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a property")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		propertyService.deleteProperty(id);
		return new ResponseEntity("Property deleted successfully",
				HttpStatus.OK);

	}

}
