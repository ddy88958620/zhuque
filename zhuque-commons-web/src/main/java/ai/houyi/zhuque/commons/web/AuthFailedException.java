/*
 * Copyright 2017-2019 The OpenAds Project
 *
 * The OpenAds Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package ai.houyi.zhuque.commons.web;

/**
 *
 * @author weiping wang
 */
@SuppressWarnings("serial")
public class AuthFailedException extends RuntimeException {

	public AuthFailedException() {
		super();
	}
	
	public AuthFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	public AuthFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	
	public AuthFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	public AuthFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
