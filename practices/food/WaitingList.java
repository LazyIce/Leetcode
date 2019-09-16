import java.util.LinkedList;

public class WaitingList {
    public static void main(String[] args) {
        Waitlist wl = new Waitlist(4);
        wl.addParty(new Party("party1", 2, 30));
        wl.addParty(new Party("party2", 3, 40));
        wl.addParty(new Party("party3", 4, 10));
        wl.addParty(new Party("party4", 5, 60));

        System.out.println(wl.moveParty());
        System.out.println(wl.moveParty());
        System.out.println(wl.moveParty());
        System.out.println(wl.moveParty());
    }
}

class Waitlist {
    int capacity;
    LinkedList<Party> waitList;

    public Waitlist(int n) {
        capacity = n;
        waitList = new LinkedList<>();
    }

    public void addParty(Party party) {
        if (waitList.isEmpty() || party.time <= waitList.peekLast().time) {
            waitList.offer(party);
        } else {
            for (int i = 0; i < waitList.size(); i++) {
                if (party.time > waitList.get(i).time) {
                    waitList.add(i, party);
                    break;
                }
            }
        }
    }

    public String moveParty() {
        for (int i = 0; i < waitList.size(); i++) {
            if (waitList.get(i).size <= capacity) {
                String name = waitList.get(i).name;
                waitList.remove(i);
                return name;
            }
        }

        return "Error";
    }
}

class Party {
    String name;
    int size;
    int time;

    public Party(String name, int size, int time) {
        this.name = name;
        this.size = size;
        this.time = time;
    }
}
