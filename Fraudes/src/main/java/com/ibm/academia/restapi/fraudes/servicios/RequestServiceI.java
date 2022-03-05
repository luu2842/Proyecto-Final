package com.ibm.academia.restapi.fraudes.servicios;

import javax.servlet.http.HttpServletRequest;

public interface RequestServiceI {
	
	   String getClientIp(HttpServletRequest request);
}
