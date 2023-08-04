1. Установить docker на PC
2. Пройти регистрацию на сайте https://www.docker.com/
3. Авторизоваться в desktop docker 
4. В терминале в IntelijiIdea ввести команду "docker-compose up". Дождаться загрузки и запуска всех контейнеров. 
5. Запустить jar файл aqa-shop.jar через терминал выполнив команду "java "-Dspring.datasource.url=jdbc:postgressql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar aqa-shop.jar
   ".
6. Затем ввести в терминал команду "./gradlew test -Durl=jdbc:postgresql://localhost:5432/app -Dlogin=app -Dpassword=pass allureserve" для проверки тестов с БД postgres.
7. Затем выполнить остановку jar приложение в терминале командой  ctrl+c. Ввести команду "java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar aqa-shop.jar
8. Затем ввести в новое окно в терминал команду "./gradlew test -Durl=jdbc:mysql://localhost:3306/app -Dlogin=app -Dpassword=pass allureserve" для проверки тестов с БД sql.

