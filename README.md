# test-task
Test task. Voiting server application

"Приложение-голосовалка"

Написать серверное standalone приложение со следующим функционалом : 
1) создает темы для голосования,
2) Старт голосования с генерацией ссылки для голосования 
3) Закрытие голосования 
4) Отображение статистики (в виде Выбранный пункт - количество)
5) Получение данных о голосовании (по сгенерированной ссылке)
6) Регистрация голоса

С сервером общение посредством REST API, данные в формате Json.

Обязательные технологии: Java8, Spring boot

Система контроля версий: Git

1. Создание темы для голосования: POST запрос по url /question/create, список ответов не ограничен.
2.  Старт голосования с генерацией ссылки для голосования: Ссылка по-моему мнению должна генерироваться на клиентской стороне.
3. Закрытие голосвания: PUT запрос по url /question/{id}/disable, передается id вопроса, который достается из базы и устанавливается false значение на поле enabled.
4. Отображение статистики (в виде Выбранный пункт - количество): GET запрос по url question/{questionId}/answer/{id}/statistics, по данному запросу извлекается количество пользователей выбравших ответ с id=answerId.
5. Получение данных о голосвании: GET запрос по url /question/{id}, извлекаются такие данные как: description(описание вопроса), enable(является ли данный вопрос актуальным), answers(список ответов).
6. Регистрация голоса: POST запрос по urh question/{questionId}/user/{id}/answer/{answerId}, где в объекта ответа добавляется в список пользователей проголосоваший пользователь и пользователю добавляется его выбранный ответ.
