class AddComponent extends Component{

	public AddComponent(Component... c){
		super(c);
	}

	public double calculate() throws Exception{
		Component[] children = super.getChildren();
		double sum = 0;
		for(int i = 0; i != children.length; ++i){
			sum += children[i].getValue();
		}
		return sum;
	}

	public double getValue() throws Exception{
		throw new Exception("Add");
	}

	public String toString(){
		return "+";
	}
}