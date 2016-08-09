package com;

        import com.model.Person;
        import com.model.Role;
        import com.service.PersonAuthenticationService;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Arrays;
        import java.util.Properties;
        import java.util.Scanner;

/**
 * Created by Alexandr on 29.07.2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PersonAuthenticationService newMemberBD = new PersonAuthenticationService();
        Properties properties = new Properties();
        PersonAuthenticationService personAuthenticationService = new PersonAuthenticationService();

        System.out.println("How much persons do you want to input?");
        int personNumber = scanner.nextInt();
        for (int a = 0; a < personNumber; a++) {
            System.out.println("");
            System.out.println("Please input person name");
            String name = scanner.next();
            System.out.println("Please input person password");
            String password = scanner.next();

            /**
             *первоначально: давай определимся с логикой, которая дублируется
             * что вижу я-- ты запрашиваешь данные с клавиатуры, и на базе этих данных пробуешь создать своего юзера(персону)
             * но при этом дублируешь следующие действия
             *  newPerson.setPersonName (name);
             newPerson.setPersonPassword (password);
             newMemberBD.addNewPerson(newPerson);
             по сути -- было бы неплохо изначально проверить есть ли креды, после чего создать юзера, и на базе кред
             определить его роль

             то-есть нужен сервис, который сможет вытянуть данные из проперти файлов, - сохранить это все в условной базе
             и когда потребуется создать юзера -- даст возможность сравнить с теми данными, которые пришли к тебе с клавиатуры(ввода в
             риал тайм)

             то-есть
             1) создай сущность UserCredentialsDetails --> которая будет содержать у тебя следующие типы полей
             username
             password
             role
             2) когда создаешь enu, Role --> попробуй юзать UserCredentialsDetails в качестве объекта, который будет хранить у тебя
             2.1 креды юзера + роль
             2.2 основной скоуп ролей --- покажу тебе пример, чтобы было понятнее
             3) создай отдельн. сервис, который будет принимать у тебя объект типа UserCredentialsDetails(то-есть заполнение имя, пароль --
             клавиатура), а определение роли--работа самого сервиса
             можешь создать метод в сервисе на подобии: getUserRoleVyUserNameAndPassword, именно в этом сервисе, в случае, если у тебя
             креды не совпдаут с админскими или юзерскими правами -- пробрасывай ошибку
             4) в сервисе для аутентификации предусмотри базу(обычный массив твоих персон), в случае удачного/успешного прохождения
             аутентификации(определения роли) -- добавляй персону в базу(массив)
             *
             */
/**
 * есть 2 вварианта:
 * 1) отдельный сервис для считывания, либо можно сделать это напрямую в енам
 * то-есть
 *
 */
            Person newPerson = new Person(name, password, personAuthenticationService.getUserRoleVyUserNameAndPassword(name, password));
            newMemberBD.addNewPerson(newPerson);
        }

        System.out.println(Arrays.toString(newMemberBD.getPersonBD()));

//        Person [] db = newMemberBD.getPersonBD();
//        for(Person fm : db) {
//
//           fm.function(); //это полиморфизм
//        }
//    }
    }
}
