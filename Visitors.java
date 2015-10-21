import java.util.Stack;

interface Visitor{
	void visit(Component c) throws Exception;
	void clear();
}

class InfixVisitor implements Visitor{
	//inOrder
	String str = "";
	public InfixVisitor(){}

	@Override
	public void visit(Component c) throws Exception{
		System.out.println("InfixVisitor");
		System.out.println(doVisit(c));
	}

	@Override
	public void clear(){
		str = "";
	}

	public String doVisit(Component c) throws Exception{
		if(c.getChildren().length == 0){
			str += c;
		}
		else{
			Component[] child = c.getChildren();
			String tmp = "";
            // 4 * (2 /(1+6)) *5
   			str += "(";
			for(int i = 0; i != child.length; ++i){
				doVisit(child[i]);
				if(i != child.length - 1){
					str += c;
				}
			}
			str += ")";

		}
		return str;
	}

}

class LispVisitor implements Visitor{
	String str = "";
	public LispVisitor(){}

	@Override
	public void visit(Component c) throws Exception{
		System.out.println("LispVisitor");
		System.out.println(doVisit(c));
	}

	@Override
	public void clear(){
		str = "";
	}
    // (*4 (/2(+16))5)
	public String doVisit(Component c) throws Exception{
		//level order
		if(c.getChildren().length != 0){
			str += "(";
		}
		str += c;
		Component[] children = c.getChildren();
		for(int i = 0; i != children.length; ++i){
			doVisit(children[i]);
		}
		if(c.getChildren().length != 0){
			str += ")";
		}
		return str;
	}


}

class EvaVisitor implements Visitor{
	String str = "";
	Stack<Component> stack = new Stack<Component>();
	public EvaVisitor(){}
	@Override
	public void visit(Component c) throws Exception{
		System.out.println("EvaVisitor");
		System.out.println(doVisit(c));


	}

	@Override
	public void clear(){
		str = "";
		while(!stack.empty()){
			stack.pop();
		}
	}

    // (*4 (/2(+16))5)
	public String doVisit(Component c) throws Exception{
		double result;
		Component[] children = c.getChildren();
		for(int i = 0; i != children.length; ++i){
			if(children[i].getChildren().length != 0){
				doVisit(children[i]);
			}
			if(!stack.empty()){
				c.replace(children[i], stack.peek());
				stack.pop();
			}
		}
		NumberComponent tmp = new NumberComponent(c.calculate());
		result = c.calculate();
		stack.push(tmp);
		return "" + result;
	}		

	
}

class TreeVisitor implements Visitor{
	String str = "";
	Component body;
	public TreeVisitor(){}

	@Override
	public void visit(Component c) throws Exception{
		System.out.println("TreeVisitor");
		this.body = c;
		String format = "+---";
		String indent = "";
		System.out.println(doVisit(c,format, indent) );
	}

	@Override
	public void clear(){
		str = "";
	}	

	public String doVisit(Component c, String format, String indent) throws Exception{
		//level order
		if(!isRoot(c)){
			str += indent + format;
			indent += "     ";
		}
		else{
			indent += " ";
		}
		str += "[";
		str += c;
		str += "]";

		str += "\n";
		Component[] children = c.getChildren();

		for(int i = 0; i != children.length; ++i){

			doVisit(children[i], format, indent);
		}
			
		return str;	
	}	

	private boolean isRoot(Component c){
		return c == body;
	}
}