JAVA SWIMMING POOL SIMULATOR
Quentin Van de Kadsye and Jérôme Tanghe
11/3/2014

==== Introduction ====
This software simulates the evolution of different persons who want to go to the
swimming pool. The algorithm is based on the actions and pools of data.

==== Architecture ====
The project contains an unique interface, Resource, that defines a method to
implement to the resource classes. This method just returns a description of
the object.

==== Code Sample ====
The FairScheduler.doStep() method uses a currentAction class attribute to know
on which action we were at the previous call of this method.

    // At the construction of the object, currentAction is set to -1.
    currentAction++;

    // ...

    if(!this.getAction(currentAction).isFinished()) {
    
        try {
            
              this.getActions().get(this.currentAction).doStep();
            
	      if(this.getActions().get(this.currentAction).isFinished()) {
                  
		  // When an action is finished, it is removed from the list of
		  // actions to treat. So currentAction has to be devremented to
		  // be sure that the next action will be those that follows the
		  // action we just removed.
	          this.getActions().remove(this.currentAction);
	          currentAction--;
	                
	     }
             // ...  
        }
	// ...
    }


