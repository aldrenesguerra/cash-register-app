
public enum Denomination {
	
	TWENTY(20),
	TEN(10),
	FIVE(5),
	TWO(2),
	ONE(1);

	private final int value;
	Denomination(int value) {
		this.value = value;
	}
	
	public int getValue() {
        return this.value;
    }
	
}
