package prove02;

import java.awt.Color;
import java.util.Random;

/**
 *  Zombies moves from left to right. They are represented by blue squares.
 * <p>
 * @author  Gláucio Oliveira
 * @version 1.0
 * @since   2020-09-27
 * @see Creature
 */
public class Zombie extends Creature implements Movable, Aggressor {

    public Zombie() {
        _health = 1;
    }

    // No javadocs are necessary for these methods because they will inherit the
    // documentation from the superclass. We only need to add docs here if we are
    // doing something non-obvious in our overridden version.

    public Boolean isAlive() {
        return _health > 0;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 255);
    }

    /**
     * If the creature we've encountered is a plant, we'll eat it. Otherwise, we ignore it.
     * @param target The {@link Creature} we've encountered.
     */
    public void attack(Creature target) {

        // Zombies attack any creature if its not a Plant.
        if (target != null && !(target instanceof Plant)) {
            target.takeDamage(10);
        }
    }

    /**
     * Move the animal in a random direction.
     */
    public void move() {
          _location.x++;
        }
    }
