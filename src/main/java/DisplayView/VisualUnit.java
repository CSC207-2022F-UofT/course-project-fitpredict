package DisplayView;
import DisplayZoom.DataPoint;
import DisplayZoom.DataPointMap;
import java.util.Date;

public abstract class VisualUnit {
    public abstract void generate(DataPointMap data);
    public abstract void generate(DataPointMap data, Date date);
    public abstract void generateSample(DataPointMap sampleData);
    public abstract void zoomIn(DataPoint dataPoint);
}