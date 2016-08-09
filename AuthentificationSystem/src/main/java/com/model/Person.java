package com.model;

/**
 * Created by Alexandr on 29.07.2016.
 */
public class Person {
    private String personName;
    private String personPassword;


    /**
     * все хорошо, только даввай не будем мешать мух с котлетами)
     * юзер -- будет юзером(персона -- персоной), роли -- ролями
     * юзер - обычный класс
     * роли -- перечисление
     * а как отличаетсяРоль от Юзера? по факту Юзер и есть Роль, можно же его объектом роли считать?
     * юзер -- это полноценный объект, основная цель которого -- это сохранять нужную инфу(набор атрибутов) -- твоя персистентность
     * роль - это просто атрибут, еще одна характеристика, не более того
     * максимум что можно и нужно делать в пределах перечисления - енама, это определять роль по кредам юзера, или по др. характеристикам
     * <p>
     * юзер должен быть чистой моделью
     * роль для юзера -- будет просто обычным полем
     * <p>
     * просто класс юзер и роль - находятся на разных уровнях применения: роль -- должен апплаится только к юзеру -- как отдельн..
     * характеристика
     * сам юзер -- понятие более общее и глобальное, поэтому мы и разделяем атрибуты/характериситки от самих объектов, оставляя
     * роль лишь полем
     */

    private Role role;

    public Person(String personName, String personPassword, Role role) {
        this.personName = personName;
        this.personPassword = personPassword;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personPassword='" + personPassword + '\'' +
                ", role=" + role +
                '}';
    }
}
