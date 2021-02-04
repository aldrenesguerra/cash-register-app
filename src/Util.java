import java.math.BigDecimal;
import java.util.Arrays;

public class Util {
	
	public static String getAction(String command) {
		return command.replaceAll("[\\d.]", "").replace(" ", "");
	}
	
	public static void printAccount(Account account) {
		DenominationCount denom = account.getDenomination();
		System.out.println("$"+account.getTotal() + " " +
				denom.getTwentysCount() + " " +
				denom.getTensCount() + " " +
				denom.getFivesCount() + " " +
				denom.getTwosCount() + " " +
				denom.getOnesCount());
	}

	public static void putMoney(Account account, String command) {
		Integer[] denomCount = denomCountCommandToArray(command);
		
		DenominationCount denom = account.getDenomination();
		denom.setTwentysCount(denom.getTwentysCount() + denomCount[0]);
		denom.setTensCount(denom.getTensCount() + denomCount[1]);
		denom.setFivesCount(denom.getFivesCount() + denomCount[2]);
		denom.setTwosCount(denom.getTwosCount() + denomCount[3]);
		denom.setOnesCount(denom.getOnesCount() + denomCount[4]);
		
		account.setTotal(getTotal(denom));
		printAccount(account);
	}

	public static void takeMoney(Account account, String command) {
		Integer[] denomCount = denomCountCommandToArray(command);
		
		DenominationCount denom = account.getDenomination();
		denom.setTwentysCount(denom.getTwentysCount() - denomCount[0]);
		denom.setTensCount(denom.getTensCount() - denomCount[1]);
		denom.setFivesCount(denom.getFivesCount() - denomCount[2]);
		denom.setTwosCount(denom.getTwosCount() - denomCount[3]);
		denom.setOnesCount(denom.getOnesCount() - denomCount[4]);
		
		account.setTotal(getTotal(denom));
		printAccount(account);
	}
	
	private static Integer[] denomCountCommandToArray(String command) {
		command = command.replaceAll("[^0-9]", " ").trim();
		return Arrays.stream(command.split(" "))
				.map(Integer::parseInt)
		        .toArray(Integer[]::new);
	}
	
	public static void requestChange(Account account, String command) {
		Integer change = Integer.parseInt(command.replaceAll("[^0-9]", " ").trim());
		try {
			int denomCountArrRemove[] = new int[5];
			computeChange(change, account, denomCountArrRemove);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void computeChange(Integer change, Account account, int[] denomCountArrRemove) throws Exception {
		try {
			DenominationCount denom = account.getDenomination();
			for(Denomination d : Denomination.values()) {
				while(change >= d.getValue()) {
					
					boolean hasAvailableDenom = false;
					
					if(d.getValue() == Denomination.TWENTY.getValue()
							&& denom.getTwentysCount() >= 1) {
						hasAvailableDenom = true;
						denom.setTwentysCount(denom.getTwentysCount()-1);
						denomCountArrRemove[0]++;
					}
					 if(d.getValue() == Denomination.TEN.getValue()
							&& denom.getTensCount() >= 1) {
						hasAvailableDenom = true;
						denom.setTensCount(denom.getTensCount()-1);
						denomCountArrRemove[1]++;
					}
					 if(d.getValue() == Denomination.FIVE.getValue()
							&& denom.getFivesCount() >= 1) {
						hasAvailableDenom = true;
						denom.setFivesCount(denom.getFivesCount()-1);
						denomCountArrRemove[2]++;
					}
					 if(d.getValue() == Denomination.TWO.getValue()
							&& denom.getTwosCount() >= 1) {
						hasAvailableDenom = true;
						denom.setTwosCount(denom.getTwosCount()-1);
						denomCountArrRemove[3]++;
					}
					 if(d.getValue() == Denomination.ONE.getValue()
							&& denom.getOnesCount() >= 1) {
						hasAvailableDenom = true;
						denom.setOnesCount(denom.getOnesCount()-1);
						denomCountArrRemove[4]++;
					}
					if(hasAvailableDenom)
						change -= d.getValue();
						break;
				}
			}
			if(change > 0) {
				computeChange(change, account, denomCountArrRemove);
			} else {
				System.out.println(Arrays.toString(denomCountArrRemove)
						.substring(1).replaceFirst("]", "").replace(", ", " "));
				account.setTotal(getTotal(denom));
			}
		} catch (StackOverflowError e) {
			throw new Exception("sorry");
		}
	}

	private static BigDecimal getTotal(DenominationCount denom) {
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(new BigDecimal(denom.getTwentysCount() * Denomination.TWENTY.getValue()));
		total = total.add(new BigDecimal(denom.getTensCount() * Denomination.TEN.getValue()));
		total = total.add(new BigDecimal(denom.getFivesCount() * Denomination.FIVE.getValue()));
		total = total.add(new BigDecimal(denom.getTwosCount() * Denomination.TWO.getValue()));
		total = total.add(new BigDecimal(denom.getOnesCount() * Denomination.ONE.getValue()));
		return total;
	}

}
