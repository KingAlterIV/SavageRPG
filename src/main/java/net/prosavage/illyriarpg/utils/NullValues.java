package net.prosavage.illyriarpg.utils;

public class NullValues {

    public Object replaceNullValues(Object object){
        if (object.equals("null") || object.equals(0) || object.equals(0.0)){
            object = " ";
        }
        return object;
    }

    public boolean checkForNullValues(Object object) {
<<<<<<< HEAD
        return object == null || object.equals("null") || object.equals(-1) || object.equals(-1.0) || object.equals("") || object.equals(" ");
=======
        return object == null || object.equals("null") || object.equals(0) || object.equals(0.0)
                || object.equals("") || object.equals(" ");
>>>>>>> 9bc3217... Finished armor creation and cleaned up more things
    }

}
