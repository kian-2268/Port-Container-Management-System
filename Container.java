package portContainer;

class Container extends Port{
	
	private int weight;
	
	public Container(String id, String description, int weight) {
		
		super(id, description);
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return id + " | " + detail + " | " + weight + " kg";
	}
}
