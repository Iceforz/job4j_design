package ru.job4j.hash;

import java.util.*;

public class User {
   private String name;
   private int children;
   private Calendar birthday;

   public User(String name, int children, Calendar birthday) {
      this.name = name;
      this.children = children;
      this.birthday = birthday;
   }

  @Override
   public int hashCode() {
      return Objects.hash(name, children, birthday);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      User user = (User) o;
      return children == user.children &&
              Objects.equals(name, user.name) &&
              Objects.equals(birthday, user.birthday);
   }

   public static void main(String[] args) {

      User one = new User("Ilya", 0, new GregorianCalendar(1997, 4, 30));
      User two = new User("Ilya", 0, new GregorianCalendar(1997, 4, 30));
      Map<User, Object> map = new HashMap<>();
      map.put(one, new Object());
      map.put(two, new Object());
      if (one.hashCode() == two.hashCode() && one.equals(two)) {
         System.out.println(map);
      } else if ( one.equals(two)) {
         System.out.println(123);
      }
   }
}

