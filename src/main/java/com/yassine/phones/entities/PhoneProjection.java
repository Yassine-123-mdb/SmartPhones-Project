package com.yassine.phones.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "marque", types = { SmartPhone.class })
public interface PhoneProjection {
	public String getMarque();
}
