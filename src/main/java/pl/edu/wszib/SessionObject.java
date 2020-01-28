package pl.edu.wszib;

import pl.edu.wszib.model.User;

public class SessionObject {
    private User user = null;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

}
