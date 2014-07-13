/**
 * 
 */
package com.home.pms.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

/**
 * @author Rohit Khurana
 *
 */
public class PropertiesFactoryBean extends org.springframework.beans.factory.config.PropertiesFactoryBean {

	/** The locations. */
	private Resource[]			locations;

	/** The use custom. */
	private boolean				useCustom			= true;

	/** The properties persister. */
	private PropertiesPersister	propertiesPersister	= new DefaultPropertiesPersister();
	
	/**
	 * Custom load properties.
	 * 
	 * @param props
	 *            the props
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void customLoadProperties(final Properties props) throws IOException {
		if (this.locations != null) {
			this.setPropertiesPersister(this.propertiesPersister);
			InputStream isRef = null;
			try {
				for (Resource location : this.locations) {
					try {
						isRef = location.getInputStream();
					} catch (Exception e) {
						String path = null;
						if (location instanceof ClassPathResource) {
							path = ((ClassPathResource) location).getPath();
						} else if (location instanceof UrlResource) {
							path = ((UrlResource) location).getURL().getPath();
						} else {
							path = location.getFilename();
						}
						this.propertiesPersister.load(props,
								(isRef = new FileInputStream(ResourceLoaderUtility.searchAndLoadResource(path))));
					}
				}
			} catch (Exception e) {
				throw new IOException(e.getMessage(), e);
			} finally {
				if (isRef != null) {
					isRef.close();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.io.support.PropertiesLoaderSupport#loadProperties(java.util.Properties)
	 */
	@Override
	protected void loadProperties(final Properties props) throws IOException {
		try {
			super.setLocations(this.locations);
			super.loadProperties(props);
		} catch (IOException e) {
			if (this.useCustom) {
				this.customLoadProperties(props);
			} else {
				throw e;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.io.support.PropertiesLoaderSupport#setLocation(org.springframework.core.io.Resource)
	 */
	@Override
	public void setLocation(final Resource location) {
		this.locations = new Resource[] { location };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.io.support.PropertiesLoaderSupport#setLocations(org.springframework.core.io.Resource[])
	 */
	@Override
	public void setLocations(final Resource[] locations) {
		this.locations = locations;
	}

	/**
	 * Sets the use custom.
	 * 
	 * @param useCustom
	 *            the useCustom to set
	 */
	public void setUseCustom(final boolean useCustom) {
		this.useCustom = useCustom;
	}
}
