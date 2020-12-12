package stackqueue;

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
    Animal oldestAnimal = null;
    Animal newestAnimal = null;

    public _03_06_AnimalShelter() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }


    void enqueue(AnimalType animalType, int val) {
        Animal newAnimal = new Animal(animalType, val, newestAnimal, null);

        if(oldestAnimal == null) {
            oldestAnimal = newAnimal;
        }

        // Update the next pointer on the newest animal
        if(newestAnimal != null) {
            newestAnimal.next = newAnimal;
        }

        // The new animal is now the newest one
        newestAnimal = newAnimal;

        if(animalType == AnimalType.Cat) {
            catQueue.add(newAnimal);
        }
        else if(animalType == AnimalType.Dog) {
            dogQueue.add(newAnimal);
        }
    }

    int dequeueAny() {
        int adoptedAnimal;
        
        if(oldestAnimal.animalType == AnimalType.Cat) {
            adoptedAnimal = dequeueCat();
        } else {
            adoptedAnimal = dequeueDog();
        }
        return adoptedAnimal;
    }

    int dequeueDog() {
        return deQueueAnimal(dogQueue);
    }

    int dequeueCat() {
        return deQueueAnimal(catQueue);
    }

    private int deQueueAnimal(LinkedList<Animal> animalQueue) {
        if(animalQueue.isEmpty()) throw new RuntimeException("The Stack is Empty");

        Animal adoptedAnimal = animalQueue.removeFirst();

        if(oldestAnimal == adoptedAnimal) {
            // If the oldest animal is the one adopted, the oldest is the next one
            oldestAnimal = oldestAnimal.next;
        } else {
            // If the animal adopted is not the oldest, we need to update the pointers between the next and previous animal
            Animal prevAnimal = adoptedAnimal.prev;
            Animal nextAnimal = adoptedAnimal.next;

            prevAnimal.next = nextAnimal;

            if(nextAnimal != null) {
                nextAnimal.prev = prevAnimal;
            }
        }

        return adoptedAnimal.val;
    }

    class Animal {
        AnimalType animalType;
        int val;
        Animal prev;
        Animal next;


        Animal(AnimalType animalType, int val, Animal prev, Animal next) {
            this.animalType = animalType;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        Animal(AnimalType animalType, int val) {
            this.animalType = animalType;
            this.val = val;
        }
    }

    public enum AnimalType {
        Dog,
        Cat
    }
}

