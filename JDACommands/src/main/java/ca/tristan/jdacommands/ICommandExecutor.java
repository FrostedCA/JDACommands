package ca.tristan.jdacommands;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;

public interface ICommandExecutor {

    void execute(Command event);

    String getName();

    String helpMessage();

    boolean needOwner();

    default Role canUse(Guild guild){
        return guild.getPublicRole();
    }

}
