package com.ftt.ec6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {
	private ArrayList<Row> rows = new ArrayList<Row>();
	private DoubleSummaryStatistics doubleSumRaisedAmt;
	
	public Report() {
		super();
	}
	
	private DoubleSummaryStatistics getDoubleSumRaisedAmt() {
		if(doubleSumRaisedAmt == null)
			doubleSumRaisedAmt = rows.stream().mapToDouble(r -> r.getRaisedAmt()).summaryStatistics();
		
		return doubleSumRaisedAmt;
	}
	
	public float getRaisedAmtTotal() {
		return (float) getDoubleSumRaisedAmt().getSum();
	}
	
	public float getRaisedAmtAverage() {
		return (float) getDoubleSumRaisedAmt().getAverage();
	}
	
	public float getRaisedAmtMax() {
		return (float) getDoubleSumRaisedAmt().getMax();
	}
	
	public float getRaisedAmtMin() {
		return (float) getDoubleSumRaisedAmt().getMin();
	}
	
	public float getRaisedAmtMedian() {
		int middle = this.rows.size() / 2;
		if(this.rows.size() % 2 == 0) {
			return (this.rows.get(middle -1).getRaisedAmt() + this.rows.get(middle).getRaisedAmt()) /2;
		} else {
			return this.rows.get(middle).getRaisedAmt();
		}
	}
	
	public Map<String, Double> getStateRaisedAmt() {
		return rows.stream()
				.collect(Collectors.groupingBy(row -> row.getState(), Collectors.summingDouble(Row::getRaisedAmt)));
	}

	public Map<String, Double> getCompanyRaisedAmtAverage() {
		return rows.stream()
				.collect(Collectors.groupingBy(row -> row.getCompany(), Collectors.averagingDouble(Row::getRaisedAmt)));
	}
	
	public void loadCsv(String file, String csvSplitBy) {
		BufferedReader br = null;
        String line = "";
        
        try {
        	br = new BufferedReader(new FileReader(file));          
            br.readLine(); //pula a primeira linha (cabeçalho)
            
            while ((line = br.readLine()) != null) {
                rows.add(new Row(line.split(csvSplitBy)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}