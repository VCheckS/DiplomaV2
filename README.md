1. Установить docker на PC
2. Пройти регистрацию на сайте https://www.docker.com/
3. Авторизоваться в desktop docker 
4. В терминале в IntelijiIdea ввести команду "docker-compose up Дождаться загрузки и запуска всех контейнеров. 
5. Запутить jar файл aqa-shop.jar через терминал выполнив команду "java "-Dspring.datasource.url=jdbc:postgressql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar aqa-shop.jar
   ". 
6. В терминале вводим команду ./gradlew allureServe. 
7. Затем вводим в терминал команду "./gradlew test -Dt.postgres=postgres" для проверки тестов с БД postgres.
7. Затем выполняем останавливаем jar приложение в терминале нажатием кнопок ctrl+c. Водим команду "java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar aqa-shop.jar
8. вводим в терминал команду "./gradlew test -Dt.sql=sql" проверяем работу с БД sql.
