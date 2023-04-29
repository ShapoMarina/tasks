package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Сходить в магазин");

        String[] subtasks = {"масло", "хлеб", "Сыр"};
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                123,
                "Поход за продуктами",
                "Поездка в отпуск",
                "В четверг с утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("Сыр");

        Task[] expected = {epic};
        Task[] actual = todos.search("Сыр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Сходить в магазин и купить сыр");

        String[] subtasks = {"масло", "хлеб", "сыр"};
        Epic epic = new Epic(33, subtasks);

        Meeting meeting = new Meeting(
                123,
                "Дописать сыр в список",
                "Список продуктов",
                "В четверг с утра"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("сыр");

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("сыр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанк",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        todos.search("сыр");

        Task[] expected = {};
        Task[] actual = todos.search("сыр");
        Assertions.assertArrayEquals(expected, actual);
    }
}