package stackqueue;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * <p>
 * Create the data structures to maintain this system and implement operations such as
 * enqueue, dequeueAny, dequeueDog, and dequeueCat.
 * <p>
 * You may use the built-in Linked list data structure.
 */
class _03_06_AnimalShelter {

    LinkedList<Animal> dogQueue;
    LinkedList<Animal> catQueue;
    int order;

    public _03_06_AnimalShelter() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }


    void enqueue(AnimalType animalType, int val) {
        Animal newAnimal = new Animal(animalType, val, ++order);

        if(newAnimal.animalType == AnimalType.Cat) {
            catQueue.add(newAnimal);
        } else if(newAnimal.animalType == AnimalType.Dog) {
            dogQueue.add(newAnimal);
        }
    }

    int dequeueAny() {
        int adoptedAnimal = -1;

        int newestDogOrder = Integer.MAX_VALUE;
        int newestCatOrder = Integer.MAX_VALUE;

        if(!dogQueue.isEmpty()) {
            newestDogOrder = dogQueue.peek().order;
        }
        if(!catQueue.isEmpty()) {
            newestCatOrder = catQueue.peek().order;
        }

        if(newestDogOrder < newestCatOrder) {
            adoptedAnimal = dequeueDog();
        } else if(newestDogOrder >= newestCatOrder) {
            // Could use a else here, but maybe in the future we want to support more different animal queues
            adoptedAnimal = dequeueCat();
        }
        return adoptedAnimal;
    }

    int dequeueDog() {
        return dogQueue.removeFirst().val;
    }

    int dequeueCat() {
        return catQueue.removeFirst().val;
    }

    class Animal {
        AnimalType animalType;
        int val;
        int order;


        Animal(AnimalType animalType, int val, int order) {
            this.animalType = animalType;
            this.val = val;
            this.order = order;
        }
    }

    public enum AnimalType {
        Dog,
        Cat
    }
}

