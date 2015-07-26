/**
 * @(#) JenkinsHashTest.java 2011-08-20
 */

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * A JenkinsHashTest
 * 
 * @version $Revision: $
 * @author $Author: vijaykandy $
 */
public class JenkinsHashTest {
    private static final String TEST_VALUE_TEXT = "Four score and seven years ago";
    private static final String TEST_VALUE_EMPTY = "";

    /**
     * Test the hashLittle2 hash of an empty value with no offsets.
     */
    @Test
    public void testJenkinsHashLittle2WithEmptyValue() {
        byte[] data = TEST_VALUE_EMPTY.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0xdeadbeefdeadbeefL, jenkinsHash.hashLittle2(data, data.length, 0, 0));
    }

    /**
     * Test the hashLittle2 hash of an empty value with a B offset.
     */
    @Test
    public void testJenkinsHashLittle2WithEmptyValueAndOffsetB() {
        byte[] data = TEST_VALUE_EMPTY.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0xbd5b7ddedeadbeefL, jenkinsHash.hashLittle2(data, data.length, 0, 0xdeadbeef));
    }

    /**
     * Test the hashLittle2 hash of an empty value with both a C and B offset.
     */
    @Test
    public void testJenkinsHashLittle2WithEmptyValueAndBothOffsets() {
        byte[] data = TEST_VALUE_EMPTY.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0x9c093ccdbd5b7ddeL, jenkinsHash.hashLittle2(data, data.length, 0xdeadbeef, 0xdeadbeef));
    }

    /**
     * Test the hashLittle2 hash of a String value with no offsets.
     */
    @Test
    public void testJenkinsHashLittle2WithValue() {
        byte[] data = TEST_VALUE_TEXT.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0x17770551ce7226e6L, jenkinsHash.hashLittle2(data, data.length, 0, 0));
    }

    /**
     * Test the hashLittle2 hash of a String value with a B offset.
     */
    @Test
    public void testJenkinsHashLittle2WithValueAndOffsetB() {
        byte[] data = TEST_VALUE_TEXT.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0xe3607caebd371de4L, jenkinsHash.hashLittle2(data, data.length, 0, 1));
    }

    /**
     * Test the hashLittle2 hash of a String value with a C offset.
     */
    @Test
    public void testJenkinsHashLittle2WithValueAndOffsetC() {
        byte[] data = TEST_VALUE_TEXT.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0xcd6281616cbea4b3L, jenkinsHash.hashLittle2(data, data.length, 1, 0));
    }

    /**
     * Test the hashLittle hash of a String value with no offset.
     */
    @Test
    public void testJenkinsHashLittleValue() {
        byte[] data = TEST_VALUE_TEXT.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0x17770551, jenkinsHash.hashLittle(data, data.length, 0));
    }

    /**
     * Test the hashLittle hash of a String value with a offset.
     */
    @Test
    public void testJenkinsHashHashLittleValueWithOffset() {
        byte[] data = TEST_VALUE_TEXT.getBytes(StandardCharsets.US_ASCII);
        JenkinsHash jenkinsHash = new JenkinsHash();
        assertEquals(0xcd628161, jenkinsHash.hashLittle(data, data.length, 1));
    }

    /**
     * Test method for {@link JenkinsHash#hash64(byte[])}.
     */
    @Test
    @Ignore
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
    @Ignore
    public void testHash32() {
        String source = "";
        JenkinsHash jh = new JenkinsHash();
        int pc = jh.hash32(source.getBytes());
        System.out.println(Integer.toHexString(pc));
    }

    /**
     * Test method for {@link JenkinsHash#rot(int, int)}.
     */
    @Test
    public void testRot() {
        JenkinsHash jh = new JenkinsHash();
        assertEquals(256, jh.rot(0x1, 8));
        assertEquals(65536, jh.rot(0x1, 16));
        assertEquals(16777216, jh.rot(0x1, 24));
        // assertEquals(4294967296L, jh.rot(0x1, 32));
        // System.out.println(jh.rot(0x1, 32));
    }
}
