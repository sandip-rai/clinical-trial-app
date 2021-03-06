package unitTest;

import java.util.Date;

import trial.Clinic;
import trial.Reading;

import org.junit.Test;
import org.junit.Assert;

/**
 * The Class ReadingUnitTest.
 */
public class ReadingUnitTest {
	
	/** The rid. */
	String rid;
	
	/** The t. */
	String t;
	
	/** The v. */
	String v;
	
	/** The bpv. */
	String bpv;
	
	/** The d. */
	Date d;
	
	/** The cid. */
	String cid;
	
	/** The c. */
	Clinic c;
	
	/** The r 1. */
	Reading r, r1;
	
	/**
	 * Test all.
	 */
	@Test
	public void testAll() {
		
		rid = "001";
		t = "Weight";
		v = "180.1";
		bpv = null;
		d = new Date();
		cid = "001";
		c = new Clinic("Clinic 1", cid);
		
		r = new Reading(rid, t, v, d, c);
		
		Assert.assertNull(bpv);
		Assert.assertNotNull(c);
		Assert.assertNotNull(r);
		
		Assert.assertEquals("001", r.getReadingId());
		Assert.assertEquals("Weight", r.getType());
		Assert.assertEquals("180.1", r.getValue());
		Assert.assertEquals(d, r.getDate());
		Assert.assertEquals(c, r.getClinic());
		
		
		bpv = "135/85";
		t= "Blood Pressure";
		rid="002";
		Date dd = new Date();
		cid = "002";
		c = new Clinic("Clinic 2", cid);
		
		r1 = new Reading(rid, t, bpv, dd, c);
		
		Assert.assertNotNull(c);
		Assert.assertNotNull(r1);
		
		Assert.assertEquals("002", r1.getReadingId());
		Assert.assertEquals("Blood Pressure", r1.getType());
		Assert.assertEquals("135/85", r1.getValue());
		Assert.assertEquals(dd, r1.getDate());
		Assert.assertEquals(c, r1.getClinic());
		
	}
}
