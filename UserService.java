import java.util.HashSet;
import java.util.Set;

class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message){
        super(message);
    }
}
class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
public class UserService {
    private Set<String> users= new HashSet<>();
    public void setUsers(String username) throws UserAlreadyExistsException {
        if(users.contains(username)){
            throw new UserAlreadyExistsException("user already exists: " + username);
        }
        users.add(username);
        System.out.println("user registered sucessfully: " + username);
    }
    public void checkuserExistence(String username) throws UserNotFoundException{
        if(!users.contains(username)){
            throw new UserNotFoundException("user not found: " + username);
        }
        System.out.println("user exists: " + username);
    }

    public static void main(String[] args) {
        UserService userService=new UserService();
        try{
            userService.setUsers("Rinky");
            userService.setUsers("Rinky");
        }catch(UserAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
        try{
            userService.checkuserExistence("Rinky");
        }catch(UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
