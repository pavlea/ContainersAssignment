import java.util.Objects;

public class Bar {
    public final double y;
    public final String label;

    public Bar(double y, String label) {
        this.y = y;
        this.label = label;
    }

    @Override
    public String toString() {
        return "Bar{" + "y=" + y
                + ", label='" + label + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bar bar = (Bar) o;
        return Double.compare(bar.y, y) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(y);
    }
}