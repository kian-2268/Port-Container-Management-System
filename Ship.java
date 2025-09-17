package portContainer;

class Ship extends Port {
	
	public Ship (String name, String captain) {
		super(name, captain);
		
	}
	
	@Override
	public String toString() {
		return id + " | Captain " + detail;
	}

}
