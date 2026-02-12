package org.moraes.sidequests.factorys;

import org.moraes.sidequests.DTOs.TaskDTO;
import org.moraes.sidequests.domain.tasks.DailyTask;
import org.moraes.sidequests.domain.tasks.QuinquenniallyTask;
import org.moraes.sidequests.domain.tasks.YearlyTask;
import org.moraes.sidequests.interfaces.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskFactory {


    public static Task taskFactory(TaskDTO dto) {
        Task t = null;
        switch (dto.identifier()){
            case DAILY -> t = new DailyTask(dto.name(), dto.description(), dto.identifier());
            case YEARLY -> t = new YearlyTask(dto.name(), dto.description(), dto.identifier());
            case QUINQUENNIALLY -> t = new QuinquenniallyTask(dto.name(),dto.description(),dto.identifier());
        }

        return t;
    }
}
