package com.sen.config;

/**
 * @author HuangJS
 * @date 2019-09-21 5:20 下午
 */
public class Globals {
	private String url;
	private int timeout;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "Globals{" +
				"url='" + url + '\'' +
				", timeout=" + timeout +
				'}';
	}
}
