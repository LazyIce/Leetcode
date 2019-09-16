import java.util.*;

public class RandomMatchUsers {
    public static void main(String[] args) {
        List<String> persons = new ArrayList<>();
        persons.add("Jack");
        persons.add("Lisa");
        persons.add("Jerry");
        persons.add("Linda");
        persons.add("Tom");
        persons.add("Carol");

        List<String[]> pairs = getPairs(persons);
        for (String[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        List<Person> myPersons = new ArrayList<>();
        myPersons.add(new Person("Alan", "a"));
        myPersons.add(new Person("Dan", "a"));
        myPersons.add(new Person("Jenny", "b"));
        myPersons.add(new Person("Kevin", "b"));
        myPersons.add(new Person("Nancy", "b"));
        myPersons.add(new Person("Rachel", "c"));
        myPersons.add(new Person("Tom", "a"));
        myPersons.add(new Person("Lisa", "c"));

        List<String[]> personPairs = getPersonPairs(myPersons);
        for (String[] pair : personPairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static List<String[]> getPairs(List<String> persons) {
        List<String[]> res = new ArrayList<>();
        Collections.shuffle(persons);
        for (int i = 0; i < persons.size() / 2; i++) {
            res.add(new String[] {persons.get(i), persons.get(i + persons.size() / 2)});
        }

        return res;
    }

    public static List<String[]> getPersonPairs(List<Person> persons) {
        List<String[]> res = new ArrayList<>();
        Map<String, Queue<String>> map = new HashMap<>();
        for (Person person : persons) {
            Queue<String> names = map.getOrDefault(person.group, new LinkedList<>());
            names.offer(person.name);
            map.put(person.group, names);
        }

        PriorityQueue<Map.Entry<String, Queue<String>>> pq = new PriorityQueue<>((a, b) -> a.getValue().size() == b.getValue().size() ? a.getKey().compareTo(b.getKey()) : b.getValue().size() - a.getValue().size());
        for (Map.Entry<String, Queue<String>> entry : map.entrySet()) {
            pq.offer(entry);
        }

        while (pq.size() > 1) {
            Map.Entry<String, Queue<String>> entry1 = pq.poll();
            Map.Entry<String, Queue<String>> entry2 = pq.poll();
            String g1 = entry1.getKey();
            String g2 = entry2.getKey();
            Queue<String> group1 = entry1.getValue();
            Queue<String> group2 = entry2.getValue();
            String name1 = group1.poll();
            String name2 = group2.poll();

            res.add(new String[] {name1, name2});

            Map<String, Queue<String>> temp = new HashMap<>();
            if (!group1.isEmpty()) {
                temp.put(g1, group1);
            }
            if (!group2.isEmpty()) {
                temp.put(g2, group2);
            }

            for (Map.Entry<String, Queue<String>> entry : temp.entrySet()) {
                pq.offer(entry);
            }
        }

        return res;
    }
}

class Person {
    String name;
    String group;

    public Person(String name, String group) {
        this.name = name;
        this.group = group;
    }
}
