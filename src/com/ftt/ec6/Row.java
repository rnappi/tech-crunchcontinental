package com.ftt.ec6;

public class Row {
	private String permalink;
	private String company;
	private int numEmps;
	private String category;	
	private String city;
	private String state;
	private float raisedAmt;
	private String raisedCurrency;
	private String round;

	public Row(String[] ln) {
		super();
		setPermalink(ln[0]);
		setCompany(ln[1]);
		setNumEmps(ln[2]);
		setCategory(ln[3]);
		setCity(ln[4]);
		setState(ln[5]);
		setRaisedAmt(ln[7]);
		setRaisedCurrency(ln[8]);
		setRound(ln[9]);
	}

	public String getPermalink() {
		return permalink;
	}

	private void setPermalink(String permalink) {
		this.permalink = permalink.trim();
	}

	public String getCompany() {
		return company;
	}

	private void setCompany(String company) {
		this.company = company.trim();
	}

	public int getNumEmps() {
		return numEmps;
	}

	private void setNumEmps(String numEmps) {
		if(numEmps.equals("")) {
			this.setNumEmps(0);
		} else {
			this.setNumEmps(Integer.valueOf(numEmps));
		}
	}
	
	private void setNumEmps(int numEmps) {
		this.numEmps = numEmps;
	}

	public String getCategory() {
		return category;
	}

	private void setCategory(String category) {
		this.category = category.trim();
	}

	public String getCity() {
		return city;
	}

	private void setCity(String city) {
		this.city = city.trim();
	}

	public String getState() {
		return state;
	}

	private void setState(String state) {
		this.state = state.trim();
	}

	public float getRaisedAmt() {
		return raisedAmt;
	}

	private void setRaisedAmt(String raisedAmt) {
		if(raisedAmt.equals("")) {
			this.setRaisedAmt(0);
		} else {
			this.setRaisedAmt(Float.valueOf(raisedAmt));
		}
	}
	
	private void setRaisedAmt(float raisedAmt) {
		this.raisedAmt = raisedAmt;
	}

	public String getRaisedCurrency() {
		return raisedCurrency;
	}

	private void setRaisedCurrency(String raisedCurrency) {
		this.raisedCurrency = raisedCurrency.trim();
	}

	public String getRound() {
		return round;
	}

	private void setRound(String round) {
		this.round = round.trim();
	}
}