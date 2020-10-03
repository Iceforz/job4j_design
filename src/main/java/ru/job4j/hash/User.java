package ru.job4j.hash;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class User {
   private String name;
   private int children;
   private Calendar birthday;

   public User(String name, int children, Calendar birthday) {
      this.name = name;
      this.children = children;
      this.birthday = birthday;
   }

   public static void main(String[] args) {
      User one = new User("Ilya", 0, new GregorianCalendar(1997, 4, 30));
      User two = new User("Ilya", 0, new GregorianCalendar(1997, 4, 30));
      Set<User> map = new HashSet<>();
      map.add(one);
      map.add(two);
      if (one.equals(two)) {
         System.out.println(map);
      } else {
         System.out.println(123);
      }
   }
}
