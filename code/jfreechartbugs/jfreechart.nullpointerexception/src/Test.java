import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        DefaultBoxAndWhiskerXYDataset set =
                new DefaultBoxAndWhiskerXYDataset("1");
        BoxAndWhiskerItem item = new BoxAndWhiskerItem(0.5, 0.5, 0.2, 0.7, 0.1, 0.9, null, null, null);
        set.add(new Date(), item);

        JFreeChart boxchart = ChartFactory.createBoxAndWhiskerChart(
                "Graph", "label", "label", set, false);
        ChartPanel boxpanel = new ChartPanel(boxchart);
        frame.setLayout(new BorderLayout());
        frame.add(boxpanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

