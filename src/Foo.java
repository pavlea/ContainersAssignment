import java.util.Objects;

public final class Foo implements FooLike {
    public final String id;
    public final Baz baz;
    public final Bar bar;


    public Foo(String id, Baz baz, Bar bar) {
        this.id = id;
        this.baz = baz;
        this.bar = bar;
    }

    @Override
    public double x() {
        return this.baz.x;
    }

    @Override
    public double y() {
        return this.bar.y;
    }

    @Override
    public String toString() {
        return "Foo{" + "id='" + id + '\''
                + ", baz=" + baz
                + ", bar=" + bar
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
        Foo foo = (Foo) o;
        return Objects.equals(baz, foo.baz) &&
                Objects.equals(bar, foo.bar);
    }

    @Override
    public int hashCode() {

        return Objects.hash(baz, bar);
    }
}