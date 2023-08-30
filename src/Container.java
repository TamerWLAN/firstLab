/**
 * класс контейнер, позволяющий хранить произвольное количество целых чисел
 * @author Artem Kozlitin
 * @version 1.0
 * @since 1.0
 */
public class Container
{
    /** Массив, отвечающий за хранение элемнтов контейнера*/
    private int[] elements;
    /** Поле, хранящее текущий размер массива elements*/
    private int size;
    /** Поле, храниящее количество ячеек, занятых числами*/
    private int amount;

    /**
     * Конструктор класса инициализирующий базовый размер хранилища
     * количество занятых ячеек и само хранилище
     * без параметров
     */
    public Container() {
        size = 10;
        amount = 0;
        elements = new int[size];
    }

    /**
     * Метод, проверяющий, входит ли индекс в границы хранилище
     * @param index индекс для проверки
     * @throws RuntimeException если индекс за границами хранилища
     */
    private void check(int index) {
        if(index < 0 || index > amount) {
            throw new RuntimeException("Out of range");
        }
    }

    /**
     * Метод пересоздающий хранилище с уеличенным размером,
     * с сохранением элементов и их индексов
     * без параметров
     */
    private void reInit() {
        size *= 2 ;

        int[] oldElements = elements;
        elements = new int[size];

        if (amount >= 0) {
            System.arraycopy(oldElements, 0, elements, 0, amount);
        }
    }

    /**
     * Метод, добавляющий элемент в конец списка
     * @param value значение для добавления в хранилище
     */
    public void pushBack(int value) {
        if(amount >= size * 0.8) {
            reInit();
        }

        elements[amount] = value;
        amount++;
    }

    /**
     * Метод, добавляющий элемент на конкретную позицию в хранилище
     * @param elem значение для добавления в хранилище
     * @param place место для вставки
     */
    public void insert(int elem, int place)
    {
        check(place);

        if(amount >= size * 0.8) {
            reInit();
        }

        for(int i = amount; i > place; i--) {
            elements[i] = elements[i - 1];
        }

        elements[place] = elem;
        amount++;
    }

    /**
     * Метод, возвращающий элемент, по заданному индексу
     * @param place позиция элемента в хранилище
     * @return значение элемента, стоящего на заданной позиции
     */
    public int at(int place) {
        check(place);

        return elements[place];
    }

    /**
     * Метод, возвращающий последний элемент хранилища и удаляющий его
     * @return значение элемента, стоящего на заданной позиции
     */
    public int pop() {

        amount--;
        return elements[amount];
    }

    /**
     * Метод удаляющий элемент по заданному индексу
     * @param place позиция элемента в хранилище
     */
    public void deleteAt(int place) {
        check(place);

        for(int i = place; i < amount-1; i++) {
            elements[i] = elements[i + 1];
        }

        amount--;
    }
    /**
     * Метод проверяющий есть ли заданное значение в хранилище
     * @param elem целочисленное значение для поиска
     * @return результат поиска значения в хранилище
     */
    public boolean in(int elem) {
        for(int i = 0; i < amount; i++) {
            if (elements[i] == elem) {
                return true;
            }
        }

        return false;
    }

    /**
     * Метод возвращающий количество занятых ячеек хранилища
     * @return количество занятых ячеек хранилища
     */
    public int length() {
        return amount;
    }
}
