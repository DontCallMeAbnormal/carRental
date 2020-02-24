package cn.tongRenCollege.test.util;

import org.junit.Test;

import cn.tongRenCollege.util.UUIDCreater;

public class TestUUIDutil {
	
	@Test
	public void testUUID() {
		String uuid = UUIDCreater.getUUID();
		System.out.println(uuid);
	}
	
	@Test
	public void testDateID() {
		String uuid = UUIDCreater.getDateID();
		System.out.println(uuid);
	}
}
