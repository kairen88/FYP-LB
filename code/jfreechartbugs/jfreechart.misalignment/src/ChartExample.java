import javax.swing.JFrame;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;


public class ChartExample extends JFrame {

	public static void main(String[] args) {
		ChartFrame demo = new ChartFrame("Test", createChart());
		demo.pack();
		demo.setVisible(true);
	}
		
	private static StatisticalCategoryDataset createDataset() {
		DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
		dataset.add(1.561, 0.5, "foo", "No");
		//dataset.add(0.640, 0.2, "foo", "Yes");
		//dataset.add(0.9, 0.3, "foo", "Other");
		return dataset;
	}
	
	private static JFreeChart createChart() {
		final StatisticalBarRenderer renderer = new StatisticalBarRenderer();
		renderer.setMaximumBarWidth(0.15);
		
		CategoryAxis xAxis = new CategoryAxis("");
		NumberAxis yAxis = new NumberAxis("");
		
		CategoryPlot plot = new CategoryPlot(createDataset(), xAxis, yAxis,
		renderer);
		
		final JFreeChart chart = new JFreeChart(plot);
		return chart;
	}

}