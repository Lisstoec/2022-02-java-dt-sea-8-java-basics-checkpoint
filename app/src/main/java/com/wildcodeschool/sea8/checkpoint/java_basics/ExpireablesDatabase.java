package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class ExpireablesDatabase<E extends IExpireable> {
    private List<E> listOfExpireables = new ArrayList<>();

    public void addItem(E item) {
        // TODO: add a new item to the list

        listOfExpireables.add(item);

    }

    public void removeExpired() {
        // TODO: implement the neccessary function to delete all expired entries from the list

        for (E element : listOfExpireables){
            if  (element.isExpired()){
                listOfExpireables.remove(element);
            }
        }
    }

    public void sortByExpirationDate(boolean descending) {
        // TODO: sort the list by the expiration date of it's entries
        // hint: use a comparator and expiryDate()

        Comparator<E> compareByExpiryDate;

        if (descending) compareByExpiryDate = Comparator.comparing(E::expiryDate).reversed();
        else compareByExpiryDate = Comparator.comparing(E::expiryDate);
        
        listOfExpireables.sort(compareByExpiryDate);
    }

    public E getFirstEntry() {
        // TODO: Return first item in the list

        return listOfExpireables.get(0);

    }

    public E getLastEntry() {
        // TODO: Return last item in the list

        return listOfExpireables.get(listOfExpireables.size()-1);
        
    }

    public List<E> getList() {
        return listOfExpireables;
    }

}
