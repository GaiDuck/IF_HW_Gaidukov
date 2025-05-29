# IF_Gaidukov

Проект автоматизирует регрессионные тестовые сценарии для веб-страницы Jira.

Используемые технологии:

1. Java 17
2. Junit 5 - тестовый фреймворк
3. Selenide - надстройка над Selenium webDriver
4. Allure - для формирования удобных отчетов
5. Maven - сборщик проекта

Структура проекта:

1. В папке *src/main/java/org/ifellow/gaidukov/IF_HW/pages* расположены классы, содержащие объекты страниц и методы
   взаимодействия с ними.
2. В папке *src/main/java/org/ifellow/gaidukov/IF_HW/PropertyProcessor* расположен класс **PropertyProcessor**,
   отвечающий за считывание данных из файла **Allure.properties**
3. В папке *src/test/java/org/ifellow/gaidukov/IF_HW* расположен класс **JiraTest**, содержащий все запускаемые тесты.
4. В папке *src/test/java/org/ifellow/gaidukov/IF_HW* расположен класс **WebHooks**, содержащий настройки webDriver и
   скрипты, запускаемые до и после прогона тестов.
5. В папке *src/test/resources* расположен файл **Allure.properties**, содержащий настройки Allure и некоторые
   константы, необходимые для тестирования.

Команды:

1. Сборка и запуск всех тестов:              
   `mvn clean test`
2. Генерация Allure-отчёта
   `mvn allure:report`
3. Отображение Allure-отчета (откроет отчёт в браузере)      
   `mvn allure:serve`  
