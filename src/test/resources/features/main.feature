Feature: Навигация по сайту localhost

  Scenario: Вход в личный кабинет
    Then Выбираем меню "Войти"
    Then Вводит данные в поле логин
    Then Вводим данные в поле пароль
    Then Нажимаем на кнопку "Войти"
    Then Контент с фразой "Привет" отображается