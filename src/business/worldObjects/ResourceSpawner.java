package business.worldObjects;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import business.logicalObjects.CartesianCoordinate;
import business.logicalObjects.PolarCoordinate;

/**
 * Let the user spawn {@link Resource}s manually.
 * 
 * @author Steven Schwenke
 */
public class ResourceSpawner implements WorldObject {

	private CartesianCoordinate position;

	/** ressources generated by this spawner */
	private Set<Resource> ressources;

	/** the radius in which to spawn new {@link Resource}s */
	private double radius;

	public ResourceSpawner(CartesianCoordinate position, double radius) {
		super();
		this.position = position;
		this.radius = radius;
		ressources = new HashSet<Resource>();
	}

	/**
	 * Spawns a {@link Resource} in the vicinity of this
	 * {@link ResourceSpawner}.
	 */
	public void spawn() {

		Random random = new Random();

		double angle = random.nextDouble() * 360;
		double distance = random.nextDouble() * radius;

		CartesianCoordinate cc = new PolarCoordinate(angle, distance)
				.toCartesianCoordinates();

		Resource newRessource = new Resource(new CartesianCoordinate(
				position.getX() + cc.getX(), position.getY() + cc.getY()));
		ressources.add(newRessource);

		World.getInstance().addWorldObject(newRessource);
	}

	public CartesianCoordinate getPosition() {
		return position;
	}

	public void setPosition(CartesianCoordinate position) {
		this.position = position;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
