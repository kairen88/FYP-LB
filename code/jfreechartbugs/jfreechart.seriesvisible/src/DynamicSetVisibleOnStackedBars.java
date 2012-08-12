import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * Illustrates that series in stack bars cannot be set to non visible
 */
public class DynamicSetVisibleOnStackedBars extends ApplicationFrame {
	private static final long serialVersionUID = 1L;
	
	static class MyDemoPanel extends JPanel implements ActionListener {
		private static final long serialVersionUID = 1L;
		
		private XYItemRenderer renderer;
		
		public MyDemoPanel() {
			super(new BorderLayout());
			XYDataset dataset = createSampleDataset();
			JFreeChart chart = createChart(dataset);
			ChartPanel chartPanel = new ChartPanel(chart);
			JPanel boxPanel = new JPanel();
			JCheckBox box1 = new JCheckBox("Series 1");
			box1.setActionCommand("S1");
			box1.addActionListener(this);
			box1.setSelected(true);
			JCheckBox box2 = new JCheckBox("Series 2");
			box2.setActionCommand("S2");
			box2.addActionListener(this);
			box2.setSelected(true);
			boxPanel.add(box1);
			boxPanel.add(box2);
			add(chartPanel);
			add(boxPanel, BorderLayout.SOUTH);
			chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		}
		
		private XYDataset createSampleDataset() {
			DefaultTableXYDataset dataset = new DefaultTableXYDataset();
			
			XYSeries s1 = new XYSeries("Series 1", true, false);
			s1.add(1.0, 5.0);
			s1.add(2.0, 15.5);
			s1.add(3.0, 9.5);
			s1.add(4.0, 7.5);
			dataset.addSeries(s1);
			
			XYSeries s2 = new XYSeries("Series 2", true, false);
			s2.add(1, 5.0);
			s2.add(2, 15.5);
			s2.add(3, 9.5);
			s2.add(4, 3.5);
			dataset.addSeries(s2);
			
			return dataset;
		}
		
		private JFreeChart createChart(XYDataset dataset) {
			
			NumberAxis domainAxis = new NumberAxis("X");
			domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			NumberAxis rangeAxis = new NumberAxis("Y");
			StackedXYBarRenderer renderer = new StackedXYBarRenderer(0.10);
			this.renderer = renderer;
			renderer.setDrawBarOutline(false);
			
			XYPlot plot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);
			JFreeChart chart = new JFreeChart("Stacked XY Bar Chart Demo", plot);
			ChartUtilities.applyCurrentTheme(chart);
			return chart;
		}
		
		public void actionPerformed(ActionEvent e) {
			int series = -1;
			if (e.getActionCommand().equals("S1")) {
				series = 0;
			} else if (e.getActionCommand().equals("S2")) {
				series = 1;
			}
			
			if (series >= 0) {
				boolean visible = this.renderer.getItemVisible(series, 0);
				this.renderer.setSeriesVisible(series, new Boolean(!visible));
			}
		}
		
	}
	
	public DynamicSetVisibleOnStackedBars(String title) {
		super(title);
		setContentPane(new MyDemoPanel());
	}
	
	public static JPanel createDemoPanel() {
		return new MyDemoPanel();
	}
	
	public static void main(String[] args) {
		DynamicSetVisibleOnStackedBars demo = new DynamicSetVisibleOnStackedBars("JFreeChart: DynamicSetVisibleOnStackedBars.java");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}
	
}
