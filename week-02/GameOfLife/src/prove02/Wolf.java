package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner
{
    Random _random;
    Direction _preferredDirection;
    Color _color;

    public Wolf(){
        _health = 1;
        _random = new Random();

        _preferredDirection = getRandomDirection();
        _color = new Color(72, 72, 72);
    }

    private Direction getRandomDirection() {

        switch(_random.nextInt(4)) {
            case 0:
                return Direction.Right;
            case 1:
                return Direction.Left;
            case 2:
                return Direction.Up;
            case 3:
                return Direction.Down;
            default:
                return Direction.Down;
        }
    }

    @Override
    Shape getShape() {
        return Shape.Square;
    }

    @Override
    Color getColor() {
        return _color;
    }

    public void setColor(Color color)
    {
        _color = color;
    }

    @Override
    Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        if(_preferredDirection == Direction.Up)
        {
            if(above instanceof Animal)
                return;
            else if (right instanceof  Animal)
                _preferredDirection = Direction.Right;
            else if (below instanceof Animal)
                _preferredDirection = Direction.Down;
            else if (left instanceof Animal)
                _preferredDirection = Direction.Left;
        }
        else if (_preferredDirection == Direction.Right)
        {
            if(right instanceof Animal)
                return;
            else if (below instanceof Animal)
                _preferredDirection = Direction.Down;
            else if (left instanceof Animal)
                _preferredDirection = Direction.Left;
            else if (above instanceof  Animal)
                _preferredDirection = Direction.Up;

        }
        else if (_preferredDirection == Direction.Down)
        {
            if(below instanceof Animal)
                return;
            else if (left instanceof Animal)
                _preferredDirection = Direction.Left;
            else if (above instanceof Animal)
                _preferredDirection = Direction.Up;
            else if (right instanceof Animal)
                _preferredDirection = Direction.Right;
        }
        else if (_preferredDirection == Direction.Left)
        {
            if(left instanceof Animal)
                return;
            else if(above instanceof Animal)
                _preferredDirection = Direction.Up;
            else if (right instanceof  Animal)
                _preferredDirection = Direction.Right;
            else if (below instanceof Animal)
                _preferredDirection = Direction.Down;
        }
    }

    @Override
    public void move() {
        // Choose a random direction each time move() is called.
        switch(_preferredDirection) {
            case Right:
                _location.x++;
                break;
            case Left:
                _location.x--;
                break;
            case Down:
                _location.y++;
                break;
            case Up:
                _location.y--;
                break;
        }
    }

    @Override
    public void attack(Creature target) {
        if (target != null && (target instanceof Animal)){
            target.takeDamage(5);
        }
    }

    @Override
    public Creature spawnNewCreature() {
        Wolf newBabyWolf = new Wolf();

        Point newLocation = this.getLocation();
        newLocation.x = newLocation.x - 1;

        newBabyWolf.setLocation(newLocation);

        newBabyWolf.setColor(new Color(0xF3FF00));
        return newBabyWolf;
    }
}
