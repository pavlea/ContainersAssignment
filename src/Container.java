import java.util.Collection;
import java.util.function.Consumer;

public interface Container<C> extends Iterable<C>, Consumer<C> {
    int size();

    Collection<C> data();
}