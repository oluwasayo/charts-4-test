package com.stuff;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;

@Title("Charts 4 Demo")
public class DemoView extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Chart chart = new Chart(ChartType.BAR);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Historic World Population by Region");
        conf.setSubTitle("Source: Wikipedia.org");

        XAxis x = new XAxis();
        x.setCategories("Africa", "America", "Asia", "Europe", "Oceania");
        x.setTitle((String) null);
        conf.addxAxis(x);

        YAxis y = new YAxis();
        y.setMin(0);
        AxisTitle title = new AxisTitle("Population (millions)");
        title.setAlign(VerticalAlign.MIDDLE);
        y.setTitle(title);
        conf.addyAxis(y);

        Tooltip tooltip = new Tooltip();
        tooltip.setFormatter("this.series.name +': '+ this.y +' millions'");
        conf.setTooltip(tooltip);

        PlotOptionsBar plot = new PlotOptionsBar();
        plot.setDataLabels(new DataLabels(true));
        conf.setPlotOptions(plot);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(-100);
        legend.setY(100);
        legend.setFloating(true);
        legend.setBorderWidth(1);
        legend.setBackgroundColor(new SolidColor("#FFFFFF"));
        legend.setShadow(true);
        conf.setLegend(legend);

        conf.disableCredits();

        List<Series> series = new ArrayList<Series>();
        series.add(new ListSeries("Year 1800", 107, 31, 635, 203, 2));
        series.add(new ListSeries("Year 1900", 133, 156, 947, 408, 6));
        series.add(new ListSeries("Year 2008", 973, 914, 4054, 732, 34));
        conf.setSeries(series);

        chart.drawChart(conf);

        setContent(chart);
    }
}
