package lecho.lib.hellocharts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data model for line chart.
 * 
 * @author Leszek Wach
 * 
 */
public class LineChartData extends AbstractChartData {

	private List<Line> lines = new ArrayList<Line>();
	private float baseValue = Float.NaN;

	public LineChartData() {

	}

	public LineChartData(List<Line> lines) {
		setLines(lines);
	}

	/**
	 * Copy constructor to perform deep copy of chart data.
	 */
	public LineChartData(LineChartData data) {
		super(data);
		this.baseValue = data.baseValue;

		for (Line line : data.lines) {
			this.lines.add(new Line(line));
		}
	}

	@Override
	public void update(float scale) {
		for (Line line : lines) {
			line.update(scale);
		}
	}

	@Override
	public void finish() {
		for (Line line : lines) {
			line.finish();
		}
	}

	public List<Line> getLines() {
		return lines;
	}

	public LineChartData setLines(List<Line> lines) {
		if (null == lines) {
			this.lines = new ArrayList<Line>();
		} else {
			this.lines = lines;
		}
		return this;
	}

	public float getBaseValue() {
		return baseValue;
	}

	public LineChartData setBaseValue(float baseValue) {
		this.baseValue = baseValue;
		return this;
	}

	public static LineChartData generateDummyData() {
		final int numValues = 4;
		LineChartData data = new LineChartData();
		List<PointValue> values = new ArrayList<PointValue>(numValues);
		values.add(new PointValue(0, 2));
		values.add(new PointValue(1, 4));
		values.add(new PointValue(2, 3));
		values.add(new PointValue(3, 4));
		Line line = new Line(values);
		List<Line> lines = new ArrayList<Line>(1);
		lines.add(line);
		data.setLines(lines);
		return data;
	}
}
