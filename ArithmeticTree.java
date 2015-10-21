import java.util.Stack;

public class ArithmeticTree{
    private Component body;
    public ArithmeticTree() throws Exception{
            TreeVisitor v = new TreeVisitor();
            InfixVisitor v1 = new InfixVisitor();
            LispVisitor v2 = new LispVisitor();
            EvaVisitor v3 = new EvaVisitor();

            System.out.println("Test 1 -----");
            System.out.println("************");
            System.out.println("************");
            AddComponent a = new AddComponent( new NumberComponent(1), new NumberComponent(1));
            DivideComponent b = new DivideComponent( new NumberComponent( 2 ), a);
            this.body = new MultipleComponent( new NumberComponent( 4 ),b,  new NumberComponent( 5 ) ); 
            // 4 * (2 /(1+6)) *5
            // (*4 (/2(+13))5)
            request(v);
            System.out.println();
            request(v1);
            System.out.println();
            request(v2);
            System.out.println();
            request(v3);

            //clear
            v.clear();
            v1.clear();
            v2.clear();
            v3.clear();

            System.out.println();
            System.out.println("Test 2 -----");
            System.out.println("************");
            System.out.println("************");
            // This is the example given on the pdf
            this.body = new DivideComponent(new NumberComponent(1), new AddComponent(new NumberComponent(3), new NumberComponent(2), new MultipleComponent(new NumberComponent(9), new NumberComponent(11))));
            request(v);
            System.out.println();
            request(v1);
            System.out.println();
            request(v2);
            System.out.println();
            request(v3);                       

            //clear
            v.clear();
            v1.clear();
            v2.clear();
            v3.clear();

            System.out.println();
            System.out.println("Test 3 -----");
            System.out.println("************");
            System.out.println("************");
            //This is the harder example given on pdf
            //11 + ((1 / 2) * ((3 + -5) - 45)) + -23
            DivideComponent c = new DivideComponent(new NumberComponent(1), new NumberComponent(2));
            AddComponent d = new AddComponent(new NumberComponent(3), new NumberComponent(-5));
            AddComponent f = new AddComponent(d, new NumberComponent(-45));
            MultipleComponent e = new MultipleComponent(c,f);
            this.body = new AddComponent(new NumberComponent(11), e, new NumberComponent(-23));
            request(v);
            System.out.println();
            request(v1);
            System.out.println();
            request(v2);
            System.out.println();
            request(v3);  
    } 

    public int calculate() throws Exception{
        throw new Exception("No");
    };
    public int getValue(){
        return 0;
    };
    public void request(Visitor v) throws Exception{
        v.visit(body);
    }

	public static void main(String args[]){
       try {
            ArithmeticTree tmp = new ArithmeticTree();        	    
            } catch (Exception e){
                e.printStackTrace(System.out);
            }		
	}

}