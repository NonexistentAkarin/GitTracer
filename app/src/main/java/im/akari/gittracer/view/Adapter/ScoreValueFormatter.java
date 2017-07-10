package im.akari.gittracer.view.Adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * @author Alan created on 2017/6/24
 */

public class ScoreValueFormatter implements IAxisValueFormatter {

    private static String[] scoreMapping = {"0-9", "10-19", "20-29", "30-39", "40-49", "50-59", "60-69", "70-79", "80-89", "90-100"};

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return scoreMapping[(int) value - 1];
    }
}
