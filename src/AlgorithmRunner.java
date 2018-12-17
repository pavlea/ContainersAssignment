import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class AlgorithmRunner {

    private static final FooLike origin = new FooLike() {
        @Override
        public double x() {
            return 0;
        }

        @Override
        public double y() {
            return 0;
        }
    };

    public static void main(String[] args) {
        final SecretFooSortingAlgorithm algorithm = new SecretFooSortingAlgorithm(origin);

        final Foo[] foos = new Foo[]{
                new Foo("5", new Baz(2, "x = 2"), new Bar(2, "y = 2")),
                new Foo("4", new Baz(1, "x = 1"), new Bar(2, "y = 2")),
                new Foo("3", new Baz(1, "x = 1"), new Bar(1, "y = 1")),
                new Foo("2", new Baz(0, "x = 0"), new Bar(1, "y = 1")),
                new Foo("1", new Baz(1, "x = 1"), new Bar(0, "y = 0")),
                new Foo("0", new Baz(0, "x = 0"), new Bar(0, "y = 0"))
        };

        System.out.println("LIST");
        demonstrateSortingLists(algorithm, foos);
        System.out.println("\nSET");
        demonstrateSortingSet(algorithm, foos);
        System.out.println();
    }

    private static void demonstrateSortingLists(GenericAlgorithm<FooLike> algorithm, Foo[] foos) {
        final ListContainer<FooLike> foosContainer; // I want a list container populated with foos
        foosContainer = new ListContainer<>(new ArrayList<>(foos.length));

        Arrays.asList(foos).forEach(foosContainer);
        final Container<FooLike> sortedFoos = algorithm.doSomething(foosContainer);

        // This won't compile
        for (FooLike foo : sortedFoos) {
            if (!(foo instanceof Foo)) continue;
            System.out.println(((Foo) foo).bar);
        }
    }

    private static void demonstrateSortingSet(GenericAlgorithm<FooLike> algorithm, Foo[] foos) {
        final SetContainer<FooLike> foosContainer; // I want a set container populated with foos
        foosContainer = new SetContainer<>(new HashSet<>(foos.length));

        Arrays.asList(foos).forEach(foosContainer);
        final Container<FooLike> sortedFoos = algorithm.doSomething(foosContainer);

        // This won't compile
        for (FooLike foo : sortedFoos) {
            if (!(foo instanceof Foo)) continue;
            System.out.println(((Foo) foo).baz);
        }
    }
}
