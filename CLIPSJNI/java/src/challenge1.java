package clips;

import net.sf.clipsrules.jni.Environment;

public class challenge1 {
    public static void main(String[] nocusa) throws Exception {

            Environment clips; 

            clips = new Environment();

            clips.eval("(clear)");
            clips.load("resources/personas.clp");
 
	    clips.eval("(reset)");
		
	    clips.run();
    }
}