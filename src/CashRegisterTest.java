import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CashRegisterTest {
	
	public Account initAccount() {
		Account account = new Account("", new BigDecimal(68));
		DenominationCount denom = new DenominationCount(1,2,3,4,5);
		account.setDenomination(denom);
		return account;
	}

	@Test
	public void test_putMoney() {
		Account account = Util.putMoney(initAccount(), "put 1 1 1 1 1");
		assertTrue(account.getDenomination().getTwentysCount() == 2);
	}
	
	@Test
	public void test_takeMoney() {
		Account account = Util.takeMoney(initAccount(), "take 1 0 0 0 0");
		assertTrue(account.getDenomination().getTwentysCount() == 0);
	}
	
	@Test
	public void test_requestChange() {
		String requestedChangeDenom = Util.requestChange(initAccount(), "change 20");
		assertTrue(requestedChangeDenom.equals("1 0 0 0 0"));
	}
	
	@Test
	public void test_requestChangeError() {
		assertTrue(Util.requestChange(initAccount(), "change 100").equals("sorry"));
	}
	
}
