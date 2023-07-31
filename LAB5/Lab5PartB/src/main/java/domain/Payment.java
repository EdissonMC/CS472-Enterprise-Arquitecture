package domain;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
	private String payDate;
	private double amount;

	public Payment() {
	}

	public Payment(String payDate, double amount) {
		this.payDate = payDate;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "\n\n" +
				"Payment{" +
				"payDate='" + payDate + '\'' +
				", amount=" + amount +
				'}';
	}
}
