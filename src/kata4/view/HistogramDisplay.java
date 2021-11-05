package kata4.view;

import java.awt.Dimension;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {

    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("Histogram");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(600, 500));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart(
                null, "Dominios", "Nº Emails", dataset,
                PlotOrientation.VERTICAL, false, true, false);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
        dataset.addValue(histogram.get(key), "", key);
        }
        return dataset;
    }
    
    public void execute(){
        setVisible(true);
    }
    
}
