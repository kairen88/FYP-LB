import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class JFreeChartTest extends JFrame
{
    /**
     * java default serialization id
     */
    private static final long serialVersionUID = 1L;

    private static final long[] dates =
      { 1304892000000L, 1304632800000L, 1304546400000L, 1304460000000L,
         1304373600000L, 1304287200000L, 1320015600000L, 1309384800000L,
         1319752800000L, 1319666400000L, 1319580000000L, 1319493600000L,
         1319407200000L, 1319148000000L, 1319061600000L, 1309298400000L,
         1309212000000L, 1309125600000L, 1308866400000L, 1308780000000L,
         1308693600000L, 1308607200000L, 1308520800000L, 1318975200000L,
         1318888800000L, 1318802400000L, 1318456800000L, 1318370400000L,
         1318284000000L, 1318197600000L, 1308261600000L, 1308175200000L,
         1308088800000L, 1308002400000L, 1307916000000L, 1307656800000L,
         1317938400000L, 1317852000000L, 1317765600000L, 1317679200000L,
         1317592800000L, 1307570400000L, 1307484000000L, 1307397600000L,
         1307311200000L, 1307052000000L, 1306965600000L, 1306879200000L,
         1322607600000L, 1322521200000L, 1322434800000L, 1322175600000L,
         1322089200000L, 1322002800000L, 1321916400000L, 1321830000000L,
         1326409200000L, 1326322800000L, 1326236400000L, 1326150000000L,
         1311890400000L, 1311804000000L, 1311717600000L, 1311631200000L,
         1311544800000L, 1311285600000L, 1311199200000L, 1311112800000L,
         1296428400000L, 1321570800000L, 1321484400000L, 1321398000000L,
         1321311600000L, 1326063600000L, 1321225200000L, 1320966000000L,
         1325718000000L, 1320879600000L, 1325631600000L, 1325545200000L,
         1325458800000L, 1311026400000L, 1310940000000L, 1310680800000L,
         1296169200000L, 1310594400000L, 1296082800000L, 1310508000000L,
         1295996400000L, 1310421600000L, 1295910000000L, 1310335200000L,
         1295823600000L, 1295564400000L, 1295478000000L, 1320793200000L,
         1320706800000L, 1320620400000L, 1320361200000L, 1320274800000L,
         1320188400000L, 1320102000000L, 1310076000000L, 1309989600000L,
         1309903200000L, 1295391600000L, 1309816800000L, 1295305200000L,
         1309730400000L, 1295218800000L, 1309471200000L, 1294959600000L,
         1294873200000L, 1294786800000L, 1294700400000L, 1294614000000L,
         1325199600000L, 1314741600000L, 1294354800000L, 1314655200000L,
         1294268400000L, 1294182000000L, 1294095600000L, 1294009200000L,
         1325113200000L, 1325026800000L, 1324940400000L, 1324594800000L,
         1324508400000L, 1324422000000L, 1324335600000L, 1314568800000L,
         1314309600000L, 1314223200000L, 1314136800000L, 1314050400000L,
         1313964000000L, 1324249200000L, 1323990000000L, 1323903600000L,
         1323817200000L, 1323730800000L, 1323644400000L, 1313704800000L,
         1313618400000L, 1313532000000L, 1313445600000L, 1313359200000L,
         1298847600000L, 1313100000000L, 1313013600000L, 1298588400000L,
         1312927200000L, 1298502000000L, 1298415600000L, 1298329200000L,
         1298242800000L, 1323385200000L, 1323298800000L, 1323212400000L,
         1323126000000L, 1323039600000L, 1322780400000L, 1322694000000L,
         1312840800000L, 1312495200000L, 1297983600000L, 1312322400000L,
         1297897200000L, 1312236000000L, 1297810800000L, 1312149600000L,
         1297724400000L, 1297638000000L, 1297378800000L, 1297292400000L,
         1297206000000L, 1297119600000L, 1297033200000L, 1317333600000L,
         1296774000000L, 1296687600000L, 1296601200000L, 1296514800000L,
         1317247200000L, 1317160800000L, 1317074400000L, 1316988000000L,
         1316728800000L, 1316642400000L, 1316556000000L, 1316469600000L,
         1301522400000L, 1301436000000L, 1291071600000L, 1316383200000L,
         1316124000000L, 1316037600000L, 1301349600000L, 1315951200000L,
         1301263200000L, 1315864800000L, 1315778400000L, 1301007600000L,
         1300921200000L, 1300834800000L, 1300748400000L, 1300662000000L,
         1290985200000L, 1290726000000L, 1290639600000L, 1290553200000L,
         1290466800000L, 1290380400000L, 1315519200000L, 1315432800000L,
         1315346400000L, 1315260000000L, 1315173600000L, 1300402800000L,
         1300316400000L, 1314914400000L, 1300230000000L, 1314828000000L,
         1300143600000L, 1300057200000L, 1299798000000L, 1299711600000L,
         1290121200000L, 1290034800000L, 1299625200000L, 1299538800000L,
         1299452400000L, 1299193200000L, 1299106800000L, 1299020400000L,
         1298934000000L, 1293750000000L, 1293663600000L, 1304028000000L,
         1303941600000L, 1303855200000L, 1303768800000L, 1303336800000L,
         1303250400000L, 1293577200000L, 1293490800000L, 1293404400000L,
         1293145200000L, 1293058800000L, 1292972400000L, 1292886000000L,
         1292799600000L, 1303164000000L, 1303077600000L, 1302818400000L, 
         1302732000000L, 1302645600000L, 1302559200000L, 1302472800000L,
         1292540400000L, 1292454000000L, 1292367600000L, 1292281200000L,
         1292194800000L, 1291935600000L, 1302213600000L, 1302127200000L,
         1302040800000L, 1301954400000L, 1301868000000L, 1301608800000L,
         1291849200000L, 1291762800000L, 1291676400000L, 1291590000000L,
         1291330800000L, 1291244400000L, 1291158000000L, 1306792800000L,
         1306706400000L, 1306447200000L, 1306360800000L, 1306274400000L,
         1306188000000L, 1306101600000L, 1305842400000L, 1305756000000L,
         1305669600000L, 1305583200000L, 1305496800000L, 1305237600000L,
         1305151200000L, 1305064800000L, 1304978400000L };

    private static final double[] values =
        { 5.23, 5.33, 5.24, 5.26, 5.37, 5.39, 3.48, 4.7, 3.61, 3.73, 3.41, 3.43, 3.5,
           3.38, 3.22, 4.58, 4.44, 4.36, 4.4, 4.43, 4.53, 4.52, 4.43, 3.37, 3.24, 3.38,
           3.44, 3.65, 3.39, 3.4, 4.5, 4.47, 4.54, 4.58, 4.53, 4.53, 3.26, 3.25, 3.12,
           2.92, 3.01, 4.53, 4.51, 4.61, 4.6, 4.66, 4.65, 4.76, 3.23, 3.06, 3.02, 2.79,
           2.8, 2.8, 2.86, 2.93, 3.33, 3.41, 3.38, 3.27, 4.02, 4.09, 4.06, 4.16, 4.19,
           4.33, 4.33, 4.2, 5.41, 3.07, 3.13, 3.16, 3.15, 3.05, 3.23, 3.36, 3.07, 3.18,
           3.13, 3.2, 3.18, 4.04, 3.92, 4.14, 5.55, 4.2, 5.49, 4.31, 5.35, 4.31, 5.32,
           4.39, 5.37, 5.34, 5.33, 3.09, 3.3, 3.27, 3.33, 3.42, 3.33, 3.15, 4.59, 4.68,
           4.68, 5.29, 4.79, 5.35, 4.79, 5.28, 4.8, 5.2, 5.16, 5.07, 4.97, 4.85, 3.1,
           3.13, 4.92, 3.01, 4.86, 4.8, 4.69, 4.63, 3.11, 3.05, 3.17, 3.15, 3.14, 3.11,
           3.02, 2.99, 2.89, 2.97, 2.95, 2.87, 2.88, 2.87, 2.93, 2.93, 2.94, 3.1, 3.09,
           2.87, 2.91, 3.18, 3.18, 3.2, 5.57, 3.11, 2.86, 5.53, 2.97, 5.39, 5.45, 5.48,
           5.52, 3.36, 3.23, 3.34, 3.38, 3.37, 3.27, 3.13, 3.16, 3.37, 5.63, 3.59, 5.62,
           3.78, 5.61, 3.94, 5.51, 5.5, 5.56, 5.56, 5.63, 5.66, 5.58, 3.06, 5.59, 5.51,
           5.58, 5.62, 3.15, 3.07, 3.07, 2.84, 2.68, 2.73, 2.96, 2.96, 5.28, 5.36, 4.23,
           2.94,3.14, 3.04, 5.29, 2.91, 5.34, 2.82, 2.74, 5.31, 5.31, 5.23, 5.18, 5.21,
           4.32, 4.4, 4.49, 4.4, 4.42, 4.61, 2.87, 3.05, 2.96, 2.76, 2.83, 5.07, 5.03,
           3.02, 4.89, 3.17, 5.08, 5.21, 5.35, 5.5, 4.66, 4.72, 5.68, 5.6, 5.52, 5.55,
           5.5, 5.46, 5.53, 4.58, 4.61, 5.36, 5.37, 5.4, 5.38, 5.21, 5.17, 4.63, 4.64,
           4.61, 4.61, 4.62, 4.64, 4.62, 4.53, 5.05, 5.04, 5.3, 5.34, 5.44, 5.45, 5.55,
           4.51, 4.6, 4.64, 4.66, 4.62, 4.58, 5.58, 5.53, 5.56, 5.5, 5.48, 5.49, 4.64,
           4.5, 4.47, 4.46, 4.48, 4.47, 4.42, 4.86, 4.8, 4.86, 4.66, 4.71, 4.68, 4.67,
           4.83, 4.88, 4.9, 4.84, 4.89, 4.97, 5.07, 5.38, 5.28 };

    public JFreeChartTest()
    {
        super( "JFreeChartTest" );
    } // JFreeChartTest::JFreeChartTest()

    public void displayChart()
    {
        final JFreeChart chart = this.createChart();
        final ChartPanel chartPanel = new ChartPanel( chart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 500, 270 ) );
        setContentPane( chartPanel );
        this.pack();
        this.setVisible( true );
    } // JFreeChartTest::displayChart()

    private JFreeChart createChart()
    {
        DateAxis domainAxis = new DateAxis( "Datum" );
        domainAxis.setLowerMargin(0.0);
        domainAxis.setUpperMargin(0.0);
        domainAxis.setDateFormatOverride( new SimpleDateFormat( "dd.MM.yyyy" ) );
        // set start and end date
        Arrays.sort( dates );
        Date start = new Date( dates[ 0 ] );
        Date end = new Date( dates[ dates.length - 1 ] );
        domainAxis.setMinimumDate( start );
        domainAxis.setMaximumDate( end );
        
        SegmentedTimeline timeline = SegmentedTimeline.newMondayThroughFridayTimeline();
        timeline.setAdjustForDaylightSaving( true );
        timeline.setStartTime( start.getTime() );
        domainAxis.setTimeline( timeline );
        
        NumberAxis rangeAxis = new NumberAxis( "Messwert" );

        XYBarRenderer renderer = new XYBarRenderer();
        renderer.setShadowVisible( false );
        renderer.setBaseFillPaint( Color.BLACK );
        DecimalFormat volumeformat = new DecimalFormat( "0.00" );
        volumeformat.setGroupingSize( 3 );
        volumeformat.setGroupingUsed( true );
        renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator(
                StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
                new SimpleDateFormat( "dd.MM.yyyy" ),
                volumeformat ) );

        TimeSeries valueseries = new TimeSeries( "Meßwerte" );
        for( int i = 0; i < dates.length; i++ )
        {
            if( i > values.length - 1 )
            {
                break;
            }
            Date date = new Date( dates[ i ] ); 
            Day currentday = new Day( date );            
            valueseries.add( currentday, values[ i ] );
        } // for( int i = 0; i < dates.length; i++ )
        TimeSeriesCollection collection = new TimeSeriesCollection( valueseries );

        XYPlot plot1 = new XYPlot( collection , domainAxis, rangeAxis, renderer );
        plot1.setBackgroundPaint( Color.WHITE );
        plot1.setDomainGridlinePaint( Color.LIGHT_GRAY );
        AxisSpace axisspace = new AxisSpace();
        plot1.setFixedRangeAxisSpace( axisspace );

        // create the chart
        JFreeChart chart = new JFreeChart("Handelsvolumen" ,
                JFreeChart.DEFAULT_TITLE_FONT, plot1, false);
        chart.setNotify( false );
        LegendTitle legend = new LegendTitle( plot1 );
        chart.addSubtitle(legend);
        return chart;
    } // JFreeChartTest::createChart()

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        JFreeChartTest test = new JFreeChartTest();
        test.displayChart();
    } // JFreeChartTest::main()

}