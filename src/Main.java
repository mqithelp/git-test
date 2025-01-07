import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int k = 1_000_000_000;

        {
            long sum = 0;
            long start = System.currentTimeMillis();
            for (int i = 0; i < k + 1; i++) {
                sum += i;
            }
            long duration = System.currentTimeMillis() - start;
            System.out.println("Время выполнения цикла: " + duration + " мс");
            System.out.println("Sum=" + sum);
        }

        {
            long start = System.currentTimeMillis();
            long sum = LongStream.rangeClosed(1, k) // Используем LongStream для работы с long
                    .parallel() // Делаем поток параллельным
                    .reduce(0L, Long::sum); // Суммируем значения
            long duration = System.currentTimeMillis() - start;
            System.out.println("Sum=" + sum);
            System.out.println("Время выполнения параллельного потока: " + duration + " мс");
        }

        {
            long start = System.currentTimeMillis();
            long sum = Stream.iterate(1, a -> a + 1).limit(k).reduce(0L, Long::sum, Long::sum);
            long duration = System.currentTimeMillis() - start;
            System.out.println("Sum=" + sum);
            System.out.println("Время выполнения потока: " + duration + " мс");
        }
        System.out.println("Task 1 push");
        System.out.println("Task 2 push to branch 2 merged ");
        System.out.println("Tsk 3 branch 3");
        System.out.println("Tsk 3.1 branch 3");
        System.out.println("Tsk 3.1 branch 3 pull request");
        System.out.println("Task 3.2 work with task 3.2");
    }
}