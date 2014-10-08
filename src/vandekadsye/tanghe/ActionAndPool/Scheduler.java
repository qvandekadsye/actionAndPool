public class Scheduler extends Action {

    protected List<Action> actions;
    
    public Scheduler() {
    
        actions = new ArrayList<Action>();
    
    }
    
    public Scheduler(List<Action> actions) {
    
        this.actions = actions;
    
    }
    
    public abstract void doStep();
    
    public List<Action> getActions() {
    
        return actions;
    
    }
    
    public void addAction(Action a) {
    
        actions.add(a);
    
    }
    
    public boolean isFinished() {
    
        return actions.isEmpty();
    
    }

}
