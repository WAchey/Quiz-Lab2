package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Die;
import pkgCore.Roll;

public class RollTest {

	@Test
	public void TestRoll() {

		for (int a = 0; a < 10000; a++) {
			Roll r = new Roll();
			if(r.getScore() < 2) fail("Roll too low");
			else if(r.getScore() > 12) fail("Roll too high");
		}

	}

}
