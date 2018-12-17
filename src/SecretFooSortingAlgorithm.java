import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SecretFooSortingAlgorithm implements GenericAlgorithm<FooLike> {

    private final FooLike origin;

    public SecretFooSortingAlgorithm(FooLike origin) {
        this.origin = origin;
    }

    @Override
    public Container<FooLike> doSomething(Container<FooLike> argument) {
        final List<FooLike> unsafeList = new ArrayList<>();
        argument.forEach(unsafeList::add);
        // yes, this is intentional
        argument.forEach(unsafeList::add);

        unsafeList.sort(Comparator.comparing(euclideanDistance(origin)));

        // How do I create a container just like the one I received?
        // I want the resulting one to have the same behaviour as the one I received as argument
        final Container<FooLike> resultingContainer = ContainerFactory.INSTANCE.create(argument.data());
        unsafeList.forEach(resultingContainer);

        return resultingContainer;
    }

    private Function<FooLike, Double> euclideanDistance(FooLike origin) {
        return point -> Math.sqrt(
                Math.pow(point.x() - origin.x(), 2) +
                        Math.pow(point.y() - origin.y(), 2)
        );
    }
}