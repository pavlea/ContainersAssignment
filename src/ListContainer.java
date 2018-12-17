import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class ListContainer<C> implements Container<C> {

    private final ArrayList<C> list;

    public ListContainer(ArrayList<C> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Collection<C> data() {
        return list;
    }

    @Override
    public Iterator<C> iterator() {
        return list.iterator();
    }

    @Override
    public void accept(C c) {
        list.add(c);
    }

    @Override
    public void forEach(Consumer<? super C> action) {
        for (int i = 0; i < list.size(); i++) {
            action.accept(list.get(i));
        }
    }
}