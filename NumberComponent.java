class NumberComponent extends Component{
	private double value;

	public NumberComponent(double value){
		this.value = value;
	}

	public double calculate() throws Exception{
		throw new Exception("Cannot do that");
	};

	public double getValue(){
		return value;
	}
	public String toString(){
		return ""+value;
	}
}