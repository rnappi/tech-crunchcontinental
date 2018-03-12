package com.ftt.ec6;

public class Main {
	
	public static void main(String[] args) {
		Report report = new Report();
		report.loadCsv(System.getProperty("user.dir") + "\\files\\TechCrunchcontinentalUSA.csv", ",");
		
		// item a
		System.out.println("Total: $" + String.format("%.2f", report.getRaisedAmtTotal()));
		System.out.println("Média: $" + String.format("%.2f", report.getRaisedAmtAverage()));
		System.out.println("Max: $" + String.format("%.2f", report.getRaisedAmtMax()));
		System.out.println("Min: $" + String.format("%.2f", report.getRaisedAmtMin()));
		System.out.println("Median: $" + String.format("%.2f", report.getRaisedAmtMedian()));
		
		
		// item b
		report.getStateRaisedAmt().forEach((state, raisedAmt) -> {
			String _raisedAmt = String.format("%.2f", raisedAmt);
			System.out.println("State: " + state + " - RaisedAmt: " + _raisedAmt);
		});
		
		
		// item c
		report.getCompanyRaisedAmtAverage().forEach((company, raisedAmt) -> {
			String _raisedAmt = String.format("%.2f", raisedAmt);
			System.out.println("Company: " + company + " - RaisedAmt: " + _raisedAmt);
		});		
	}
}