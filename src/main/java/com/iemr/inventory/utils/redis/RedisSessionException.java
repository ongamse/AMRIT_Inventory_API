package com.iemr.inventory.utils.redis;

import com.iemr.inventory.utils.exception.IEMRException;

public class RedisSessionException extends IEMRException {
	public RedisSessionException(String message, Throwable cause) {
		super(message, cause);
	}

	public RedisSessionException(String message) {
		super(message);
	}
}
