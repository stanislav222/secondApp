## Second application 
#### Проблемы
+ >Пункт "Конвертировать xml с помощью xslt" <br/>
  >
Не понял как это в принципе должно выглядеть. 
Так что просто распарсил страницу и достал нужные поля. <br/>

* Не получилось предварительно добавить бакет в кластер, закомментировал кусок кода `CouchbaseConfig.class`
как я понял есть конфликт библиотек со спринговым стартером (в отдельном проекте все работает)
поэтому придётся вручную.
####Запуск
* `sh start` в папке с проектом 
* Зайти в админку http://localhost:8091 выполнить дефолтные настройки добавить bucket `client`
    * username: Administrator
    * password: 123456
* зайти в query выполнить запрос ``"CREATE PRIMARY INDEX `#primary` on `client`"``
* Админка RabbitMq http://localhost:8083/ логин\пароль guest
* Только после всего перечисленного выше запустить `java -jar ./target/*jar` в папке с проектом
* Результат работы вывожу в консоль `docker logs -f docker logs -f <Name contener>`
* `sh stop`, чтобы остановить
###ps
Скрипты шеловские `start, stop` используют docker-compose если не установлен то вот 
* `docker run -d --name db -p 8091-8094:8091-8094 -p 11210:11210 couchbase`
* `docker run -d --hostname my-rabbit --name some-rabbit -p 8082:15672 rabbitmq:3-management`
