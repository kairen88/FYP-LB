/*
 * File Name: TicksTest.java
 * Created on Nov 18, 2008 by user, fh8.
 * 
 * PVCS LOG:
 * $Workfile$
 * $Header$
 * $Revision$
 * $Date$
 * $Modtime$
 * $Log$
 */

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class TicksTest {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		
		Random random = new Random();
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		TimeSeries series = new TimeSeries("Foo");
		for(int monthIdx = 2; monthIdx < 6; monthIdx++){
			series.add(new Day(13, monthIdx+1, 2008), monthIdx * random.nextInt());
		}
		dataset.addSeries(series);
		JFreeChart chart = ChartFactory.createTimeSeriesChart("", // title
				"Date", // x-axis label
				"", // y-axis label
				dataset, // data
				false, // create legend?
				false, // generate tooltips?
				false // generate URLs?
				);
		final XYPlot plot = (XYPlot) chart.getPlot();
		final DateAxis axis = ((DateAxis) plot.getDomainAxis());
		DateTickUnit unit = new DateTickUnit(DateTickUnit.MONTH, 1, new SimpleDateFormat("MM/dd/yyyy"));
		axis.setTickUnit(unit);
		axis.setTickMarkPosition(DateTickMarkPosition.END);
		
		ChartPanel panel = new ChartPanel(chart);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
		
		//saveChart(chart, "foo.png");
	}
	
//	private static void saveChart(JFreeChart chart, String fileName) throws IOException {
//		ChartRenderingInfo info = new ChartRenderingInfo();
//		int width = 640;
//		int height = width * 3 / 4;
//		ChartUtilities.saveChartAsPNG(new File(fileName), chart, width,
//				height, info, true, 9);
//		System.out.println("Saved to file: " + fileName);
//	}
}
