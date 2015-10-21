
public class Shape {
	protected int[] shapeGrid;
	protected int leftRange;
	protected int rightRange;
	protected int lowerRange;
	protected int upperRange;
	protected int rotation;
	protected String type;
	
	public Shape(int[] grid, int left, int right, int lower, int upper, int rot, String shapeType)
	{
		this.shapeGrid = grid;
		this.leftRange = left;
		this.rightRange = right;
		this.lowerRange = lower;
		this.upperRange = upper;
		this.rotation = rot;
		this.type = shapeType;
	}
	
	public void setShapeGrid(int[] newgrid)
	{
		this.shapeGrid = newgrid;
	}

	public int[] getShapeGrid()
	{
		return this.shapeGrid;
	}
	
	public int getLeft()
	{
		return this.leftRange;
	}
	
	public int getRight()
	{
		return this.rightRange;
	}

	public int getLower()
	{
		return this.lowerRange;
	}

	public int getUpper()
	{
		return this.upperRange;
	}

	public int getRotation()
	{
		return this.rotation;
	}
	
	public String getType()
	{
		return this.type;
	}

}
