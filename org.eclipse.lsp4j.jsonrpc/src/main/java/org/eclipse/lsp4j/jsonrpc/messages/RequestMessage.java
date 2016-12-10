/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.lsp4j.jsonrpc.messages;

import org.eclipse.lsp4j.jsonrpc.json.WrappedJsonConverter;
import org.eclipse.lsp4j.jsonrpc.json.WrappedJsonProperty;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

import com.google.gson.JsonObject;

public class RequestMessage extends Message {
	
	public RequestMessage() {
		super();
	}

	public RequestMessage(JsonObject jsonObject) {
		super(jsonObject);
	}

	private static WrappedJsonProperty<String> idProperty = new WrappedJsonProperty<>("id",WrappedJsonConverter.stringConverter);
	private static WrappedJsonProperty<String> methodProperty = new WrappedJsonProperty<>("method",WrappedJsonConverter.stringConverter);
	private static WrappedJsonProperty<Object> paramsProperty = new WrappedJsonProperty<>("params",WrappedJsonConverter.noConverter);

	/**
	 * The request id.
	 */
	@NonNull
	public String getId() {
		return idProperty.get(jsonObject);
	}

	public void setId(@NonNull String id) {
		idProperty.set(jsonObject, id);
	}
	
	/**
	 * The method to be invoked.
	 */
	@NonNull public String getMethod() {
		return methodProperty.get(jsonObject);
	}

	/**
	 * The method to be invoked.
	 */
	public void setMethod(@NonNull String jsonrpc) {
		methodProperty.set(jsonObject, jsonrpc);
	}

	
	/**
	 * The method's params.
	 */
	public Object getParams() {
		return paramsProperty.get(jsonObject);
	}

	public void setParams(Object params) {
		paramsProperty.set(jsonObject, params);
	}
	
}
