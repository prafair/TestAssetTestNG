# TestAssetTestNG
Tests for iknow.itravel 

Сами тесты находятся здесь:
https://github.com/prafair/TestAssetTestNG/blob/master/src/test/java/tests/RegistrationAndUploadLogoTest.java

1) По генерации e-mail решил использовать возможности gmail.com
была идея открывать сайт с генерацией e-mail и копировать оттуда, но решил что зависимость от сайта - плохо, мало ли он упадёт или ещё чего случится

2) Была проблема как обычно со Stale Reference Element, решил использовать метод retryingFindClick(), чтобы от этого избавиться
Обычно в Robot Framework эта проблема решалась многократным повторением кейворда до её успеха
Может быть можно как-то по-другому это сделать

3) Хотел сделать проверку загруженного логотипа скачиванием его и сравнением с помощью библиотеки SikuliX
Не очень получилось, возможно как-то по-другому надо проверять картинку

4) Всё равно как-то более наглядно хотел сделать, слишком много мелких действий в тесте мелькает
Надо создавать что-то типа файла для ресурсов и оттуда брать все нужные методы для теста

5) Уже походу сейчас понял, что надо больше проверок добавлять, например, в поля ввода email и пароля, сразу чекать что ввелось в input'ы

6) Вообще интересное задание, больше всего застрял на сравнении картинок и Stale Reference Element (вместо этого для наглядности порой использовал sleep, что не очень хорошо)
Но всё-таки оставил один sleep для загрузки файла
      