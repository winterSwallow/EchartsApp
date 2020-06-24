package com.winter.echarts;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EchartOptionUtil {

    public static GsonOption getBingTuChartOptions() {
        Object[] data = new Object[5];
        List<Map<String, Object>> yAxis = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data[i] = "方法" + i;
            Map<String, Object> data1 = new HashMap<>();
            data1.put("value", i * 0.5f + "");
            data1.put("name", "方法" + i);
            yAxis.add(data1);
        }

        GsonOption option = new GsonOption();
        option.title("支付方式占比");
        option.title().setX(X.center);

        option.tooltip().trigger(Trigger.item);
        option.tooltip().formatter("{a} {b}:{c} ({d}%)");

        option.legend().left(X.left).orient(Orient.vertical);
        option.legend().data(data);

        Pie pie = new Pie();
        pie.name("");
        pie.type(SeriesType.pie);
        pie.center("50%", "70%").radius("55%");
        pie.itemStyle().emphasis().shadowBlur(10).shadowOffsetX(0).shadowColor("rgba(0, 0, 0, 0.5)");
        pie.setData(yAxis);
        option.series(pie);
        return option;
    }

    public static GsonOption getLineChartOptions() {
        Object[] xAxis = new Object[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        Object[] yAxis = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320
        };
        GsonOption option = new GsonOption();
        option.title("折线图");
        option.legend("销量");
        option.tooltip().trigger(Trigger.axis);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLine().onZero(false);
        categorxAxis.boundaryGap(true);
        categorxAxis.data(xAxis);
        option.xAxis(categorxAxis);

        Line line = new Line();
        line.smooth(false).name("销量").data(yAxis).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option.series(line);
        return option;
    }
}
