package clipsAgents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.Environment;

public class AgenteClips extends Agent {

  Environment clips;

  protected void setup() {
    try{
    	clips = new Environment();
    }catch (Exception e) {}
    addBehaviour(new TellBehaviour());
    addBehaviour(new AskBehaviour());
  } 

  private class TellBehaviour extends Behaviour {
    boolean tellDone = false;
    
    public void action(){
        try{
        clips.eval("(clear)");
	clips.load("resources/persons/load-persons.clp");
	clips.load("resources/persons/load-persons-rules.clp");
        
	//clips.load("resources/market/templates.clp");
	//clips.load("resources/market/facts.clp");
        //clips.load("resources/market/persons.clp");
        //clips.load("resources/market/rules.clp");

	//clips.load("resources/prodcust/load-prod-cust.clp");
	//clips.load("resources/prodcuts/load-prodcust-rules.clp");
        } catch (Exception e) {}
	tellDone = true;
    }
   
    public boolean done() {
      if(tellDone)
	return true;
      else
	return false;
    } 
  } 


  private class AskBehaviour extends Behaviour {
    boolean askDone = false;
    
    public void action(){
        try{
	clips.eval("(reset)");
	clips.run();

        } catch (Exception e) {}
        
	askDone = true;
    }
   
    public boolean done() {
      if(askDone)
	return true;
      else
	return false;
    }

    public int onEnd(){
      myAgent.doDelete();
      return super.onEnd();
    } 
  } 
}
