import java.awt.*;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.chart.entity.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.title.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;

public class PieChartDemo1 extends ApplicationFrame implements ChartMouseListener {
    public static final long serialVersionUID = 1L;
    public static JFreeChart chart;

    public PieChartDemo1(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", new Double(43.2));
        dataset.setValue("Two", new Double(10.0));
        dataset.setValue("Three", new Double(27.5));
        dataset.setValue("Four", new Double(17.5));
        dataset.setValue("Five", new Double(11.0));
        dataset.setValue("Six", new Double(19.4));
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart Demo 1",
            dataset,
            true,
            true,
            false
        );
        TextTitle title = chart.getTitle();
        title.setToolTipText("A title tooltip!");

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }

    public JPanel createDemoPanel() {
        chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.addChartMouseListener(this);
        return panel;
    }

    public void chartMouseClicked(ChartMouseEvent event) {
        ChartEntity e = event.getEntity();
        if (e != null) {
            if (e instanceof LegendItemEntity) {
                LegendItemEntity entity = (LegendItemEntity) e;
                Comparable seriesKey = entity.getSeriesKey(); 
                System.out.println(entity.toString());
                PiePlot plot = (PiePlot) this.chart.getPlot();
                DefaultPieDataset dataset = (DefaultPieDataset)plot.getDataset();
                for (int i = 0; i < dataset.getItemCount(); i++) {
                    plot.setSectionOutlineStroke(dataset.getKey(i), new BasicStroke(1.0f));
                    if (dataset.getKey(i).equals(seriesKey)) {
                        plot.setSectionOutlineStroke(dataset.getKey(i), new BasicStroke(2.0f));
                    }
                }
            }
        }
    }

    public void chartMouseMoved(ChartMouseEvent event) {
        // ignore
    }

    public static void main(String[] args) {

        PieChartDemo1 demo = new PieChartDemo1("Pie Chart Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
} 