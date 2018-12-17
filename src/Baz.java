import java.util.Objects;

public class Baz {
    public final double x;
    public final String label;

    public Baz(double x, String label) {
        this.x = x;
        this.label = label;
    }

    @Override
    public String toString() {
        return "Baz{" + "x=" + x
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
        Baz baz = (Baz) o;
        return Double.compare(baz.x, x) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x);
    }
}