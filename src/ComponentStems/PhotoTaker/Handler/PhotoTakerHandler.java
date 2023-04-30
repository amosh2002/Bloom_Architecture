package ComponentStems.PhotoTaker.Handler;

import ComponentStems.PhotoTaker.Data;
import ComponentStems.PhotoTaker.PhotoTaker;
import MainStem.Interfaces.IObserver;
import MainStem.Interfaces.ISubject;

import java.util.ArrayList;
import java.util.List;

public class PhotoTakerHandler implements ISubject {
    private final List<IObserver> observers = new ArrayList<>();
    private Data data;

    @Override
    public void registerObserver(IObserver observer) {
        data = new PhotoTaker().takePhoto();
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(data.getPhoto());
        }
    }
}
