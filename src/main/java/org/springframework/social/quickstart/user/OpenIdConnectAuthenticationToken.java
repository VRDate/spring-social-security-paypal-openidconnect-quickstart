/*******************************************************************************
 * Copyright 2012 The MITRE Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.springframework.social.quickstart.user;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

/**
 * Custom authentication token written for spring security context. For now using family name as
 * userid.
 * 
 * TODO: Has to figure out how to access paypal userid.
 * 
 * @author abprabhakar
 * 
 */
public class OpenIdConnectAuthenticationToken extends AbstractAuthenticationToken {

	private final Object principle;
	private final String userId;

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	/**
	 * Constructs OpenIdConnectAuthenticationToken provided
	 * 
	 * @param principle
	 * @param authorities
	 * @param userId
	 * @param idToken
	 */
	public OpenIdConnectAuthenticationToken(Object principle, Collection<? extends GrantedAuthority> authorities, String userId) {

		super(authorities);
		this.principle = principle;
		this.userId = userId;

		setAuthenticated(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.Authentication#getCredentials()
	 */
	@Override
	public Object getCredentials() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.Authentication#getPrincipal()
	 */
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return principle;
	}

	public String getUserId() {
		return userId;
	}
}