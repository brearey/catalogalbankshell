# Тестовое задание на вакансию BACKEND-JAVA

### Описание
> Интерактивное консольное приложение для управления товарами и их категориями в каталоге

### Поддерживаемые команды и комментарии к ним `help`

> `help` Посмотреть доступные команды
> 
> `quit` Выйти из приложения
> 
> `get_catalog` Получить список категорий `get_catalog`
> 
> `add_category` Добавить категорию `add_category компьютеры`
> 
> `get_category` Получить список позиций в категории с ID `get_category 1`
> 
> `delete_category` Удалить категорию по его ID `delete_category 1`
> 
> `add_position` Добавить позицию в категорию `add_position [ID категории] [название позиции] [едицина измерения] [стоимость] [количество]`
> 
> `rename_category` Переименовать категорию по его ID `rename_category 1 мониторы`
> 
> `delete_position` Удалить позицию из категории `delete_position [ID категории] [ID позиции]`
> 
> `add_position_count` Добавить количество позиции в категорию `add_position_count [ID категории] [ID позиции] [количество]`
> 
> `sub_position_count` Вычесть количество позиции из категории `sub_position_count [ID категории] [ID позиции] [количество]`
> 
> `set_position_price` Задать стоимость позиции в категории `set_position_price [ID категории] [ID позиции] [стоимость]`
> 
> `export_demo` Экспорт команд для демонстрационного приложения в txt файл `export_demo`

### Аргументы
> Если в аргументе присутствуют пробелы, то аргумент нужно писать в двойных кавычках, например `add_category "Клавиатуры и мыши"` 

### Для теста просто скопируйте и вставьте следующие команды в shell

    add_category Компьютеры
    add_category Мониторы
    add_category "Клавиатуры и мыши"


    add_position 1 Corei3 шт. 8000.00 12
    add_position 1 Corei5 шт. 11000.00 8
    add_position 1 Corei7 шт. 18000.00 4


    add_position 2 Dell шт. 8000.00 5
    add_position 2 Acer шт. 6000.00 4
    add_position 2 LG шт. 7000.00 3
    add_position 2 Sony шт. 9000.00 0
    add_position 2 Apple шт. 49990.50 0


    add_position 3 Logitech уп. 1500.00 10
    add_position 3 Oclick уп. 1400.50 27
    add_position 3 Genius уп. 1300.50 25
    add_position 3 Razor уп. 3500.00 12
    add_position 3 Aceline уп. 799.50 32
    add_position 3 DEXP уп. 1250.50 24

### Если в консоли крякозабры
[Stackoverflow в помощь](https://ru.stackoverflow.com/questions/1258031/%D0%9D%D0%B5-%D0%BE%D1%82%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B0%D0%B5%D1%82%D1%81%D1%8F-%D0%BA%D0%B8%D1%80%D0%B8%D0%BB%D0%B8%D1%86%D0%B0-%D0%B2-%D0%BA%D0%BE%D0%BD%D1%81%D0%BE%D0%BB%D0%B8)