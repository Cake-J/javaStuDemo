package com.jkg.io;


import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void test() throws IOException {
		FileUtils.listDirectory(new File("D:\\Git"));
	}
}
