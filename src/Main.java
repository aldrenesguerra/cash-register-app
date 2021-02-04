import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("=== Welcome to Cash Register App ===");
		
		Account account = new Account("", new BigDecimal(68));
		DenominationCount denom = new DenominationCount(1,2,3,4,5);
		account.setDenomination(denom);
		
		System.out.println("show, put, take, change, exit");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			String command = s.nextLine();
			String action = Util.getAction(command);
			switch(action) {
			
				case "show":
					Util.printAccount(account);
					break;
				
				case "put":
					Util.putMoney(account, command);
					break;
					
				case "take":
					Util.takeMoney(account, command);
					break;
				
				case "change":
					Util.requestChange(account, command);
					break;
					
				case "quit":
					System.out.println("Bye!");
					System.exit(0);
				
				default:
					break;
			
			}
			
		}
		
	}

}
