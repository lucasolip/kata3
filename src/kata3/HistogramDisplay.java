package kata3;

import java.awt.Container;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

public class HistogramDisplay extends ApplicationFrame {

    private final Histogram<String> histogram;
    
    public HistogramDisplay(String title, Histogram histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", 
                "email domains", 
                "nº emails", 
                dataset, 
                PlotOrientation.VERTICAL, 
                false, 
                false, 
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (String key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", key);
        }

        return dataset;
    }
    
    public void execute() {
        setVisible(true);
    }
}
