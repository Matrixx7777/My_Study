package my.task.envelo.second.second;

import java.util.ArrayList;

public class PinCreator {

    private static final int userCount = 50;
    private static final int pinLength = 12;

    User[] users = new User[userCount];
    ArrayList<User> userWithoutPins = new ArrayList<>();

    public void generatePinsForAllUsers(){
        for (int i = 0; i <= userCount; i++) {
            users[i].setPin(generatePin());
        }
    }

    public void setUserPinById(Integer userId, String pin){
        for (int i = 0; i < userCount; i++) {
            if(users[i].getId().equals(userId)){
                users[i].setPin(pin);
            }
        }
        for (User user : userWithoutPins) {
            userWithoutPins.remove(user);
        }
    }

    public void setUserPin(User user, String pin){
        new User(user.getName(), user.getId(), pin);
    }

    public boolean isCharPositive(char c){
        int x = Character.compare(c, (char) 0);
        if(x>0) return c > 0;
        else if(x<0) return false;
        else return c == 0;
    }

    public static String generatePin(){
        StringBuilder pin = new StringBuilder();
        int rand;
        for (int i = 0; i < PinCreator.pinLength; i++) {
            rand = (int) (Math.random() * 10);
            pin.append(rand);
        }
        return pin.toString();
    }

    public boolean isPinSameAsOld(User user, String newPin){
        return newPin.equals(user.getPin());
    }

    public Boolean hasEveryoneGotPin(){
        int counter = 0;
        try{
            for (int i = 0; i < userCount; i++) {
                if(users[i].getPin() != null) {
                    counter++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (counter == userCount);
    }

    public double percentageOfUserWithPins() {
        int counter = 0;
        int result;
        for (int i = users.length - 1; i >= 0; i--) {
            if(users[i].getPin() != null){
                counter++;
            }
        }
        result = (counter/userWithoutPins.size()) * 100;
        return result;
    }
}