package com.webcrawler.test;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.webcrawler.constants.ApplicationConstants;
import com.webcrawler.utils.CrawlerUtils;

public class CrawlerUtilTests {

	//to test null pointer
	@Test(expected=IllegalArgumentException.class)
	public void testProcessUrlWithNull() throws IOException {
		CrawlerUtils.processUrl(null);
		Assert.assertEquals(false, false);
		
	}
	@Test
	public void testProcessUrl() throws IOException {
		CrawlerUtils.processUrl(ApplicationConstants.DOMAIN_HOME_PAGE_URL);
		Assert.assertEquals(true, true);
	}
}
