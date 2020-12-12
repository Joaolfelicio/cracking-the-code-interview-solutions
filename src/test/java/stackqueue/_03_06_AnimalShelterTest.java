package stackqueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _03_06_AnimalShelterTest {

    private _03_06_AnimalShelter s = new _03_06_AnimalShelter();

    @Test
    public void withOrdinaryQueue() {
        s.enqueue(_03_06_AnimalShelter.AnimalType.Dog, 5);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Cat,4);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Dog,6);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Cat,7);

        assertEquals(5, s.dequeueAny());
        assertEquals(4, s.dequeueAny());
        assertEquals(6, s.dequeueAny());
        assertEquals(7, s.dequeueAny());
    }

    @Test
    public void withCatDogOldest() {
        s.enqueue(_03_06_AnimalShelter.AnimalType.Cat, 5);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Cat, 3);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Dog, 6);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Dog, 2);
        s.enqueue(_03_06_AnimalShelter.AnimalType.Cat, 1);

        assertEquals(6, s.dequeueDog());
        assertEquals(5, s.dequeueAny());
        assertEquals(3, s.dequeueAny());
        assertEquals(1, s.dequeueCat());
        assertEquals(2, s.dequeueDog());
    }
}