import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

    }
}
class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    public void addToy(Toy toy) {
        toys.add(toy);
    }
    public void updateWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }
    public Toy getPrizeToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        Random random = new Random();
        double randomWeight = random.nextDouble() * totalWeight;
        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randomWeight) {
                toy.setQuantity(toy.getQuantity() - 1);
                toys.remove(toy);
                return toy;
            }
        }
        return null;
    }
}