package Components.Editor;

import MainSTEM.Interfaces.IObserver;
import MainSTEM.Interfaces.ISubject;
import MainSTEM.Data.Photo;

import java.util.ArrayList;
import java.util.List;

public class EditorStem implements IObserver, ISubject {
    private List<IObserver> observers = new ArrayList<>();
    private Photo editedPhoto;

    @Override
    public void update(Object data) {
        if (data instanceof Photo) {
            editPhoto((Photo) data);
        }
    }

    public void editPhoto(Photo photo) {
        // Apply edits to the photo
        // ...

        // Update the editedPhoto instance variable
        editedPhoto = photo; // Assuming the original photo is modified

        // Notify observers with the edited photo
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(editedPhoto);
        }
    }
}