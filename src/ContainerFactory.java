import java.util.*;

public enum ContainerFactory {
    INSTANCE;

    public <T> Container<T> create(Collection<T> data) {
        if (data instanceof List) {
            return new ListContainer<>((ArrayList<T>) data);
        }
        if (data instanceof Set) {
            return new SetContainer<>((HashSet<T>) data);
        }
        return null;
    }
}
