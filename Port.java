package portContainer;

abstract class Port {
	
	protected String id;
	protected String detail;
	
	public Port(String id, String detail) {
		
		this.id = id;
		this.detail = detail;
		
	}
	
	@Override
	public abstract String toString();

}
