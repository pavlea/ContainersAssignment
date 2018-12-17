import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SetContainer<C> implements Container<C> {

    private final HashSet<C> set;

    public SetContainer(HashSet<C> set) {
        this.set = set;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Collection<C> data() {
        return set;
    }

    @Override
    public Iterator<C> iterator() {
        return set.iterator();
    }

    @Override
    public void accept(C c) {
        set.add(c);
    }
}