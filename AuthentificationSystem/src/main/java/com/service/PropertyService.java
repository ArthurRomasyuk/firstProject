package com.service;

import com.model.Person;
import com.model.Role;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Alexandr on 07.08.2016.
 * Артур, а мы же вложенные классы еще не проходили?
 * Вроде бы нет)) ок, сейчас тогда обойдемся без них...сорри(
 */
public class PropertyService {
    public Person personsWithExistingRolesDB[] = new Person[0];

    public PropertyService() throws IOException {
        createPersonByPropertyFileDetails("/admin.properties", Role.ADMIN);
        createPersonByPropertyFileDetails("/user.properties", Role.USER);
    }

    private void createPersonByPropertyFileDetails(String propertyPath, Role role) throws IOException {
        //пробуем сначала выкачать проперти из соответст. файликов
        Properties properties = new Properties();
        properties.load(PropertyService.class.getResourceAsStream(propertyPath));
        personsWithExistingRolesDB = Arrays.copyOf(personsWithExistingRolesDB, personsWithExistingRolesDB.length + 1);
        //создаем объекты, которые будут хранить креды юезра и админа --- больше юзать проперти файлики нет необходимости, т.к
        //всю работу по считыванию инфы мы уже сделали -- в дальнейшем работаем только с базой personsWithExistingRolesDB
        Person personWithExistingRole = new Person(properties.getProperty("username"), properties.getProperty("password"), role);
        personsWithExistingRolesDB[personsWithExistingRolesDB.length - 1] = personWithExistingRole;
    }

    //давай теперь ты сам подумаешь, как сделать дальше --
    //у тебя есть 2 сервиса


    /**
     * этот сервис дает тебе возможность:
     * 1) вытянуть данные из проперти файликов -- сохранить все в условной базе
     * 2) ты можешь предусмотреть на этом уровне -- возвращение роли по юзернейму и паролю --
     *  либо
     *  оставить все как есть, а логику проверки перенести в сервис PersonAuthenticationService
     *
     *  в тесте ты будещь юзать один сервис PersonAuthenticationService, т.к по сути в
     *  PersonAuthenticationService ты будешь ссылаться на PropertyService
     *  идея ясна? или нет?
     *  пока что да, завтра попробую на деле реализовать
     *
     *  умница
     *  тогда пингуй если-что..
     *  Спасибо тебе большое)
     */

    public static void main(String[] args) throws IOException {
        PropertyService propertyService = new PropertyService();
        System.out.println(Arrays.toString(propertyService.personsWithExistingRolesDB));
    }

}
