class MultipleComponent extends Component{

	public MultipleComponent(Component... c){
		super(c);
	}

	public double calculate() throws Exception{
		Component[] children = super.getChildren();
		double sum = children[0].getValue();
		for(int i = 1; i != children.length; ++i){
			sum *= children[i].getValue();
		}
		return sum;

	}

	public double getValue() throws Exception{
		throw new Exception("Nope");
	}
	
	public String toString(){
		return "*";
	}
}