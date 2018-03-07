package com.ftt.ec6;

public class Main {
	
	public static void main(String[] args) {
		Report report = new Report();
		report.loadCsv(System.getProperty("user.dir") + "\\files\\TechCrunchcontinentalUSA.csv", ",");
		
		// item a
		System.out.println("Total: " + report.getRaisedAmtTotal());
		System.out.println("Média: " + report.getRaisedAmtAverage());
		System.out.println("Max: " + report.getRaisedAmtMax());
		System.out.println("Min: " + report.getRaisedAmtMin());
	}
}