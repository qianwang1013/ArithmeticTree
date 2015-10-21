abstract class Component{
	private Component[] children = null; 
	private String sign;
	abstract protected double calculate() throws Exception;
	abstract protected double getValue() throws Exception;
	protected Component(Component... c){
		children = new Component[c.length];
		add(c);
	}
	public final void add(Component... c){
		//I am planning building a tree that only 
		//knows its children;
		for(int i = 0; i != c.length; ++i){
			children[i] = c[i];
		}
	}

	public final void replace(Component c, Component r) throws Exception{
		for(int i = 0; i != children.length; ++i){
			if(children[i] == c){
				children[i] = r;
				break;
			}
			if(i == children.length - 1){
				throw new Exception("not found");
			}
		}
	}
	protected Component[] getChildren(){
		return children;
	}

	protected void setSign(String sign){
		this.sign = sign;
	}

	protected String getSign(){
		return sign;
	}

	public String toString(){
		String str = this.sign + "\n";
		for(int i = 0 ; i != children.length; ++i){
			str += children[i].toString();
			if(i == children.length - 1){

			}
			else{
				str += "\n";
			}
		}		
		return str;
	}
}