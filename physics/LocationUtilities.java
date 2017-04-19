package physics;

public class LocationUtilities {
	public static int[] getXPositions(Location[] array) {
		int[] xArray = new int[array.length];
		for (int i = 0 ; i < array.length ; i++) {
			xArray[i] = (int)array[i].getX();
		}
		
		return xArray;
	}
	
	public static int[] getYPositions(Location[] array) {
		int[] yArray = new int[array.length];
		for (int i = 0 ; i < array.length ; i++) {
			yArray[i] = (int)array[i].getY();
		}
		
		return yArray;
	}
	
	public static Location[] copyArray(Location[] array) {
		Location[] newArray = new Location[array.length];
		for (int i = 0 ; i < array.length ; i++) {
			newArray[i] = new Location(array[i]);
		}
		
		return newArray;
	}
}
