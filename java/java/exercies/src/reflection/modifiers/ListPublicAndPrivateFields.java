package reflection.modifiers;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class ListPublicAndPrivateFields {
    public static void main(String[] args) {
        String[] privateFields = FieldGetter.getPrivateFields(new Test());
        System.out.println(Arrays.toString(privateFields));

        String[] publicFields = FieldGetter.getPublicFields(new Test());
        System.out.println(Arrays.toString(publicFields));
    }
}

class FieldGetter {

    // SOLUTION WITH STREAMS

    static public String[] getPrivateFields(Object object) {

        List<String> list = Stream.of(object.getClass().getDeclaredFields())
            .filter(field -> Modifier.isPrivate(field.getModifiers()))
            .map(field -> field.getName())
            .collect(Collectors.toList());

        Collections.sort(list);
        return list.toArray(new String[0]);
    }


    // SOLUTION WITH ARRAYLIST AND FOR LOOP

    static public String[] getPublicFields(Object object) {

        List<String> list = new ArrayList<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            if (Modifier.isPublic(field.getModifiers())) {
                list.add(field.getName());
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}

/*
List the object's private and public methods that are not inherited in alphabetical order

Solution has both streams and ArrayList with for loop
 */

class Base {
    public int publicBaseAttr = 1;
    private int privateBaseAttr = 1;

    public int publicBaseMethod() { return 1; }
    private int privateBaseMethod() { return 1; }
}

class Test {
    public int publicAttr;
    public int publicFoo;
    public int publicBar;

    private int privateAttr;
    private int privateFoo;
    private int privateBar;

    public int publicMethod() { return 1; }
    private int privateMethod() { return 1; }
}



