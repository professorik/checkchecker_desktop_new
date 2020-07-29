package sample;

import java.util.function.Function;

public class TaskNikita {

    private Function<Void , Boolean> action;
    private String description;

    public boolean apply(){
        Void t = null;
        return action.apply(t);
    }

    public TaskNikita(Function<Void , Boolean> action , String description){
        this.action = action;
        this.description = description;
    }

    public Function<Void, Boolean> getAction() {
        return action;
    }

    public void setAction(Function<Void, Boolean> action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
