package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldFindTasksForSimpleTaskForTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Сходить в магазин");

        simpleTask.matches("магазин");

        boolean expected = true;
        boolean actual = simpleTask.matches("магазин");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksForSimpleTaskForFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Сходить в магазин");

        simpleTask.matches("магазин");

        boolean expected = false;
        boolean actual = simpleTask.matches("школа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksForEpicForTrue() {
        String[] subtasks = { "Масло", "Хлеб", "Сыр" };
        Epic epic = new Epic(33, subtasks);

        epic.matches("Сыр");

        boolean expected = true;
        boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksForEpicForFalse() {
        String[] subtasks = { "Масло", "Хлеб", "Сыр" };
        Epic epic = new Epic(33, subtasks);

        epic.matches("Сыр");

        boolean expected = false;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksForMeetingForTrue() {
        Meeting meeting = new Meeting(
                123,
                "Поход за продуктами",
                "Поездка в отпуск",
                "В четверг с утра"
        );

        meeting.matches("отпуск");

        boolean expected = true;
        boolean actual = meeting.matches("отпуск");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTasksForMeetingForFalse() {
        Meeting meeting = new Meeting(
                123,
                "Поход за продуктами",
                "Поездка в отпуск",
                "В четверг с утра"
        );

        meeting.matches("Выходной");

        boolean expected = false;
        boolean actual = meeting.matches("Выходной");

        Assertions.assertEquals(expected, actual);
    }
}
