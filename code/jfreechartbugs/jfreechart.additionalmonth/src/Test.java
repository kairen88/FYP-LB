

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Test extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Test(String title) {
		super(title);
		ChartPanel panel = createDemoPanel();
		panel.setPreferredSize(new Dimension(1200, 800));
		panel.setMouseZoomable(true,false);
		setContentPane(panel);
	}

	
	@SuppressWarnings("deprecation")
	public JFreeChart createChart(){
		JFreeChart chart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices",
															"Date",
															"Price Per Unit",
															null,
															false,
															true,
															false);
		
		XYPlot plot = (XYPlot)chart.getPlot();
		//assume the JVM time zone is "Europe/Berlin", which has daylight saving time.
		TimeZone tz = TimeZone.getTimeZone("GMT+1");// using the different time zone setting with JVM
//		TimeZone tz = TimeZone.getDefault();	//using the same time zone setting with JVM
		Calendar from = new GregorianCalendar(tz);
		Calendar until = new GregorianCalendar(tz);
	    from.setTimeInMillis(0);
		from.set(2007, 10, 1, 0, 0, 0);
		until.setTimeInMillis(0);
		until.set(2008, 1, 1, 0, 0, 1);
		
		
		
		long from1 = from.getTimeInMillis();
		long until1 = until.getTimeInMillis();
		DateAxis a = new DateAxis("", tz);
		a.setRange(from1, until1);
		
		
		a.setTickUnit(new DateTickUnit(1, 1));
		DateFormat mydf = new SimpleDateFormat("yy.MMM.dd HH:mm:SS");
		mydf.setTimeZone(tz);
		a.setDateFormatOverride(mydf);
		plot.setDomainAxis(a);
		
		return chart;
		
	}
	
	public ChartPanel createDemoPanel(){
		JFreeChart chart = createChart();
		return new ChartPanel(chart);
	}
	
	public static void main(String[] args){
		Test lineChart = new Test("Time Series Demo 1");
		lineChart.pack();
		RefineryUtilities.centerFrameOnScreen(lineChart);
		lineChart.setVisible(true);
	}
	
}
