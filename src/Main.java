public class Main {
    public static void main(String[] args)
    {
        Container vec = new Container();

        for(int i = 0; i < 10; i++)
            vec.pushBack(i);

        System.out.println(vec.length());
        vec.insert(99,5);

        for(int i = 0; i < vec.length(); i++)
            System.out.println(vec.at(i));

        System.out.println(vec.length());

        vec.deleteAt(5);

        for(int i = 0; i < vec.length(); i++)
            System.out.println(vec.at(i));
    }
}