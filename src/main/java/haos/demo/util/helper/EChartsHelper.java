package haos.demo.util.helper;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.icepear.echarts.Bar;
import org.icepear.echarts.Line;
import org.icepear.echarts.Pie;
import org.icepear.echarts.charts.bar.BarSeries;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.charts.pie.PieDataItem;
import org.icepear.echarts.charts.pie.PieSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.origin.chart.pie.PieDataItemOption;
import org.icepear.echarts.render.Engine;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Slf4j
public class EChartsHelper {

    /**
     * 生成可渲染的折线图JSON串
     * @param dataSet
     * @param xAxis
     * @return
     */
    public static String renderLine(String title, Map<String, Number[]> dataSet, List<String> xAxis) {

        if (CollectionUtils.isEmpty(dataSet)
                || CollectionUtils.isEmpty(xAxis)) {
            return "";
        }

        try {
            Line lineChart = new Line()
                    .addXAxis(new CategoryAxis()
                            .setData(xAxis.toArray())
                            .setBoundaryGap(false))
                    .addYAxis();
            lineChart.setTitle(title);

            for (Map.Entry<String, Number[]> me : dataSet.entrySet()) {
                LineSeries series = new LineSeries()
                        .setData(me.getValue())
                        .setName(me.getKey());
                lineChart.addSeries(series);
            }

            Engine engine = new Engine();

            return wrapOptions(engine.renderJsonOption(lineChart));
        } catch (Exception e) {
            log.error("渲染折线图失败", e);
            return "";
        }
    }

    /**
     * 包上一层options字段，方便前端渲染
     * @param origin
     * @return
     */
    public static String wrapOptions(String origin) {
        JSONObject data = JSONObject.parseObject(origin);
        JSONObject res = new JSONObject();
        res.put("options", data);
        return res.toJSONString();
    }

    /**
     * 渲染平铺柱状图
     * @param dataSet
     * @param xAxis
     * @return
     */
    public static String renderBarWithFlat(String title, Map<String, Number[]> dataSet, List<String> xAxis) {
        return renderBar(title, dataSet, xAxis, true);
    }

    /**
     * 渲染堆叠柱状图
     * @param dataSet
     * @param xAxis
     * @return
     */
    public static String renderBarWithStack(String title, Map<String, Number[]> dataSet, List<String> xAxis) {
        return renderBar(title, dataSet, xAxis, false);
    }

    /**
     * 渲染柱状图
     * @param dataSet
     * @param xAxis
     * @param flat
     * @return
     */
    public static String renderBar(String tile, Map<String, Number[]> dataSet, List<String> xAxis, boolean flat) {

        if (CollectionUtils.isEmpty(dataSet)
                || CollectionUtils.isEmpty(xAxis)) {
            return "";
        }
        try {
            Bar bar = new Bar()
                    .setLegend()
                    .setTooltip("item")
                    .addXAxis(xAxis.toArray(new String[0]))
                    .addYAxis();
            bar.setTitle(tile);

            for (Map.Entry<String, Number[]> me : dataSet.entrySet()) {
                BarSeries series = new BarSeries()
                        .setData(me.getValue())
                        .setName(me.getKey());
                if (!flat) {
                    series.setStack("x");
                }
                bar.addSeries(series);
            }

            Engine engine = new Engine();
            return wrapOptions(engine.renderJsonOption(bar));
        } catch (Exception e) {
            log.error("渲染折线图失败", e);
            return "";
        }
    }

    /**
     * 渲染饼图
     * @param dataSet
     * @param title
     * @return
     */
    public static String renderPie(String title, Map<String, Number> dataSet) {
        if (CollectionUtils.isEmpty(dataSet)) {
            return "";
        }

        try {
            PieDataItemOption[] dataItemOptions = new PieDataItemOption[dataSet.size()];
            int index = 0;
            for (Map.Entry<String, Number> me: dataSet.entrySet()) {
                PieDataItem dataItem = new PieDataItem()
                        .setName(me.getKey())
                        .setValue(me.getValue());
                dataItemOptions[index ++] = dataItem;
            }

            PieSeries series = new PieSeries()
                    .setData(dataItemOptions);

            Pie pie = new Pie()
                    .addSeries(series)
                    .setTitle(title)
                    .setLegend()
                    .setTooltip("item");

            Engine engine = new Engine();
            return wrapOptions(engine.renderJsonOption(pie));
        } catch (Exception e) {
            log.error("渲染饼图失败", e);
            return "";
        }
    }

}
