# language: ru

@withdrawal
Функция: Проверка поисковой выдачи первого товара из выдачи товаров по фильтрам

  @firstTest
  Сценарий: Сценарий №1
    * Кликнуть на кнопку 'Каталог'
    * Навести курсор мыши на меню: "Комплектующие для ПК"
    * Кликнуть на подменю: "Видеокарты"
    * Ввод в поле 'Минимальная цена' значения: "20000"
    * Проверка что фильтр "Цена" применился
    * Кликнуть на чекбокс: "Gigabyte"
    * Проверка что фильтр "Производитель" применился
    * Проверка, что на странице отображается "24" товара
    * Выполнить поиск товара № 1 из списка выданных товаров, проверить что в поисковой выдачи ровно 1 товар и его наименование соответствует сохраненному значению

  @secondTest
  Сценарий: Сценарий №2
    * Кликнуть на кнопку 'Каталог'
    * Навести курсор мыши на меню: "Периферия"
    * Кликнуть на подменю: "Клавиатуры"
    * Ввод в поле 'Минимальная цена' значения: "2000"
    * Проверка что фильтр "Цена" применился
    * Кликнуть на чекбокс: "A4Tech"
    * Проверка что фильтр "Производитель" применился
    * Проверка, что на странице отображается "24" товара
    * Выполнить поиск товара № 1 из списка выданных товаров, проверить что в поисковой выдачи ровно 1 товар и его наименование соответствует сохраненному значению
