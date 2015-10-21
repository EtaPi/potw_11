/**
 * 
 */

/**
 * @author Tim
 *
 */
public class Tetris {

	public static int GRIDHEIGHT = 20;
	public static int GRIDWIDTH = 10;
	public static String FULLLINE= "1111111111";
	public static int xLocation = 0;
	public static int yLocation = 0;
	public static int rotation = 0;
	public static int totalFullLines = 0;

	// Scoring algorithm
	// -50 = Invalid layout
	// -1 = Lose Game
	// 1 point per line * line number (descending)
	// +500 complete line
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Define game board grid
		int[] grid = new int[GRIDHEIGHT];
		String shapeType = "";
		
		initializeGrid(grid);
		
		// L Shape
		int[] lGrid0 = {10,10,11};
		Shape lShape0 = new Shape(lGrid0, 1, 0, 0, 2, 0, "L");
		int[] lGrid1 = {111,100};
		Shape lShape1 = new Shape(lGrid1, 0, 2, 0, 1, 1, "L");
		int[] lGrid2 = {11,1,1};
		Shape lShape2 = new Shape(lGrid2, 0, 1, 2, 0, 2, "L");
		int[] lGrid3 = {1,111};
		Shape lShape3 = new Shape(lGrid3, 2, 0, 1, 0, 3, "L");
		Shape[] lShapeGroup = {lShape0, lShape1, lShape2, lShape3};
		// J Shape
		int[] jGrid0 = {11,10,10};
		Shape jShape0 = new Shape(jGrid0, 1, 0, 2, 0, 0, "J");
		int[] jGrid1 = {111,1};
		Shape jShape1 = new Shape(jGrid1, 2, 0, 1, 0, 1, "J");
		int[] jGrid2 = {1,1,11};
		Shape jShape2 = new Shape(jGrid2, 0, 1, 0, 2, 2, "J");
		int[] jGrid3 = {100,111};
		Shape jShape3 = new Shape(jGrid3, 0, 2, 1, 0, 3, "J");
		Shape[] jShapeGroup = {jShape0, jShape1, jShape2, jShape3};
		// O Shape
		int[] oGrid = {11,11};
		Shape oShape = new Shape(oGrid, 0, 1, 1, 0, 0, "O");
		Shape[] oShapeGroup = {oShape};
		// S Shape
		int[] sGrid0 = {10,11,1};
		Shape sShape0 = new Shape(sGrid0, 0, 1, 2, 0, 0, "S");
		int[] sGrid1 = {11,110};
		Shape sShape1 = new Shape(sGrid1, 2, 0, 1, 0, 1, "S");
		Shape[] sShapeGroup = {sShape0, sShape1};
		// Z Shape
		int[] zGrid0 = {1,11,10};
		Shape zShape0 = new Shape(zGrid0, 1, 0, 2, 0, 0, "Z");
		int[] zGrid1 = {110,11};
		Shape zShape1 = new Shape(zGrid1, 2, 0, 0, 1, 1, "Z");
		Shape[] zShapeGroup = {zShape0, zShape1};
		// I Shape
		int[] iGrid0 = {1111};
		Shape iShape0 = new Shape(iGrid0, 0, 3, 0, 0, 0, "I");
		int[] iGrid1 = {1,1,1,1};
		Shape iShape1 = new Shape(iGrid1, 0, 0, 3, 0, 1, "I");
		Shape[] iShapeGroup = {iShape0, iShape1};
		// T Shape
		int[] tGrid0 = {10,11,10};
		Shape tShape0 = new Shape(tGrid0, 0, 1, 2, 0, 0, "T");
		int[] tGrid1 = {111,10};
		Shape tShape1 = new Shape(tGrid1, 2, 0, 1, 0, 1, "T");
		int[] tGrid2 = {1,11,1};
		Shape tShape2 = new Shape(tGrid2, 1, 0, 0, 2, 2, "T");
		int[] tGrid3 = {10,111};
		Shape tShape3 = new Shape(tGrid3, 0, 2, 0, 1, 3, "T");
		Shape[] tShapeGroup = {tShape0, tShape1, tShape2, tShape3};

		String tempString = "";
		if(args != null)
			tempString = args[0];
		for(int counter = 0; counter < tempString.length(); counter++)
		{
			shapeType = tempString.substring(counter,counter+1);
			Shape[] nextShapes;
			if(shapeType.equalsIgnoreCase("L"))
				nextShapes = lShapeGroup;
			else if(shapeType.equalsIgnoreCase("J"))
				nextShapes = jShapeGroup;
			else if(shapeType.equalsIgnoreCase("O"))
				nextShapes = oShapeGroup;
			else if(shapeType.equalsIgnoreCase("S"))
				nextShapes = sShapeGroup;
			else if(shapeType.equalsIgnoreCase("Z"))
				nextShapes = zShapeGroup;
			else if(shapeType.equalsIgnoreCase("I"))
				nextShapes = iShapeGroup;
			else if(shapeType.equalsIgnoreCase("T"))
				nextShapes = tShapeGroup;
			// Default to "L" shape type if an invalid one was provided.
			else
				nextShapes = lShapeGroup;
			grid = addShape(nextShapes, grid);
			if (grid != null)
			{
				System.out.println(xLocation + " " + yLocation + " " + rotation);
				//System.out.println("Shape of type " + nextShapes[0].getType() + " added at location x = " + xLocation + ", y = " + yLocation + ", rotation = " + rotation);
				//printGrid(grid);
			}
			else 
			{
				//System.out.println("Game over!  Unable to add the piece.");
				counter = tempString.length();
			}
			
		}
		System.out.println("" + totalFullLines);
		//printGrid(grid);
	}
	
	/**
	 * Initialize the grid to all 0 values
	 */
	public static void initializeGrid(int[] grid)
	{
		int yCounter = 0;
		
		for(yCounter = 0;yCounter < GRIDHEIGHT; yCounter++)
		{
			grid[yCounter] = 0;
		}
	}

	/**
	 * Print the grid to see the values
	 */
	public static void printGrid(int[] grid)
	{
		int xCounter = 0;
		int yCounter = 0;
		String displayLine;
		
		for(yCounter = GRIDHEIGHT-1;yCounter >= 0 ; yCounter--)
		{
			displayLine = "" + grid[yCounter];
			for(xCounter = displayLine.length();xCounter < GRIDWIDTH; xCounter++)
			{
				displayLine = "0" + displayLine;
			}
			System.out.println("Line " + yCounter + " = " + displayLine);
		}
	}
	
	/*
	 * Loop through all of the locations on the grid to determine where to put the new shape
	 */
	public static int[] addShape(Shape[] shapeArray, int[] grid)
	{
		int[] tempGrid = copyGrid(grid);
		int[] bestGrid = new int[GRIDHEIGHT];
		int score = 0;
		int bestScore = 0;
		Shape shape;

		// Loop through all positions of the shape that was provided.
		for(int shapePositions = 0; shapePositions < shapeArray.length; shapePositions++)
		{
			shape = shapeArray[shapePositions];
			// Loop from left to right.
			for(int counter=0; counter <= GRIDWIDTH; counter++)
			{
				// Loop from bottom to top.
				for(int heightcounter=0; heightcounter < GRIDHEIGHT; heightcounter++)
				{
					tempGrid = copyGrid(grid);
					if((counter - shape.getLeft() < 0) || (counter+shape.getRight() >= GRIDWIDTH) || (heightcounter - shape.getLower() < 0) || (heightcounter + shape.getUpper() >= GRIDHEIGHT))
					{
						//System.out.println("Invalid Location.");
					}
					else
					{
						Shape newShape = adjustShape(shape, counter);
						int adjustment = shape.getLower();
						for(int shapeHeight = 0; shapeHeight < newShape.getShapeGrid().length; shapeHeight++)
						{
							tempGrid[heightcounter-adjustment] = tempGrid[heightcounter - adjustment] + newShape.getShapeGrid()[newShape.getShapeGrid().length - shapeHeight-1];
							adjustment--;
						}
					
						score = scoreGrid(tempGrid);
						// Determine if this is the best outcome.  If so, store it.
						if (score > bestScore)
						{
							bestScore = score;
							bestGrid = copyGrid(tempGrid);
							xLocation = counter;
							yLocation = heightcounter;
							rotation = shape.getRotation();
						}
					}
				}
			}
		}
		// In the end, return the best grid that you were able to find.  If they were all bad then return a null.
		bestGrid = cleanupGrid(bestGrid);
		if(bestScore <= 0)
			bestGrid = null;
		return bestGrid;
	}
	
	public static int[] copyGrid(int[] grid)
	{
		int[] newGrid = new int[GRIDHEIGHT];
		
		for(int counter = 0; counter < GRIDHEIGHT; counter++)
		{
			newGrid[counter] = grid[counter];
		}
		return newGrid;
	}
	
	/*
	 * Convert the shape to the appropriate number of digits to add to the grid.
	 */
	public static Shape adjustShape(Shape shape, int position)
	{
		int[] newGrid = new int[shape.getShapeGrid().length];
		// Make a copy of the original shape.
		Shape newShape = new Shape(shape.getShapeGrid(), shape.getLeft(), shape.getRight(), shape.getLower(), shape.getUpper(), shape.getRotation(), shape.getType());
		
		for(int lengthCounter = 0; lengthCounter < shape.getShapeGrid().length; lengthCounter++)
		{
			String newValue = "" + shape.getShapeGrid()[lengthCounter];
			
			for (int width=position+1; (shape.getRight() + width) < GRIDWIDTH; width++)
			{
				newValue = newValue + "0";
			}
			newGrid[lengthCounter] = Integer.parseInt(newValue);
			newShape.setShapeGrid(newGrid);
		}	
		
		return newShape;
	}
	
	/*
	 * Method to score the value of the grid.  The lower the blocks go, the better the score.
	 */
	public static int scoreGrid(int[] grid)
	{
		int score = 0;
		String gridLine = "";
		
		for(int heightcounter=0; heightcounter < GRIDHEIGHT; heightcounter++)
		{
			gridLine = "" + grid[heightcounter];
			// Invalid line.  Simply stop processing any more lines at this point.
			if(gridLine.contains("2"))
			{
				score = -50;
				heightcounter = GRIDHEIGHT;
			}
			// Full line.  Add a bonus of 500 points.
			else 
			{
				// Full line.  Add full line bonus points.
				if(gridLine.equals(FULLLINE))
					score = score + 500;
				
				// Loop through adding points per the line that items are added.
				for(int counter = 0; counter < gridLine.length(); counter++)
				{
					if(gridLine.charAt(counter) == '1')
						score = score + (GRIDHEIGHT - heightcounter);
				}
			}
		}
		
		return score;
	}

	/*
	 * Method to remove complete lines from the grid.
	 */
	public static int[] cleanupGrid(int[] grid)
	{
		int[] newGrid = new int[GRIDHEIGHT];
		int fullLines = 0;
		String gridLine = "";
		
		for(int heightcounter=0; heightcounter < GRIDHEIGHT; heightcounter++)
		{
			gridLine = "" + grid[heightcounter];
			if(!gridLine.contentEquals(FULLLINE))
			{
				newGrid[heightcounter - fullLines] = grid[heightcounter];
			}
			else
			{
				newGrid[GRIDHEIGHT-1-fullLines] = 0;
				fullLines++;
				totalFullLines++;
			}	
		}
		return newGrid;
	}

	
	
}
