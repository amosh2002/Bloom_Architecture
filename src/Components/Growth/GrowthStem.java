package Components.Growth;

import MainSTEM.Interfaces.IObserver;
import MainSTEM.Interfaces.ISubject;
import MainSTEM.Data.Photo;

import java.util.ArrayList;
import java.util.List;

public class GrowthStem implements ISubject {
    private final List<IObserver> observers = new ArrayList<>();
    private Photo photo;

    public void takePhoto() {
        this.photo = new Photo("initial_photo");
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
            observer.update(photo);
        }
    }
}
