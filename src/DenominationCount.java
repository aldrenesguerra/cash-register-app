
public class DenominationCount {
	
	private Integer twentysCount;
	private Integer tensCount;
	private Integer fivesCount;
	private Integer twosCount;
	private Integer onesCount;
	
	public DenominationCount() {}

	public DenominationCount(Integer twentysCount, Integer tensCount, Integer fivesCount, Integer twosCount,
			Integer onesCount) {
		super();
		this.twentysCount = twentysCount;
		this.tensCount = tensCount;
		this.fivesCount = fivesCount;
		this.twosCount = twosCount;
		this.onesCount = onesCount;
	}

	public Integer getTwentysCount() {
		return twentysCount;
	}

	public void setTwentysCount(Integer twentysCount) {
		this.twentysCount = twentysCount;
	}

	public Integer getTensCount() {
		return tensCount;
	}

	public void setTensCount(Integer tensCount) {
		this.tensCount = tensCount;
	}

	public Integer getFivesCount() {
		return fivesCount;
	}

	public void setFivesCount(Integer fivesCount) {
		this.fivesCount = fivesCount;
	}

	public Integer getTwosCount() {
		return twosCount;
	}

	public void setTwosCount(Integer twosCount) {
		this.twosCount = twosCount;
	}

	public Integer getOnesCount() {
		return onesCount;
	}

	public void setOnesCount(Integer onesCount) {
		this.onesCount = onesCount;
	}
	
}
