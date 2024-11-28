package com.udemy.primeiroprojetospringbatch.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;


public class YamlPropertySourceFactory implements PropertySourceFactory{

	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();

		if (resource != null) {
			factory.setResources(resource.getResource());
			Properties properties = factory.getObject();
			if (properties != null) {
				String filename = resource.getResource().getFilename();
				if (filename != null) {
					return new PropertiesPropertySource(filename, properties);
				}
			}
		}

		return null;
	}

}
