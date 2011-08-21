/**
 * @(#) JenkinsHashTest.java 2011-08-20
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A JenkinsHashTest
 * 
 * @version $Revision: $
 * @author $Author: vijaykandy $
 */
public class JenkinsHashTest {

	/**
	 * Test method for {@link JenkinsHash#hash64(byte[])}.
	 */
	@Test
	public void testHash64() {
		String source = "";
		JenkinsHash jh = new JenkinsHash();
		long pc = jh.hash64(source.getBytes());
		System.out.println(Long.toHexString(pc));
	}
	
	/**
	 * Test method for {@link JenkinsHash#hash32(byte[])}.
	 */
	@Test
	public void testHash32() {
		String source = "";
		JenkinsHash jh = new JenkinsHash();
		int pc = jh.hash32(source.getBytes());
		System.out.println(Integer.toHexString(pc));
	}

	/**
	 * Test method for {@link JenkinsHash#rot(long, long)}.
	 */
	@Test
	public void testRot() {
		JenkinsHash jh = new JenkinsHash();
		assertEquals(256, jh.rot(0x1, 8));
		assertEquals(65536, jh.rot(0x1, 16));
		assertEquals(16777216, jh.rot(0x1, 24));
		//assertEquals(4294967296L, jh.rot(0x1, 32));
		System.out.println(jh.rot(0x1, 32));
	}
}
