import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class StackChart3DNoNegativeZeroTest extends ApplicationFrame {

	private static final long serialVersionUID = 6114407005941405422L;

	// the dataSet containing all data to be shown
	private DefaultCategoryDataset dataSet;

	// the colors to be used for the different categories
	private List<Color> colors;

	public StackChart3DNoNegativeZeroTest(String title) {
		super(title);
		JPanel chartPanel = createDemoPanel();
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
	}

	private JFreeChart createChartFromData() {
		JFreeChart chart;

		PlotOrientation plotOrientation = PlotOrientation.HORIZONTAL;

		chart = ChartFactory.createStackedBarChart3D(null, // chart
				// title
				"xAxis", // domain axis label
				"yAxis", // range axis label
				dataSet, // data
				plotOrientation, // the plot orientation
				true, // legend
				true, // tooltips
				false // urls
				);

		TextTitle textTitle = new TextTitle();
		textTitle.setText("StackChartBugDemo");
		textTitle.setExpandToFitSpace(true);
		textTitle.setFont(textTitle.getFont().deriveFont(15f));
		chart.setAntiAlias(true);
		chart.setTextAntiAlias(true);
		chart.setTitle(textTitle);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.getDomainAxis().setTickLabelInsets(new RectangleInsets(5, 5, 5, 5));

		chart.setBackgroundPaint(Color.WHITE);

		// set label generator
		CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getInstance()));
		renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}: {2}", NumberFormat.getInstance()));
		// labels always visible
		renderer.setBaseItemLabelsVisible(true);

		// set the colors for each category
		if (colors != null && colors.isEmpty() == false) {
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				int colorNr = i % colors.size();
				renderer.setSeriesPaint(i, colors.get(colorNr));
			}
		}

		return (chart);
	}

	public void createStackDataSeries() {
		colors = new LinkedList<Color>();
		colors.add(Color.BLUE);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
		colors.add(Color.RED);

		dataSet = new DefaultCategoryDataset();

		// example data that will be display with wrong colors and labels (if
		// StackedBarRenderer3D was not fixed)
		dataSet.setValue(-1.0, "series1", "category1");
		dataSet.setValue(-4.0, "series2", "category1");
		dataSet.setValue(-7.0, "series3", "category1");

		dataSet.setValue(-2.0, "series1", "category2");
		dataSet.setValue(-5.0, "series2", "category2");
		dataSet.setValue(8.0, "series3", "category2");

		dataSet.setValue(-2.0, "series1", "category3");
		dataSet.setValue(5.0, "series2", "category3");
		dataSet.setValue(-8.0, "series3", "category3");

		dataSet.setValue(-3.0, "series1", "category4");
		dataSet.setValue(6.0, "series2", "category4");
		dataSet.setValue(9.0, "series3", "category4");
		dataSet.setValue(-9.0, "series4", "category4");

		// example data that will be display correct
		dataSet.setValue(3.0, "series1", "category5");
		dataSet.setValue(6.0, "series2", "category5");
		dataSet.setValue(9.0, "series3", "category5");

		dataSet.setValue(2.0, "series1", "category6");
		dataSet.setValue(-5.0, "series2", "category6");
		dataSet.setValue(-8.0, "series3", "category6");

		dataSet.setValue(2.0, "series1", "category7");
		dataSet.setValue(5.0, "series2", "category7");
		dataSet.setValue(-8.0, "series3", "category7");

		dataSet.setValue(2.0, "series1", "category8");
		dataSet.setValue(-5.0, "series2", "category8");
		dataSet.setValue(8.0, "series3", "category8");
	}

	public JPanel createDemoPanel() {
		createStackDataSeries();
		JFreeChart chart = createChart();
		return new ChartPanel(chart);
	}

	public JFreeChart createChart() {
		if (this.dataSet != null) {
			JFreeChart chart = createChartFromData();
			return chart;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		StackChart3DNoNegativeZeroTest demo = new StackChart3DNoNegativeZeroTest("StackChartBugDemo");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}
