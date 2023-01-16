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

### Для теста просто скопируйте и вставьте следующие команды в shell

    add_category comps
    add_category monics
    add_category mouses


    add_position 2 dell шт. 8000 5
    add_position 2 acer шт. 6000 4
    add_position 2 lg шт. 7000 3
    add_position 2 sony шт. 9000 0

### Если в консоли крякозабры
[Stackoverflow в помощь](https://ru.stackoverflow.com/questions/1258031/%D0%9D%D0%B5-%D0%BE%D1%82%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B0%D0%B5%D1%82%D1%81%D1%8F-%D0%BA%D0%B8%D1%80%D0%B8%D0%BB%D0%B8%D1%86%D0%B0-%D0%B2-%D0%BA%D0%BE%D0%BD%D1%81%D0%BE%D0%BB%D0%B8)