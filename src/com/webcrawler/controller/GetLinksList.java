package com.webcrawler.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.webcrawler.constants.ApplicationConstants;
import com.webcrawler.utils.CrawlerUtils;


public class GetLinksList extends HttpServlet {
	
	static Logger logger = Logger.getLogger(GetLinksList.class.getName());
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			 {
	
		logger.info("processing doc");
		try {
			CrawlerUtils.processUrl(ApplicationConstants.DOMAIN_HOME_PAGE_URL);
			JSONObject test= new JSONObject(CrawlerUtils.processMap);
			logger.info("processed doc");
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().println(test);
		} catch (IOException e) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			try {
				resp.getWriter().println("{\"status\":\"failed\"}");
			} catch (IOException e1) {
				//
			}
			logger.severe("processing doc failed");
		}
		
		
	}

}
