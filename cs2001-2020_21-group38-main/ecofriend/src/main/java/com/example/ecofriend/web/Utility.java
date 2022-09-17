package com.example.ecofriend.web;

import javax.servlet.http.HttpServletRequest;

//To send an email to reset password
public class Utility {
	public static String getSiteURL(HttpServletRequest httpRequest) {
		String siteURL = httpRequest.getRequestURI().toString();
		return siteURL.replace(httpRequest.getServletPath(), "");
	}

}
