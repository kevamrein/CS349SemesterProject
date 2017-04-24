package physics;

/**
 * Utility methods for interacting with Location arrays.
 * 
 * @author Kevin Amrein and Affan Sheikh
 *
 */
public class LocationUtilities {
	/**
	 * Gets the x positions from the Location objects in the passed array
	 * 
	 * @param array
	 *            Location array
	 * 
	 * @return int array of x coordinates
	 */
	public static int[] getXPositions(Location[] array) {
		int[] xArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			xArray[i] = (int) array[i].getX();
		}
		return xArray;
	}

	/**
	 * Gets the y positions from the Location objects in the passed array
	 * 
	 * @param array
	 *            Location array
	 * 
	 * @return int array of y coordinates
	 */
	public static int[] getYPositions(Location[] array) {
		int[] yArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			yArray[i] = (int) array[i].getY();
		}
		return yArray;
	}

	/**
	 * Makes a deep copy of the passed Location Array.
	 * 
	 * @param array
	 *            Location array to copy
	 * @return Location array
	 */
	public static Location[] copyArray(Location[] array) {
		Location[] newArray = new Location[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = new Location(array[i]);
		}
		return newArray;
	}
}
