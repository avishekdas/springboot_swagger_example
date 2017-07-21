package com.ibm.maersk.restframework.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ibm.maersk.restframework.repositories.PropertyRepository;

@Component
public class SpringJpaBootstrap implements
		ApplicationListener<ContextRefreshedEvent> {

	private PropertyRepository propertyRepository;

	private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

	@Autowired
	public void setProductRepository(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
	}

	private void loadProducts() {

	}

}
