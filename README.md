# NewMagazineProject

Web-приложение с JSP и сервлетами. Реализует базовую регистрацию, вход, роли пользователей и админ-панель, добавление корзины и удаление из неее

## ⚙️ Технологии

- Java 8+
- JSP / Servlets
- MySQL (через phpMyAdmin)
- Apache Tomcat
- HTML, CSS
- MAMP (только для MySQL)
- Git

## 📁 Структура проекта
NewMagazineProject/ 
├── src/ # Java-код (сервлеты и утилиты) │ └── com/example/webshop/ ├── web/ # JSP страницы │ ├── index.jsp │ ├── login.jsp │ └── register.jsp ├ ── WEB-INF/ # Конфигурация веб-приложения │ └── web.xml ├── lib/ # Внешние библиотеки (если есть)├ ── .gitignore └── README.md

## 🛠 Установка

1. Убедитесь, что установлен [Apache Tomcat](https://tomcat.apache.org/) и Java (8+).
2. Создайте базу данных `shopdb` в `phpMyAdmin` (через MAMP).
3. Соберите проект в `.war` или откройте в IntelliJ/Eclipse.
4. Разверните в `webapps` Tomcat.
5. Перейдите на `http://localhost/NewMagazineProject/`.

## 🧩 Авторизация

- Роли: пользователь, админ
- Регистрация и вход реализованы через форму + подключение к MySQL

## 📜 Лицензия

MIT License