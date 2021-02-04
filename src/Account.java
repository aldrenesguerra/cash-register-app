import java.math.BigDecimal;

public class Account {
	
	private String name;
	private BigDecimal total;
	private DenominationCount denomination;
	
	public Account() {}
	
	public Account(String name, BigDecimal total) {
		super();
		this.name = name;
		this.total = total;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public DenominationCount getDenomination() {
		return denomination;
	}
	public void setDenomination(DenominationCount denomination) {
		this.denomination = denomination;
	}

}
